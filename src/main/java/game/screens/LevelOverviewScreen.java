package game.screens;

import game.Driver;
import game.DriverFactory;
import game.LevelCompletion;
import game.MainRunner;
import game.NormalDriverFactory;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Class that will create a screen for the level overview.
 * 
 * @author Boning
 */
public class LevelOverviewScreen extends JFrame {

    private static final long serialVersionUID = 1L;
    JButton levelButton;
    JButton stopButton;
    Font basicFont;

    /**
     * Constructor for the level overview screen class.
     * 
     * of which will be made a screen
     */
    public LevelOverviewScreen() {
        setSize(800, 800);
        ScreenBuilder.initScreen(this, "Levels");
        basicFont = new Font("Calibri", Font.PLAIN, 30);
        addStopButton();
        addSimpleLabel();
        addLevelButtons();
    }

    /**
     * Listeners for the level buttons.
     * @author Tim
     *
     */
    private class ButtonActionListener implements ActionListener {
        private int levelNumber;

        public ButtonActionListener(int levelNumber) {
            this.levelNumber = levelNumber;
        }

        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            dispose();
            DriverFactory dFactory = new NormalDriverFactory();
            Driver driver = dFactory.buildDriver();
            driver.setupGame();
            driver.initDriver();
            driver.startGame("");
            Driver.game.setCurrentLevelInt(levelNumber);
            MainRunner.setDriver(driver);
        }
    }

    /**
     * Add the label to the top of the screen.
     */
    public void addSimpleLabel() {
        JLabel label = new JLabel("Select a already completed level to play:");
        label.setFont(basicFont);
        label.setSize(500, 50);
        label.setForeground(Color.BLACK);
        label.setLocation(35, 15);
        add(label);
    }

    /**
     * Add the stop button to the screen.
     */
    public void addStopButton() {
        stopButton = new JButton("Exit");
        stopButton.setFont(basicFont);
        stopButton.setOpaque(true);
        stopButton.setBounds(300, 700, 250, 50);

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
     * Add all the level buttons of completed levels to the screen.
     */
    public void addLevelButtons() {
        for (int i = 1; i < 7; i++) {
            if (LevelCompletion.isLevelCompleted(i)) {
                levelButton = new JButton("Level " + i);
                levelButton.setBackground(Color.RED);
                levelButton.setForeground(Color.WHITE);
                levelButton.setFont(new Font("Calibri", Font.BOLD, 30));
                levelButton.setOpaque(true);
                levelButton.setBounds(20, -30 + i * 100, 300, 60);
                add(levelButton);
                levelButton.addActionListener(new ButtonActionListener(i));
            }
        }
    }
}
