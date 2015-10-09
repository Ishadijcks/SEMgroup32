package game.powerups;

import java.net.URL;

import javax.swing.ImageIcon;

import game.Game;
import game.screens.StartScreen;

public class LifePowerup extends Powerup {

	public LifePowerup(int x, int y) {
		super(x, y);
	}

	@Override
	public void executeEffect() {
		game.getLife();		
	}

	@Override
	public void setGame(Game game) {
		this.game = game;		
	}

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
