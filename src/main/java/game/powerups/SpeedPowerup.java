package game.powerups;

import java.net.URL;

import javax.swing.ImageIcon;

import game.Game;
import game.screens.StartScreen;

/**
 * Class that controls a powerup of the type speed.
 * @author Boning
 *
 */
public class SpeedPowerup extends Powerup {

    /**
     * Constructor for the speed powerup.
     * @param x-Coordinate
     * @param y-Coordinate
     */
	public SpeedPowerup(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	/**
     * What will happen if you pick the powerup up.
     */
	@Override
	public void executeEffect() {
		new Thread(new SpeedPowerupTimer(game)).start();
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
		ImageIcon powerupspeed = new ImageIcon(imageLocation + "main/Images/Powerups/puspeed.png", "speed");
		return powerupspeed;
	}

}
