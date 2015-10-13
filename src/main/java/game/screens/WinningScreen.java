package game.screens;

import game.Driver;
import game.NormalDriver;
import game.Settings;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Class that will create a winning screen.
 * 
 * @author Boning
 *
 */
public class WinningScreen extends JFrame {
    JButton stopButton;

    /**
     * Constructor for the winning screen class.
     * 
     * @param driverInput
     *            where the screen comes from
     * @param name
     *            of the player
     */
    public WinningScreen(Driver driverInput, final String name) {
        setTitle("You won!");
        setSize(Settings.getScreenWidth(), Settings.getScreenHeight());
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        addBackgroundImage();
        addStopButton();
        setSize(Settings.getScreenWidth() - 1, Settings.getScreenHeight() - 1);
        setSize(Settings.getScreenWidth(), Settings.getScreenHeight());
    }

    /**
     * Add the stop button to the screen.
     */
    public void addStopButton() {
        stopButton = new JButton("Exit");
        stopButton.setBackground(Color.PINK);
        stopButton.setForeground(Color.WHITE);
        stopButton.setFont(new Font("Calibri", Font.BOLD, 30));
        stopButton.setOpaque(true);
        stopButton.setBounds(205, 350, 550, 75);
        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent closeScreen) {
                setVisible(false);
                new StartScreen();
                dispose();
            }
        });
        add(stopButton);
    }

    /**
     * sets the background image of the screen.
     */
    public void addBackgroundImage() {
        URL location = StartScreen.class.getProtectionDomain().getCodeSource()
                .getLocation();
        setVisible(true);

        String imageLocation = location.getFile();
        imageLocation = imageLocation.replace("%20", " ");
        imageLocation = imageLocation.replace("target/classes/", "src/");

        setContentPane(new JLabel(new ImageIcon(imageLocation
                + "main/Images/winScreenBackground.png")));
    }
}
