package game.screens;

import game.Driver;
import game.Settings;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Class that will create a winning screen.
 * @author Boning
 *
 */
public class WinningScreen extends JFrame {

    JButton playAgainButton;
    JButton settingsButton;
    JButton stopButton;
    final private Driver dr;
    JFrame gameFrame;

    /**
     * Constructor for the winning screen class.
     * @param driver where the screen comes from
     * @param name of the player
     */
    public WinningScreen(Driver driver,  final String name) {

        setTitle("You won!");
        setSize(Settings.getScreenWidth(), Settings.getScreenHeight());
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setVisible(true);
        
        URL location = StartScreen.class.getProtectionDomain().getCodeSource().getLocation();         
         setVisible(true);

         
        String imageLocation = location.getFile();
        imageLocation = imageLocation.replace("%20", " ");
        imageLocation = imageLocation.replace("target/classes/", "src/");

        setContentPane(new JLabel(new ImageIcon(imageLocation
                + "main/Images/winScreenBackground.png")));

        setLayout(null);

        playAgainButton = new JButton("Play again");
        playAgainButton.setBackground(Color.PINK);
        playAgainButton.setForeground(Color.WHITE);
        playAgainButton.setFont(new Font("Calibri", Font.BOLD, 30));
        playAgainButton.setOpaque(true);
        playAgainButton.setBounds(Settings.getScreenWidth() / 2 + 70, Settings.getScreenHeight() / 2 - 52, 350, 75);

        stopButton = new JButton("Exit");
        stopButton.setBackground(Color.PINK);
        stopButton.setForeground(Color.WHITE);
        stopButton.setFont(new Font("Calibri", Font.BOLD, 30));
        stopButton.setOpaque(true);
        stopButton.setBounds(55, 350, 350, 75);
        

        dr = driver;

        playAgainButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent playAgainGame) {
                setVisible(false);
                dr.setupGame();
                dr.startGame(name);
                dispose();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent closeScreen) {
                setVisible(false);
                dispose();
                dr.setupGame();
            }
        });

        setResizable(false);
        
        add(playAgainButton);
        add(stopButton);
        
        setSize(Settings.getScreenWidth() - 1, Settings.getScreenHeight() - 1);
        setSize(Settings.getScreenWidth(), Settings.getScreenHeight());
    }

}
