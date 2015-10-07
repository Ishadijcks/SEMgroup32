package game.screens;

import game.Driver;
import game.Game;
import game.NormalGame;
import game.Settings;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Class that will create a winning screen.
 * @author Boning
 *
 */
public class PauseScreen extends JFrame {

    JButton resumeButton;
    JButton stopButton;
    JFrame gameFrame;

    /**
     * Constructor for the winning screen class.
     * @param driver where the screen comes from
     * @param name of the player
     */
    public PauseScreen(final String name, NormalGame game) {

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
        resumeButton.setBounds(150, 50, 250, 50);

        stopButton = new JButton("Exit");
        resumeButton.setForeground(Color.BLACK);
        stopButton.setFont(new Font("Calibri", Font.BOLD, 30));
        stopButton.setOpaque(true);
        stopButton.setBounds(150, 150, 250, 50);

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
                dispose();
            }
        });

        setResizable(false);
        
        add(resumeButton);
        add(stopButton);
        
        setSize(Settings.getScreenWidth() - 201, Settings.getScreenHeight() - 201);
        setSize(Settings.getScreenWidth() - 200, Settings.getScreenHeight() - 200);
    }

}
