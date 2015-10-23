package game.screens;

import game.Driver;
import game.Game;
import game.MyKeyListener;
import game.Score;
import game.log.Logger;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Class that will create everything on a screen for a game.
 * 
 * @author Boning
 *
 */
public class GameScreen extends JPanel {


    private static final long serialVersionUID = 1L;
    public static Game game;
    public static Score score;
    private static JFrame frame;
    private static Graphics2D g2d;
    private static GameScreen gameScreen;
    private static Painter painter;

    /**
     * Constructor for the game screen class.
     */
    public GameScreen() {
        frame = new JFrame("Game Screen");
        GameScreen.painter = new Painter(this, game, score);
    }

    /**
     * Dispose the screen.
     */
    public void dispose() {
        frame.dispose();
    }

    /**
     * Start a new game.
     */
    public void startGame() {
        frame.setVisible(true);
        frame.setFocusable(true);
        frame.requestFocusInWindow();
        frame.requestFocus();
    }

    /**
     * Level is won by player.
     */
    public void levelWon() {
        final JButton nextLevel = new JButton("Next Level");
        //Fucked up ouwe deze setBound
        nextLevel.setBounds(0, 0, 200, 50);
        nextLevel.setBackground(Color.BLACK);
        nextLevel.setForeground(Color.WHITE);
        nextLevel.setOpaque(true);
        nextLevel.setVisible(true);
        nextLevel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                game.gameStart();
                gameScreen.remove(nextLevel);
            }
        });
        gameScreen.add(nextLevel);
        gameScreen.validate();
        validate();
    }

    /**
     * Refresh the screen.
     */
    public void reload() {
        gameScreen.repaint();
        repaint();
        frame.repaint();
    }

    /**
     * Setup a screen.
     * 
     * @param gameInput
     *            type of game that will be played
     * @param scoreInput
     *            score of the player
     */
    public static void setupScreen(Game gameInput, Score scoreInput) {
        game = gameInput;
        score = scoreInput;
        gameScreen = new GameScreen();
        frame.addKeyListener(new MyKeyListener(gameInput));
        Logger.log("Added key listener", 9, 4);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.add(gameScreen);
        frame.setSize(1000, 800);
        Logger.log("Screen size set to " + Driver.game.getCurrentLevel().getWidth() + " by 1000", 9, 4);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(false);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Method to draw the game.
     */
    @Override
    public void paint(Graphics graph) {
        
        // Calculate the margin left to center the board
        int centerConstant = Driver.game.getCurrentLevel().getLeftMargin();
        int topMargin = Driver.game.getCurrentLevel().getTopMargin();
        g2d = (Graphics2D) graph;
        super.paint(graph);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        try {
            painter.paint(g2d);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
