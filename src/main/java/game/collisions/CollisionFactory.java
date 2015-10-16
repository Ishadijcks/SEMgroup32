package game.collisions;

import java.util.ArrayList;

/**
 * Collision factory build all collisions.
 * 
 * @author Felix
 *
 */
public class CollisionFactory {

    /**
     * The constructor.
     */
    public CollisionFactory() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Builder of all collisions .
     * 
     * @return a list of the collisions.
     */
    public ArrayList<Collision> buildAllCollisions() {
        ArrayList<Collision> collisions = new ArrayList<Collision>();

        collisions.add(buildPlayerBubbleCollision());
        collisions.add(buildPlayerPowerupCollision());
        collisions.add(buildRopeBubbleCollision());
        collisions.add(buildWallBubbleCollision());
        collisions.add(buildWallPlayerCollision());

        return collisions;
    }

    /**
     * Builder of the player with bubble collision.
     * 
     * @return the Collision object
     */
    public Collision buildPlayerBubbleCollision() {
        return new PlayerBubbleCollision();
    }

    /**
     * Build of the player and powerup collisions.
     * @return the Collision object
     */
    public Collision buildPlayerPowerupCollision() {
        return new PlayerPowerupCollision();
    }

    /**
     * Builder of the rope and bubble collision.
     * @return the Collision object
     */
    public Collision buildRopeBubbleCollision() {
        return new RopeBubbleCollision();
    }

    /**
     * BUilder of the wall and bubble collision.
     * @return the Collision object
     */
    public Collision buildWallBubbleCollision() {
        return new WallBubbleCollision();
    }

    /**
     * Builder of wall and player collision.
     * @return the Collision object
     */
    public Collision buildWallPlayerCollision() {
        return new WallPlayerCollision();
    }

}
