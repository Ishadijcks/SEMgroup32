package game.screens;

import game.Driver;
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

public class WinningScreen extends JFrame {

    JButton playAgainButton;
    JButton settingsButton;
    JButton stopButton;
    final private Driver dr;
    JFrame gameFrame;

    public WinningScreen(Driver driver) {

        setTitle("You won!");
        setSize(Settings.getScreenWidth(), Settings.getScreenHeight());
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setVisible(true);
        
        URL location = StartScreen.class.getProtectionDomain().getCodeSource().getLocation();
        /* String currentLocation = location.getFile();      
         String startScreenMusicLocation = currentLocation + "Music/startscreen.wav";
         File music = new File(startScreenMusicLocation);
         AudioInputStream audioInputStream =
                 AudioSystem.getAudioInputStream(
                     music);
             Clip clip = AudioSystem.getClip();
             clip.open(audioInputStream);
             clip.loop(1000000);*/

         
         setVisible(true);

         
         String imageLocation = location.getFile();
         imageLocation = imageLocation.replace("%20", " ");

         //setLayout(new BorderLayout());
         setContentPane(new JLabel(new ImageIcon(imageLocation
                 + "main/Images/winScreenBackground.png")));
         //setLayout(new FlowLayout());

        setLayout(null);

        playAgainButton = new JButton("Play again");
        playAgainButton.setBackground(Color.PINK);
        playAgainButton.setForeground(Color.WHITE);
        playAgainButton.setFont(new Font("Calibri", Font.BOLD, 30));
        playAgainButton.setOpaque(true);
        playAgainButton.setBounds(Settings.getScreenWidth()/2 + 70, Settings.getScreenHeight()/2 - 52, 350, 75);

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
                Driver.setupGame();
                dr.startGame();
                dispose();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent closeScreen) {
                setVisible(false);
                dispose();
                Driver.setupGame();
                Driver.startScreen();
            }
        });

        setResizable(false);
        
        add(playAgainButton);
        add(stopButton);
        
        setSize(Settings.getScreenWidth() - 1, Settings.getScreenHeight() - 1);
        setSize(Settings.getScreenWidth(), Settings.getScreenHeight());
    }

}
