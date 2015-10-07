package game.screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.Driver;
import game.DriverBuilder;
import game.Leaderboard;
import game.MainRunner;

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

    /**
     * Constructor for the leaderboard screen class.
     * 
     * @param leaderBoard
     *            of which will be made a screen
     */
    public LevelOverviewScreen() {
        setTitle("Levels");
        setSize(800, 800);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);

        Font font = new Font("Calibri", Font.PLAIN, 30);
        JLabel label = new JLabel("Select a level to play:");
        label.setFont(font);
        label.setSize(500, 50);
        label.setForeground(Color.BLACK);
        label.setLocation(35, 15);
        add(label);

        for (int i = 1; i < 7; i++) {
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
            Driver d = DriverBuilder.buildDriver(0);
            d.setupGame(levelNumber);
            d.initDriver();
            d.startGame("");
            MainRunner.setDriver(d);
        }
    }

}
