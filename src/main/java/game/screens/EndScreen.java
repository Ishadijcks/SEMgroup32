package game.screens;

import game.MainRunner;
import game.states.NewGameState;

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
 * 
 * @author Boning
 *
 */
public class EndScreen extends JFrame {


    private static final long serialVersionUID = 1L;
    JButton stopButton;

    /**
     * Constructor for the winning screen class.
     * 
     * @param driverInput
     *            where the screen comes from
     * @param background
     *            image of the screen.
     * @param colorButton
     *            of the button.
     */
    public EndScreen(String background, Color colorButton) {
        ScreenBuilder.initScreen(this, "");
        addBackgroundImage(background);
        addStopButton(colorButton);
        setSize(1000, 800);
    }

    /**
     * Add the stop button to the screen.
     * 
     * @param colorButton
     *            of the button.
     */
    public void addStopButton(Color colorButton) {
        stopButton = new JButton("Exit");
        stopButton.setBackground(colorButton);
        stopButton.setForeground(Color.WHITE);
        stopButton.setFont(new Font("Calibri", Font.BOLD, 30));
        stopButton.setOpaque(true);
        stopButton.setBounds(205, 350, 550, 75);
        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent closeScreen) {
                setVisible(false);
                MainRunner.getStateManager().newState(new NewGameState());
                dispose();
            }
        });
        add(stopButton);
    }

    /**
     * sets the background image of the screen.
     * 
     * @param background
     *            image of the screen.
     */
    public void addBackgroundImage(String background) {
        URL location = StartScreen.class.getProtectionDomain().getCodeSource()
                .getLocation();
        setVisible(true);
        String imageLocation = location.getFile();
        imageLocation = imageLocation.replace("%20", " ");
        imageLocation = imageLocation.replace("target/classes/", "src/");
        setContentPane(new JLabel(new ImageIcon(imageLocation + "main/Images/"
                + background + ".png")));
    }
}
