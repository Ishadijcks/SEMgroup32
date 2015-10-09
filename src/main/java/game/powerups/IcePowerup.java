package game.powerups;

import java.net.URL;

import javax.swing.ImageIcon;

import game.Game;
import game.screens.StartScreen;

public class IcePowerup extends Powerup {

	public IcePowerup(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void executeEffect() {
		new Thread(new IcePowerupTimer(game)).start();
		
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
		ImageIcon powerupice = new ImageIcon(imageLocation + "main/Images/Powerups/puice.png", "ice");
        return powerupice;
	}

}
