package game.screens;

import game.Driver;
import game.NormalDriver;
import game.Settings;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LosingScreen extends JFrame {

    JButton tryAgainButton;
    JButton settingsButton;
    JButton stopButton;
    final private Driver dr;
    
    private int score;
    
    JFrame gameFrame;

    public LosingScreen(Driver driver, int score){

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

         //setLayout(new BorderLayout());
         setContentPane(new JLabel(new ImageIcon(imageLocation
                 + "main/Images/loseScreenBackground.png")));
         //setLayout(new FlowLayout());

        setLayout(null);

        tryAgainButton = new JButton("Try again");
        tryAgainButton.setBackground(Color.DARK_GRAY);
        tryAgainButton.setForeground(Color.WHITE);
        tryAgainButton.setFont(new Font("Calibri", Font.BOLD, 30));
        tryAgainButton.setOpaque(true);
        tryAgainButton.setBounds(Settings.getScreenWidth()/2 + 70, Settings.getScreenHeight()/2 - 52, 350, 75);

        stopButton = new JButton("Exit");
        stopButton.setBackground(Color.DARK_GRAY);
        stopButton.setForeground(Color.WHITE);
        stopButton.setFont(new Font("Calibri", Font.BOLD, 30));
        stopButton.setOpaque(true);
        stopButton.setBounds(55, 350, 350, 75);

        Font font = new Font("Calibri", Font.PLAIN, 75);
        JLabel scoreLabel = new JLabel("Your score: " + score);
        scoreLabel.setFont(font);
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setLocation(250, 20);
        scoreLabel.setSize(500, 500);
        
        dr = driver;
        tryAgainButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent tryAgainGame) {
                    setVisible(false);
                    dr.setupGame();
                    dr.startGame();
                    dispose();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent closeScreen) {
                setVisible(false);
                dr.setupGame();
                dr.startScreen();
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
