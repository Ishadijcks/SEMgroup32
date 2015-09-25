package game.screens;

import game.Driver;
import game.DriverBuilder;
import game.MainRunner;
import game.NormalDriver;
import game.SurvivalDriver;

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
import javax.swing.JTextField;

public class StartScreen extends JFrame {

    JButton startButton;
    JButton startSurvButton;
    JButton settingsButton;
    JButton stopButton;
    
    final private JFrame jf;

    public StartScreen() throws UnsupportedAudioFileException, IOException, LineUnavailableException{

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

        jf = new JFrame();
        setVisible(true);
        
        String imageLocation = location.getFile();
        imageLocation = imageLocation.replace("%20", " ");
        imageLocation = imageLocation.replace("target/classes/", "src/");

        //setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon(imageLocation
                + "main/Images/StartscreenBackground.png")));
        System.out.println(imageLocation + "main/Images/StartscreenBackground.png");
        //setLayout(new FlowLayout());
        setLayout(null);

        startButton = new JButton("Start Normal game");
        startButton.setBackground(Color.RED);
        startButton.setForeground(Color.WHITE);
        startButton.setFont(new Font("Calibri", Font.BOLD, 30));
        startButton.setOpaque(true);
        startButton.setBounds(55, 300, 250, 60);
        
        startSurvButton = new JButton("Start Survival game");
        startSurvButton.setBackground(Color.RED);
        startSurvButton.setForeground(Color.WHITE);
        startSurvButton.setFont(new Font("Calibri", Font.BOLD, 30));
        startSurvButton.setOpaque(true);
        startSurvButton.setBounds(55, 400, 250, 60);

        settingsButton = new JButton("Settings");
        settingsButton.setBackground(Color.RED);
        settingsButton.setForeground(Color.WHITE);
        settingsButton.setFont(new Font("Calibri", Font.BOLD, 30));
        settingsButton.setOpaque(true);
        settingsButton.setBounds(55, 500, 250, 60);

        stopButton = new JButton("Exit");
        stopButton.setBackground(Color.RED);
        stopButton.setForeground(Color.WHITE);
        stopButton.setFont(new Font("Calibri", Font.BOLD, 30));
        stopButton.setOpaque(true);
        stopButton.setBounds(55, 600, 250, 60);
        
        Font font = new Font("Calibri", Font.PLAIN, 25);
        JLabel nameInput = new JLabel("Enter name and start game: ");
        nameInput.setFont(font);
        nameInput.setSize(500, 50);
        nameInput.setForeground(Color.WHITE);
        nameInput.setLocation(335, 115);
        
        Font font2 = new Font("Calibri", Font.PLAIN, 25);
        final JTextField tf = new JTextField(100);
        tf.setSize(200,50);
        tf.setLocation(375, 165);
        tf.setFont(font2);
        

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent startGame) {
                setVisible(false);
                dispose();
                Driver d = DriverBuilder.buildDriver(0);
                d.setupGame();
                d.initDriver();
                d.initGame();
                d.startGame("");
                MainRunner.setDriver(d);
            }
        });
        
        startSurvButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent startGame) {
                setVisible(false);
                dispose();
                Driver d = DriverBuilder.buildDriver(1);
                d.setupGame();
                d.initDriver();
                d.initGame();
                d.startGame("");
                MainRunner.setDriver(d);
            }
        });

        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent closeScreen) {
                setVisible(false);
                dispose();
            }
        });

        setResizable(false);
        
        
        add(nameInput);
        add(tf);
        
        add(startButton);
        add(startSurvButton);
        add(settingsButton);
        add(stopButton);

        setSize(699, 699);
        setSize(700, 700);

    }

 }
