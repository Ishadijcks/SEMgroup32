package game.screens;

import java.awt.Color;

import game.Driver;

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
     * @param driverInput
     *            where the screen comes from
     */
    public WinningScreen() {
        super("winScreenBackground", new Color(248, 81, 49));
        revalidate();
        repaint();
    }

}
