package game.screens;

import java.awt.Color;


/**
 * Class that will create a winning screen.
 * 
 * @author Boning
 *
 */
public class WinningScreen extends EndScreen {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor for the winning screen class.
     * 
     */
    public WinningScreen() {
        super("winScreenBackground", new Color(248, 81, 49));
        revalidate();
        repaint();
    }

}
