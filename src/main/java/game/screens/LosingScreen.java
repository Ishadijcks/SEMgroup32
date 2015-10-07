package game.screens;

import game.Driver;
import game.NormalDriver;
import game.Settings;
import game.SurvivalDriver;
import game.endScore;
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
 * @author Boning
 *
 */
public class LosingScreen extends JFrame {

    JButton tryAgainButton;
    JButton settingsButton;
    JButton stopButton;
    final private Driver dr;
    
    private endScore score;
    private Leaderboard leaderBoard;
    
    JFrame gameFrame;

    /**
     * Constructor for the losing screen class.
     * @param driver where the screen comes from
     * @param score what the player got
     */
    public LosingScreen(Driver driver, final endScore score) {

        setTitle("You lost!");
        setSize(Settings.getScreenWidth(), Settings.getScreenHeight());
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.gameFrame = gameFrame;
        this.score = score;
        
        setVisible(true);
        
        URL location = StartScreen.class.getProtectionDomain().getCodeSource().getLocation();

        setVisible(true);

         
        String imageLocation = location.getFile();
        imageLocation = imageLocation.replace("%20", " ");
        imageLocation = imageLocation.replace("target/classes/", "src/");

        setContentPane(new JLabel(new ImageIcon(imageLocation
                 + "main/Images/loseScreenBackground.png")));

        setLayout(null);

        tryAgainButton = new JButton("Try again");
        tryAgainButton.setBackground(Color.DARK_GRAY);
        tryAgainButton.setForeground(Color.WHITE);
        tryAgainButton.setFont(new Font("Calibri", Font.BOLD, 30));
        tryAgainButton.setOpaque(true);
        tryAgainButton.setBounds(Settings.getScreenWidth() / 2 + 70, Settings.getScreenHeight() / 2 - 52, 350, 75);

        stopButton = new JButton("Exit");
        stopButton.setBackground(Color.DARK_GRAY);
        stopButton.setForeground(Color.WHITE);
        stopButton.setFont(new Font("Calibri", Font.BOLD, 30));
        stopButton.setOpaque(true);
        stopButton.setBounds(55, 350, 350, 75);

        Font font = new Font("Calibri", Font.PLAIN, 55);
        JLabel scoreLabel = new JLabel(score.getName() + "s score: " + score.getScore());
        scoreLabel.setFont(font);
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setLocation(325, 10);
        scoreLabel.setSize(700, 500);
        
        dr = driver;
        tryAgainButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent tryAgainGame) {
                    setVisible(false);
                    dispose();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent closeScreen) {
                setVisible(false);
                try {
                    new StartScreen();
                } catch (UnsupportedAudioFileException | IOException
                        | LineUnavailableException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                dispose();
            }
        });

        setResizable(false);
        
        add(tryAgainButton);
        add(stopButton);
        add(scoreLabel);
        
        setSize(Settings.getScreenWidth() - 1, Settings.getScreenHeight() - 1);
        setSize(Settings.getScreenWidth(), Settings.getScreenHeight());  

    }

   
}
