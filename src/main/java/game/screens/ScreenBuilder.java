package game.screens;

import javax.swing.JFrame;

/**
 * Screen builder sets up basic screens.
 * 
 * @author Tim
 *
 */
public class ScreenBuilder {
    /**
     * Initializes the given screen.
     * 
     * @param frame
     *            of the screen
     * @param title
     *            of the screen
     * @return frame after the change
     */
    public static JFrame initScreen(JFrame frame, String title) {
        frame.setTitle(title);
        frame.setSize(1000, 800);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(null);
        return frame;
    }
}
