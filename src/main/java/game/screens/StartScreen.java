package game.screens;

import game.Driver;

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

public class StartScreen extends JFrame {

    JButton startButton;
    JButton settingsButton;
    JButton stopButton;
    
    final private Driver dr;
    final private JFrame jf;

    public StartScreen(Driver driver, JFrame jframe) throws UnsupportedAudioFileException, IOException, LineUnavailableException{

        setTitle("Start screen");
        setSize(700, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
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
                + "main/Images/StartscreenBackground.png")));
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
                dr.startGame();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent closeScreen) {
                setVisible(false);
                dispose();
            }
        });

        setResizable(false);
        
        add(startButton);
        add(settingsButton);
        add(stopButton);

        setSize(699, 699);
        setSize(700, 700);

    }

 }
