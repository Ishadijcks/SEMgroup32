package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

class MyKeyListener extends KeyAdapter {

    

    /**
     * Checks what key is pressed, moves the player in that direction or shoots
     * a rope
     */
    public void keyPressed(KeyEvent evt) {

       
        Game game = Driver.game;

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
                case 32:
                    Logger.log("Player pressed space", 0, 5);
                    game.getPlayerList().get(0).shootRope();
                    break;
                case 76:
                try {
                    new LogScreen();
                } catch (UnsupportedAudioFileException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (LineUnavailableException e) {
                    e.printStackTrace();
                }
                    break;
                default:
                    Logger.log("keyPressed switch default triggered",0, 3);
                    break;
            }
        }
    }

    /**
     * Checks what key is released, makes the player stop moving in that
     * direction
     */
    public void keyReleased(KeyEvent evt) {

        Game game = Driver.game;

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
        }
    }
}
