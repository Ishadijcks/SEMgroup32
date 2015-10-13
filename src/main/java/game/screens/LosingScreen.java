package game.screens;

import game.Driver;
import game.Settings;
import game.EndScore;
import game.Leaderboard;

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
 * Class that will create a losing screen.
 * 
 * @author Boning
 *
 */
public class LosingScreen extends JFrame {
    JButton stopButton;
    EndScore score;
    JFrame gameFrame;

    /**
     * Constructor for the losing screen class.
     * 
     * @param driverInput
     *            where the screen comes from
     * @param score
     *            what the player got
     */
    public LosingScreen(Driver driverInput, final EndScore score) {
        this.score = score;
        setTitle("You lost!");
        setSize(Settings.getScreenWidth(), Settings.getScreenHeight());
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        addBackgroundImage();
        addStopButton();
        addScoreLabel();
        setResizable(false);
        setSize(Settings.getScreenWidth() - 1, Settings.getScreenHeight() - 1);
        setSize(Settings.getScreenWidth(), Settings.getScreenHeight());

    }

    /**
     * adds the background image to the screen.
     */
    public void addBackgroundImage() {
        URL location = StartScreen.class.getProtectionDomain().getCodeSource()
                .getLocation();
        String imageLocation = location.getFile();
        imageLocation = imageLocation.replace("%20", " ");
        imageLocation = imageLocation.replace("target/classes/", "src/");
        setContentPane(new JLabel(new ImageIcon(imageLocation
                + "main/Images/loseScreenBackground.png")));

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
        add(stopButton);
        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent closeScreen) {
                setVisible(false);
                new StartScreen();
                dispose();
            }
        });
    }

    /**
     * Add the score label to the screen.
     */
    public void addScoreLabel() {
        Font font = new Font("Calibri", Font.PLAIN, 55);
        JLabel scoreLabel = new JLabel(score.getName() + "s score: "
                + score.getScore());
        scoreLabel.setFont(font);
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setLocation(325, 10);
        scoreLabel.setSize(700, 500);
        add(scoreLabel);
    }
}
