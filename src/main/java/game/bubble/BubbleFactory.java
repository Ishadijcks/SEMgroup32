package game.bubble;

import game.Settings;

import java.util.Random;

public class BubbleFactory {

	public BubbleFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public Bubble getRandomPlacedBubble(){
        Random rand = new Random();
        int randX = rand.nextInt(((Settings.getLevelWidth() - 10) - 10) + 1) + 10; 
        int randY = rand.nextInt(((Settings.getLevelHeight() - 200) - 10) + 1) + 10;
        
        Bubble bubble = getRandomBubble();
        bubble.setxCoord(randX);
        bubble.setyCoord(randY);
        return bubble;
		
	}
	
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
