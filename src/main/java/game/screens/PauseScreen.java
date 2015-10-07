package game.screens;

import game.Game;
import game.NormalGame;
import game.Settings;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Class that will create a pausing screen.
 * @author Boning
 *
 */
public class PauseScreen extends JFrame {

    JButton resumeButton;
    JButton stopButton;
    JFrame gameFrame;

    /**
     * Constructor for the pausing screen class.
     * @param game where the screen comes from
     * @param name of the player
     */
    public PauseScreen(final String name, Game game) {

        setTitle("Paused game");
        setSize(Settings.getScreenWidth(), Settings.getScreenHeight());
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setVisible(true);

        setLayout(null);

        resumeButton = new JButton("Resume game");
        resumeButton.setForeground(Color.BLACK);
        resumeButton.setFont(new Font("Calibri", Font.BOLD, 30));
        resumeButton.setOpaque(true);
        resumeButton.setBounds(50, 90, 250, 50);

        stopButton = new JButton("Exit");
        resumeButton.setForeground(Color.BLACK);
        stopButton.setFont(new Font("Calibri", Font.BOLD, 30));
        stopButton.setOpaque(true);
        stopButton.setBounds(50, 150, 250, 50);

        resumeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent playAgainGame) {
                setVisible(false);
                game.toggleProgress();
                dispose();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent closeScreen) {
                setVisible(false);
                game.endGame();
                dispose();
            }
        });

        setResizable(false);
        
        add(resumeButton);
        add(stopButton);
        
        setSize(Settings.getPauseWidth() - 1, Settings.getPauseHeight() - 1);
        setSize(Settings.getPauseWidth(), Settings.getPauseHeight());
    }

}
