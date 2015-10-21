package game.powerups;

import java.net.URL;

import javax.swing.ImageIcon;

import game.Game;
import game.screens.StartScreen;

/**
 * Class that controls a powerup of the type ice.
 * @author Boning
 *
 */
public class IcePowerup extends Powerup {

    /**
     * Constructor for the ice powerup.
     * @param x x-Coordinate
     * @param y y-Coordinate
     */
	public IcePowerup(int x, int y) {
		super(x, y);
	}

	/**
     * What will happen if you pick the powerup up.
     */
	@Override
	public void executeEffect() {
		new Thread(new IcePowerupTimer(game)).start();
		
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
		ImageIcon powerupice = new ImageIcon(imageLocation + "main/Images/Powerups/puice.png", "ice");
        return powerupice;
	}

}
