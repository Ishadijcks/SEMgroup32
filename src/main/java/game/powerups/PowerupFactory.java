package game.powerups;

import java.util.Random;

public class PowerupFactory {

	public Powerup createRandomPowerup(){
		Powerup pow = null;
		Random rand = new Random();
        int powType = rand.nextInt((2 - 0) + 1) + 0;
		
		switch(powType){
		case 0:
			pow = new SpeedPowerup(0, 0);
			break;
		case 1:
			pow = new IcePowerup(0, 0);
			break;
		case 2:
			pow = new LifePowerup(0, 0);
			break;
		}
		
		return pow;
	}

}
