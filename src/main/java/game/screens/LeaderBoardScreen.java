package game.screens;

import java.awt.Color;
import java.awt.Font;

import game.Leaderboard;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Class that will create a screen for the leaderboard.
 * 
 * @author Boning
 */
public class LeaderBoardScreen extends JFrame {

    private static final long serialVersionUID = 1L;
    Leaderboard leaderBoard;
    static JLabel[] allLabels = new JLabel[500];

    /**
     * Constructor for the leaderboard screen class.
     * 
     * @param leaderBoard
     *            of which will be made a screen
     */
    public LeaderBoardScreen(Leaderboard leaderBoard) {
        ScreenBuilder.initScreen(this, "Leaderboard");
        setSize(450, 450);
        this.leaderBoard = leaderBoard;
        addScoreList();
        revalidate();
        repaint();
    }

    /**
     * Add the score list as labels to the leaderboard.
     */
    public void addScoreList() {
        Font font = new Font("Calibri", Font.PLAIN, 30);
        for (int i = 0; i < leaderBoard.getScoreList().size(); i++) {
            allLabels[i] = new JLabel((i + 1) + ". "
                    + leaderBoard.getScoreList().get(i).toString());
            allLabels[i].setFont(font);
            allLabels[i].setForeground(Color.BLACK);
            allLabels[i].setBounds(20, i * 42, 420, 35);
            add(allLabels[i]);
        }
    }

}
