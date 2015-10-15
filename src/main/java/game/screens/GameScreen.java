package game.screens;

import game.Game;
import game.MyKeyListener;
import game.Score;
import game.log.Logger;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import settings.screenSettings;


/**
 * Class that will create everything on a screen for a game.
 * 
 * @author Boning
 *
 */
public class GameScreen extends JPanel {
    public static Game game;
    public static Score score;
    private static boolean canDrawGame = true;
    private int topMargin;
    private int centerConstant;
    private static JFrame frame;
    private static Graphics2D g2d;
    private static GameScreen gameScreen;
    private static Painter painter;

    /**
     * Constructor for the game screen class.
     * 
     * @throws UnsupportedAudioFileException
     *             exception
     * @throws IOException
     *             exception
     * @throws LineUnavailableException
     *             exception
     */
    public GameScreen() {
        frame = new JFrame("Game Screen");
        this.painter = new Painter(this, game, score);
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
        final JLabel label = new JLabel("test");
        label.setText("Congratulations! Level won!");
        gameScreen.add(label);
        final JButton nextLevel = new JButton("Next Level");
        nextLevel.setBounds(300, 50, 140, 50);
        nextLevel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                canDrawGame = true;
                game.gameStart();
                gameScreen.remove(nextLevel);
                gameScreen.remove(label);
            }
        });
        gameScreen.add(nextLevel);
        gameScreen.validate();
        validate();
        reload();
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
        frame.add(gameScreen);
        frame.setSize(screenSettings.getScreenWidth(), screenSettings.getScreenHeight());
        Logger.log("Screen size set to " + screenSettings.getScreenWidth() + " by "
                + screenSettings.getScreenWidth(), 9, 4);
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
        centerConstant = screenSettings.getLeftMargin();
        topMargin = screenSettings.getTopMargin();
        g2d = (Graphics2D) graph;
        super.paint(graph);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        
        painter.paint(g2d);
    }

}
