package game.screens;

import game.Driver;
import game.DriverFactory;
import game.MainRunner;
import game.NormalDriverFactory;
import game.SurvivalDriverFactory;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Class that will make the startscreen of the game.
 * 
 * @author Boning
 *
 */
public class StartScreen extends JFrame {

    private static final long serialVersionUID = 1L;
    JButton normalGameButton;
    JButton survivalGameButton;
    JButton settingsButton;
    JButton stopButton;
    JTextField tf;
    
    /**
     * Constructor of the start screen class.
     */
    public StartScreen() {
        setSize(700, 700);
        ScreenBuilder.initScreen(this, "Start screen");

        addBackgroundImage();
        addTextField();
        addNameInputLabel();
        addNormalGameButton();
        addSurvivalGameButton();
        addSettingsButton();

        setSize(699, 699);
        setSize(700, 700);
    }

    /**
     * add an image to the background of the screen.
     */
    public void addBackgroundImage() {
        URL location = StartScreen.class.getProtectionDomain().getCodeSource()
                .getLocation();
        String imageLocation = location.getFile();
        imageLocation = imageLocation.replace("%20", " ");
        imageLocation = imageLocation.replace("target/classes/", "src/");

        setContentPane(new JLabel(new ImageIcon(imageLocation
                + "main/Images/StartscreenBackground.png")));
    }

    /**
     * add the text field to the screen.
     */
    public void addTextField() {
        Font font2 = new Font("Calibri", Font.PLAIN, 25);
        tf = new JTextField(100);
        tf.setSize(200, 50);
        tf.setLocation(375, 165);
        tf.setFont(font2);
        add(tf);
    }

    /**
     * add the name input label to the screen.
     */
    public void addNameInputLabel() {
        Font font = new Font("Calibri", Font.PLAIN, 25);
        JLabel nameInput = new JLabel("Enter name and start game: ");
        nameInput.setFont(font);
        nameInput.setSize(500, 50);
        nameInput.setForeground(Color.WHITE);
        nameInput.setLocation(335, 115);
        add(nameInput);
    }

    /**
     * add the normal game button to the screen.
     */
    public void addNormalGameButton() {
        normalGameButton = new JButton("Start Normal game");
        normalGameButton.setBackground(Color.RED);
        normalGameButton.setForeground(Color.WHITE);
        normalGameButton.setFont(new Font("Calibri", Font.BOLD, 30));
        normalGameButton.setOpaque(true);
        normalGameButton.setBounds(55, 250, 350, 60);
        normalGameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent startGame) {
                setVisible(false);
                dispose();
                DriverFactory dFactory = new NormalDriverFactory();
                Driver d = dFactory.buildDriver();
                d.startGame(tf.getText());
                MainRunner.setDriver(d);
            }
        });
        add(normalGameButton);
    }

    /**
     * add The survival game button to the screen.
     */
    public void addSurvivalGameButton() {
        survivalGameButton = new JButton("Start Survival game");
        survivalGameButton.setBackground(Color.RED);
        survivalGameButton.setForeground(Color.WHITE);
        survivalGameButton.setFont(new Font("Calibri", Font.BOLD, 30));
        survivalGameButton.setOpaque(true);
        survivalGameButton.setBounds(55, 350, 350, 60);
        survivalGameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent startGame) {
                setVisible(false);
                dispose();
                DriverFactory dFactory = new SurvivalDriverFactory();
                Driver d = dFactory.buildDriver();
                d.startGame(tf.getText());
                MainRunner.setDriver(d);
            }
        });
        add(survivalGameButton);
    }

    /**
     * add the settings button to the screen.
     */
    public void addSettingsButton() {
        settingsButton = new JButton("Select Level");
        settingsButton.setBackground(Color.RED);
        settingsButton.setForeground(Color.WHITE);
        settingsButton.setFont(new Font("Calibri", Font.BOLD, 30));
        settingsButton.setOpaque(true);
        settingsButton.setBounds(55, 450, 350, 60);
        settingsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent closeScreen) {
                setVisible(false);
                dispose();
            }
        });
        add(settingsButton);
    }

    /**
     * add the stop button to the screen.
     */
    public void addStopButton() {
        stopButton = new JButton("Exit");
        stopButton.setBackground(Color.RED);
        stopButton.setForeground(Color.WHITE);
        stopButton.setFont(new Font("Calibri", Font.BOLD, 30));
        stopButton.setOpaque(true);
        stopButton.setBounds(55, 550, 350, 60);
        add(stopButton);
    }

}
