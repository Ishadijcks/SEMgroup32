package game.powerups;

import java.net.URL;

import javax.swing.ImageIcon;

import game.Game;
import game.screens.StartScreen;

/**
 * Class that controls a powerup of the type life.
 * @author Boning
 *
 */
public class LifePowerup extends Powerup {

    /**
     * Constructor for the life powerup.
     * @param x-Coordinate
     * @param y-Coordinate
     */
	public LifePowerup(int x, int y) {
		super(x, y);
	}

	/**
     * What will happen if you pick the powerup up.
     */
	@Override
	public void executeEffect() {
		game.getLife();		
	}

	/**
     * Set the game.
     * @param game in which powerups will spawn
     */
	@Override
	public void setGame(Game game) {
		this.game = game;		
	}

	/**
     * Get the image of the powerup.
     * @return the image of the powerup
     */
	@Override
	public ImageIcon getImageIcon() {
		 URL location = StartScreen.class.getProtectionDomain().getCodeSource()
		            .getLocation();
		String imageLocation = location.getFile();
		imageLocation = imageLocation.replace("%20", " ");
		imageLocation = imageLocation.replace("target/classes/", "src/");
        ImageIcon poweruplife = new ImageIcon(imageLocation + "main/Images/Powerups/pulife.png", "life");
        return poweruplife;
	}

}
