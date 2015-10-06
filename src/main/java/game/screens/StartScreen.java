package game.screens;

import game.Driver;
import game.DriverFactory;
import game.MainRunner;
<<<<<<< HEAD
import game.NormalDriver;
import game.NormalDriverFactory;
import game.SurvivalDriver;
import game.SurvivalDriverFactory;
=======
>>>>>>> master

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
import javax.swing.JTextField;

/**
 * Class that will make the startscreen of the game.
 * @author Boning
 *
 */
public class StartScreen extends JFrame {

    JButton normalGameButton;
    JButton survivalGameButton;
    JButton settingsButton;
    JButton stopButton;
    
    final private JFrame jf;

    /**
     * Constructor of the startscreen class.
     * @throws UnsupportedAudioFileException exception
     * @throws IOException exception
     * @throws LineUnavailableException exception
     */
    public StartScreen() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        setTitle("Start screen");
        setSize(700, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        URL location = StartScreen.class.getProtectionDomain().getCodeSource().getLocation();

        jf = new JFrame();
        setVisible(true);
        
        String imageLocation = location.getFile();
        imageLocation = imageLocation.replace("%20", " ");
        imageLocation = imageLocation.replace("target/classes/", "src/");

        //setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon(imageLocation
                + "main/Images/StartscreenBackground.png")));
        //setLayout(new FlowLayout());
        setLayout(null);

        normalGameButton = new JButton("Start Normal game");
        normalGameButton.setBackground(Color.RED);
        normalGameButton.setForeground(Color.WHITE);
        normalGameButton.setFont(new Font("Calibri", Font.BOLD, 30));
        normalGameButton.setOpaque(true);
        normalGameButton.setBounds(55, 250, 350, 60);
        
        survivalGameButton = new JButton("Start Survival game");
        survivalGameButton.setBackground(Color.RED);
        survivalGameButton.setForeground(Color.WHITE);
        survivalGameButton.setFont(new Font("Calibri", Font.BOLD, 30));
        survivalGameButton.setOpaque(true);
        survivalGameButton.setBounds(55, 350, 350, 60);

        settingsButton = new JButton("Settings");
        settingsButton.setBackground(Color.RED);
        settingsButton.setForeground(Color.WHITE);
        settingsButton.setFont(new Font("Calibri", Font.BOLD, 30));
        settingsButton.setOpaque(true);
        settingsButton.setBounds(55, 450, 350, 60);

        stopButton = new JButton("Exit");
        stopButton.setBackground(Color.RED);
        stopButton.setForeground(Color.WHITE);
        stopButton.setFont(new Font("Calibri", Font.BOLD, 30));
        stopButton.setOpaque(true);
        stopButton.setBounds(55, 550, 350, 60);
        
        Font font = new Font("Calibri", Font.PLAIN, 25);
        JLabel nameInput = new JLabel("Enter name and start game: ");
        nameInput.setFont(font);
        nameInput.setSize(500, 50);
        nameInput.setForeground(Color.WHITE);
        nameInput.setLocation(335, 115);
        
        Font font2 = new Font("Calibri", Font.PLAIN, 25);
        final JTextField tf = new JTextField(100);
        tf.setSize(200, 50);
        tf.setLocation(375, 165);
        tf.setFont(font2);
        

        normalGameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent startGame) {
                setVisible(false);
                dispose();
                DriverFactory dFactory = new NormalDriverFactory();
                Driver d = dFactory.buildDriver();
                d.setupGame();
                d.initDriver();
                d.startGame("");
                MainRunner.setDriver(d);
            }
        });
        
        survivalGameButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent startGame) {
                setVisible(false);
                dispose();
                DriverFactory dFactory = new SurvivalDriverFactory();
                Driver d = dFactory.buildDriver();
                d.setupGame();
                d.initDriver();
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
        
        add(normalGameButton);
        add(survivalGameButton);
        add(settingsButton);
        add(stopButton);

        setSize(699, 699);
        setSize(700, 700);

    }

 }
