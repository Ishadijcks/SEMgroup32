package game;

import game.log.LogSettings;
import game.log.Logger;
import game.screens.LogScreen;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Keylistener that will handle all key inputs.
 * @author Boning
 *
 */
public class MyKeyListener extends KeyAdapter {
    
    private Game game;
    private RopeFactory rFac;

    /**
     * Constructor for the key listener class.
     * @param gameInput The game where the listener is active
     */
    public MyKeyListener(Game gameInput) {
        game = gameInput;
        rFac = new RopeFactory();
    }

    /**
     * Checks what key is pressed, moves the player in that direction or shoots
     * a rope.
     * @param evt Keyevent 
     */
    public void keyPressed(KeyEvent evt) {

        if (game.inProgress()) {
            

            switch (evt.getKeyCode()) {

            // Left
                case 37:
                    Logger.log("Player pressed Left", 0, 5);
                    game.getPlayerList().get(0).movingLeft();
                    break;
            // Right
                case 39:
                    Logger.log("Player pressed right", 0, 5);
                    game.getPlayerList().get(0).movingRight();
                    break;
                case 38:
                    Logger.log("Player pressed up", 0, 5);
                    if(!Driver.game.getCurrentLevel().hasRope())
                    	Driver.game.getCurrentLevel().setRope(rFac.createRope(Settings.getPlayerHasIceRope()));
                    break;   
                    
                    
                case 32:
                    Logger.log("Player pressed space", 0, 5);
                    if(!Driver.game.getCurrentLevel().hasRope())
                    	Driver.game.getCurrentLevel().setRope(rFac.createRope(Settings.getPlayerHasIceRope()));
                    break;
                case 76:
                try {
                    LogScreen logScreen = new LogScreen();
                    LogSettings.setLogScreen(true);
                    LogSettings.setLogscreen(logScreen);
                } catch (UnsupportedAudioFileException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (LineUnavailableException e) {
                    e.printStackTrace();
                }
                    break;
                default:
                    Logger.log("keyPressed switch default triggered", 0, 3);
                    break;
            }
        }
    }

    /**
     * Checks what key is released, makes the player stop moving in that
     * direction.
     */
    public void keyReleased(KeyEvent evt) {

        switch (evt.getKeyCode()) {

        // Left
        case 37:
            Logger.log("Player released Left", 0, 5);
            game.getPlayerList().get(0).stopMovingLeft();
            break;

        // Right
        case 39:
            Logger.log("Player released right", 0, 5);
            game.getPlayerList().get(0).stopMovingRight();
            break;
            
        default:
            break;
        }
        
    }

	/**
	 * Getter of the game.
	 * @return the current game
	 */
	public Game getGame() {
		return game;
	}
}
