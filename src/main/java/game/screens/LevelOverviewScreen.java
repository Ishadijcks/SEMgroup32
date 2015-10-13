package game.screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import game.Driver;
import game.DriverFactory;
import game.Leaderboard;
import game.LevelCompletion;
import game.MainRunner;
import game.NormalDriverFactory;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Class that will create a screen for the leaderboard.
 * 
 * @author Boning
 */
public class LevelOverviewScreen extends JFrame {

    Leaderboard leaderBoard;
    static JLabel[] allLabels = new JLabel[500];
    JButton levelButton;
    JButton stopButton;

    /**
     * Constructor for the leaderboard screen class.
     * 
     * of which will be made a screen
     */
    public LevelOverviewScreen() {
        setTitle("Levels");
        setSize(800, 800);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);

        stopButton = new JButton("Exit");
        stopButton.setFont(new Font("Calibri", Font.BOLD, 30));
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

        Font font = new Font("Calibri", Font.PLAIN, 30);
        JLabel label = new JLabel("Select a already completed level to play:");
        label.setFont(font);
        label.setSize(500, 50);
        label.setForeground(Color.BLACK);
        label.setLocation(35, 15);
        add(label);

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

    /**
     * Listeners for the level buttons.
     * 
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
            Driver d = dFactory.buildDriver();
            d.setupGame();
            d.initDriver();
            d.startGame("");
            d.game.setCurrentLevelInt(levelNumber);
            MainRunner.setDriver(d);
        }
    }

}
