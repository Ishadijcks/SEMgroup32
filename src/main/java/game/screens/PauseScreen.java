package game.screens;

import game.Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import settings.ScreenSettings;

/**
 * Class that will create a pausing screen.
 * 
 * @author Boning
 *
 */
public class PauseScreen extends JFrame {

    private static final long serialVersionUID = 1L;
    JButton resumeButton;
    JButton stopButton;
    JFrame gameFrame;

    /**
     * Constructor for the pausing screen class.
     * 
     * @param game
     *            where the screen comes from
     * @param name
     *            of the player
     */
    public PauseScreen(final String name, Game game) {
        ScreenBuilder.initScreen(this, "Paused game");
        addResumeButton(game);
        addStopButton(game);
        getContentPane().setBackground(Color.BLACK);
        this.setLocation(800, 350);
        setSize(ScreenSettings.getPauseWidth() - 1, ScreenSettings.getPauseHeight() - 1);
        setSize(ScreenSettings.getPauseWidth(), ScreenSettings.getPauseHeight());
    }

    /**
     * Add resume button to screen.
     * @param game for the onclick action
     */
    public void addResumeButton(Game game) {
        resumeButton = new JButton("Resume game");
        resumeButton.setBackground(Color.GRAY);
        resumeButton.setForeground(Color.WHITE);
        resumeButton.setFont(new Font("Calibri", Font.BOLD, 30));
        resumeButton.setOpaque(true);
        resumeButton.setBounds(50, 90, 250, 50);
        resumeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent playAgainGame) {
                setVisible(false);
                game.toggleProgress();
                dispose();
            }
        });
        add(resumeButton);
    }

    /**
     * add stop button to screen.
     * @param game for the onclick action
     */
    public void addStopButton(Game game) {
        stopButton = new JButton("Exit");
        stopButton.setBackground(Color.GRAY);
        stopButton.setForeground(Color.WHITE);
        stopButton.setFont(new Font("Calibri", Font.BOLD, 30));
        stopButton.setOpaque(true);
        stopButton.setBounds(50, 150, 250, 50);
        add(stopButton);
        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent closeScreen) {
                setVisible(false);
                game.endGame();
                dispose();
            }
        });
    }

}
