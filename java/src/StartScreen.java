import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartScreen extends JFrame {

    JButton startButton;
    JButton settingsButton;
    JButton stopButton;
    
    final private Driver dr;
    final private JFrame jf;

    public StartScreen(Driver driver, JFrame jframe) {

        setTitle("Start screen");
        setSize(700, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        URL location = StartScreen.class.getProtectionDomain().getCodeSource()
                .getLocation();
        String imageLocation = location.getFile();

        //setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon(imageLocation
                + "Images/StartscreenBackground.png")));
        //setLayout(new FlowLayout());
        setLayout(null);

        startButton = new JButton("Start game");
        startButton.setBackground(Color.RED);
        startButton.setForeground(Color.WHITE);
        startButton.setFont(new Font("Calibri", Font.BOLD, 30));
        startButton.setOpaque(true);
        startButton.setBounds(55, 300, 250, 60);

        settingsButton = new JButton("Settings");
        settingsButton.setBackground(Color.RED);
        settingsButton.setForeground(Color.WHITE);
        settingsButton.setFont(new Font("Calibri", Font.BOLD, 30));
        settingsButton.setOpaque(true);
        settingsButton.setBounds(55, 400, 250, 60);

        stopButton = new JButton("Exit");
        stopButton.setBackground(Color.RED);
        stopButton.setForeground(Color.WHITE);
        stopButton.setFont(new Font("Calibri", Font.BOLD, 30));
        stopButton.setOpaque(true);
        stopButton.setBounds(55, 500, 250, 60);
        
        dr = driver;
        jf = jframe;

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent startGame) {
                setVisible(false);
                dispose();
                dr.startGame(jf);
            }
        });

        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent closeScreen) {
                setVisible(false);
                dispose();
            }
        });

        add(startButton);
        add(settingsButton);
        add(stopButton);

        setSize(699, 699);
        setSize(700, 700);

    }

    public static void main(String args[]) {

    }
}