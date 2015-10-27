package game.screens;

import game.MainRunner;
import game.states.NormalGameState;
import game.states.State;
import game.states.SurvivalGameState;

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
        addStopButton();

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
        tf.setLocation(255, 225);
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
        nameInput.setLocation(210, 175);
        add(nameInput);
    }

    /**
     * add the normal game button to the screen.
     */
    public void addNormalGameButton() {
        normalGameButton = new JButton("Start Normal game");
        normalGameButton.setBackground(Color.GRAY);
        normalGameButton.setForeground(Color.WHITE);
        normalGameButton.setFont(new Font("Calibri", Font.BOLD, 30));
        normalGameButton.setOpaque(true);
        normalGameButton.setBounds(175, 350, 350, 60);
        normalGameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent startGame) {
                setVisible(false);
                dispose();
                MainRunner.setPlayerName(tf.getText());
                MainRunner.getStateManager().newState(new NormalGameState());
            }
        });
        add(normalGameButton);
    }

    /**
     * add The survival game button to the screen.
     */
    public void addSurvivalGameButton() {
        survivalGameButton = new JButton("Start Survival game");
        survivalGameButton.setBackground(Color.GRAY);
        survivalGameButton.setForeground(Color.WHITE);
        survivalGameButton.setFont(new Font("Calibri", Font.BOLD, 30));
        survivalGameButton.setOpaque(true);
        survivalGameButton.setBounds(175, 425, 350, 60);
        survivalGameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent startGame) {
                setVisible(false);
                dispose();
                MainRunner.setPlayerName(tf.getText());
                MainRunner.getStateManager().newState(new SurvivalGameState());
            }
        });
        add(survivalGameButton);
    }

    /**
     * add the settings button to the screen.
     */
    public void addSettingsButton() {
        settingsButton = new JButton("Select Level");
        settingsButton.setBackground(Color.GRAY);
        settingsButton.setForeground(Color.WHITE);
        settingsButton.setFont(new Font("Calibri", Font.BOLD, 30));
        settingsButton.setOpaque(true);
        settingsButton.setBounds(175, 500, 350, 60);
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
        stopButton.setBackground(Color.GRAY);
        stopButton.setForeground(Color.WHITE);
        stopButton.setFont(new Font("Calibri", Font.BOLD, 30));
        stopButton.setOpaque(true);
        stopButton.setBounds(175, 575, 350, 60);
        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent closeScreen) {
                setVisible(false);
                dispose();
            }
        });
        add(stopButton);
    }
    
    public void registerListeningState(State state) {
    }

}
