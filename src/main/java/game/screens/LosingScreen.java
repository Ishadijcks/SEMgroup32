package game.screens;

import game.Driver;
import game.EndScore;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

/**
 * Class that will create a losing screen.
 * 
 * @author Boning
 *
 */
public class LosingScreen extends EndScreen {
    EndScore score;

    /**
     * Constructor for the losing screen class.
     * 
     * @param driverInput
     *            where the screen comes from
     * @param score
     *            what the player got
     */
    public LosingScreen(Driver driverInput, final EndScore score) {
        super(driverInput, "loseScreenBackground", new Color(130, 170, 73));
        this.score = score;
        addScoreLabel();
    }

    /**
     * Add the score label to the screen.
     */
    public void addScoreLabel() {
        Font font = new Font("Calibri", Font.PLAIN, 55);
        JLabel scoreLabel = new JLabel(score.getName() + "s score: "
                + score.getScore());
        scoreLabel.setFont(font);
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setLocation(325, 10);
        scoreLabel.setSize(700, 500);
        add(scoreLabel);
    }
}
