package game.bubble;

import game.Driver;

import java.util.Random;

/**
 * Class that creates bubbles.
 * @author Boning
 *
 */
public class BubbleFactory {

    /**
     * Constructor for the bubble class.
     */
	public BubbleFactory() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Get a random bubble on random coordinates.
	 * @return Bubble that is created
	 */
	public Bubble getRandomPlacedBubble(){
        Random rand = new Random();
        int randX = rand.nextInt(((Driver.game.getCurrentLevel().getWidth() - 10) - 10) + 1) + 10; 
        int randY = rand.nextInt(((Driver.game.getCurrentLevel().getHeight() - 200) - 10) + 1) + 10;
        
        Bubble bubble = getRandomBubble();
        bubble.setxCoord(randX);
        bubble.setyCoord(randY);
        return bubble;
		
	}
	
	/**
	 * Get a random bubble without coordinates.
	 * @return Bubble that is either 8, 16, 32, 64 or 128
	 */
	public Bubble getRandomBubble(){
		Bubble bubble = null;
		Random rand = new Random();
        int bubbleType = rand.nextInt((4 - 0) + 1) + 0;
        
        switch(bubbleType){
        case 0:
        	bubble = new Bubblex8(0, 0, true, true);
        	break;
        case 1:
        	bubble = new Bubblex16(0, 0, true, true);
        	break;
        case 2:
        	bubble = new Bubblex32(0, 0, true, true);
        	break;
        case 3:
        	bubble = new Bubblex64(0, 0, true, true);
        	break;
        case 4:
        	bubble = new Bubblex128(0, 0, true, true);
        	break;
        }
        
        return bubble;
	}

}
