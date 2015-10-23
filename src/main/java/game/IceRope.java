package game;

import game.log.Logger;

/**
 * Class that will control a rope with an ice powerup.
 * 
 * @author Boning
 *
 */
public class IceRope extends Rope {

    /**
     * Constructor for an icerope.
     * 
     * @param xCoord
     *            x-Coordinate of the rope
     * @param yCoord
     *            y-Coordinate of the rope
     */
    public IceRope(int xCoord, int yCoord) {

        super(xCoord, yCoord);
        Logger.log("Ice rope created", 5, 4);
    }

    /**
     * The rope moves up and gets destroyed when it hits the roof.
     */
    @Override
    public void move() {
        Logger.log("Ice rope moved", 5, 5, 100);
       if (super.yCoord <= Driver.game.getCurrentLevel().getTopMargin() - 2) {
          return;
       } 
       else {
           super.yCoord -= ropeSpeed;
       } 
    }

}
