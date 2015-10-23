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

    private static final long serialVersionUID = 1L;
    EndScore score;

    /**
     * Constructor for the losing screen class.
     * 
     * @param score
     *            what the player got
     */
    public LosingScreen(final EndScore score) {
        super("loseScreenBackground", new Color(130, 170, 73));
        this.score = score;
        addScoreLabel();
        revalidate();
        repaint();
    }

    /**
     * Add the score label to the screen.
     */
    public void addScoreLabel() {
        Font font = new Font("Calibri", Font.PLAIN, 55);
        JLabel scoreLabel = new JLabel(score.getName() + "'s score: "
                + score.getScore());
        scoreLabel.setFont(font);
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setLocation(325, 10);
        scoreLabel.setSize(700, 500);
        add(scoreLabel);
    }
}
