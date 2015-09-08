package game;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class MyKeyListener extends KeyAdapter {

    Game game = Driver.game;

    /**
     * Checks what key is pressed, moves the player in that direction or shoots
     * a rope
     */
    public void keyPressed(KeyEvent evt) {
       
        if (game.inProgress()) {

            Level curLevel = game.getCurrentLevel();

            
            switch (evt.getKeyCode()) {

            // Left
                case 37:
                    game.getPlayerList().get(0).movingLeft();
                    break;
            // Right
                case 39:
                    game.getPlayerList().get(0).movingRight();
                    break;
                case 32:
                    game.getPlayerList().get(0).shootRope();
                    break;
            
                default:
                    break;
            }
        }
    }

    /**
     * Checks what key is released, makes the player stop moving in that
     * direction
     */
    public void keyReleased(KeyEvent evt) {

        Level curLevel = game.getCurrentLevel();

        switch (evt.getKeyCode()) {

        // Left
        case 37:
            game.getPlayerList().get(0).stopMovingLeft();
            break;

        // Right
        case 39:
            game.getPlayerList().get(0).stopMovingRight();
            break;
        }
    }
}
