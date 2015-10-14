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

    /**
     * Constructor for the winning screen class.
     * 
     * @param driverInput
     *            where the screen comes from
     */
    public WinningScreen(Driver driverInput) {
        super(driverInput, "winScreenBackground", new Color(248, 81, 49));
    }

}
