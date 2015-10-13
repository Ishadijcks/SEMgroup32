package game;

import java.util.ArrayList;

import game.bubble.Bubble;
import game.log.Logger;
import game.observers.BubbleCollisionObserver;
import game.observers.Observable;
import game.observers.Observer;
import game.observers.PowerupCollisionObserver;
import game.observers.RopeCollisionObserver;
import game.observers.WallBubbleCollisionObserver;
import game.observers.WallPlayerCollisionObserver;
import game.powerups.Powerup;
import game.wall.Wall;

/**
 * Handles all the collisions.
 * 
 * @author Tim
 *
 */
public class Collisions implements Observable {

    private Game game;
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    private Observer ropeColObserver = new RopeCollisionObserver(this);
    private Observer powerupColObserver = new PowerupCollisionObserver(this);
    private Observer bubbleColObserver = new BubbleCollisionObserver(this);
    private Observer wallBubbleColObserver = new WallBubbleCollisionObserver(
            this);
    private Observer wallPlayerColObserver = new WallPlayerCollisionObserver(
            this);

    /**
     * constructor.
     */
    public Collisions() {
    }

    /**
     * All the possible collisions in the game.
     * 
     * @param game
     *            current game.
     */
    public void allCollisions(Game game) {
        this.game = game;
        Level curLevel = game.getCurrentLevel();
        ArrayList<Player> playerList = game.getPlayerList();
        ArrayList<Bubble> bubbleList = curLevel.getBubbleList();
        ArrayList<Wall> wallList = curLevel.getWallList();
        ArrayList<Powerup> powerupList = curLevel.getPowerupList();

        if (curLevel.hasRope()) {
            checkCollisionRope(bubbleList, curLevel.getRope());
        }
        checkCollisionPowerup(playerList, powerupList);
        checkCollisionPlayer(bubbleList, playerList);
        checkPlayerCollisionWall(wallList, playerList);
        checkBubbleCollisionWall(wallList, bubbleList);
    }

    /**
     * Checks the collisions of the bubbles with the player.
     * 
     * @param bubbleList
     *            List of bubbles
     * @param playerList
     *            List of players
     * @return true if there is a collision, false otherwise
     */
    public boolean checkCollisionPlayer(ArrayList<Bubble> bubbleList,
            ArrayList<Player> playerList) {

        Player player = playerList.get(0);

        for (Bubble bubble : bubbleList) {
            if (player.getX() <= (bubble.getX() + bubble.getDiameter())
                    && (player.getCollisionX() + player.getWidth()) >= bubble
                            .getX()
                    && player.getCollisionY() <= (bubble.getY() + bubble
                            .getDiameter())
                    && (player.getY() + player.getHeight()) >= bubble.getY()) {
                if (player.getCollisionY() <= bubble.getY()) {
                    Logger.log("Player collided with a bubble", 8, 4);
                    bubbleColObserver.update(bubble, player, game);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks the collisions of the rope with the bubble.
     * 
     * @param bubbleList
     *            List of bubbles
     * @param rope
     *            The rope of the player
     * @return The index of the bubble will be returned, it will return -1 if
     *         there is no collision
     */
    public boolean checkCollisionRope(ArrayList<Bubble> bubbleList, Rope rope) {
        for (Bubble bubble : bubbleList) {
            if (bubble.getX() <= rope.getX()) {
                if (bubble.getX() + bubble.getDiameter() >= rope.getX()) {
                    if (bubble.getY() + bubble.getDiameter() >= rope.getY()) {
                        Logger.log("Rope collided with a bubble", 8, 4);
                        ropeColObserver.update(bubble, rope, game);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Checks the player collision with wall.
     * 
     * @param wallList
     *            all the walls in the current level
     * @param playerList
     *            All the players in the current level
     * @return return true if collision
     */
    public boolean checkPlayerCollisionWall(ArrayList<Wall> wallList,
            ArrayList<Player> playerList) {
        Player player = playerList.get(0);
        for (Wall wall : wallList) {
            if (wall.expectPlayerCollision(player.getX(),
                    player.getMovingLeft())) {
                wallPlayerColObserver.update(wall, player, game);
                return true;
            }
        }
        return false;
    }

    /**
     * Checks a collision between the player and a powerup.
     * 
     * @param playerList all players
     * @param powerupList all power ups
     * @return boolean
     */
    public boolean checkCollisionPowerup(ArrayList<Player> playerList,
            ArrayList<Powerup> powerupList) {
        Player player1 = playerList.get(0);
        for (Powerup powerup : powerupList) {
            if (player1.getCollisionX() <= (powerup.getX() + powerup.getWidth())
                    && (player1.getCollisionX() + player1.getWidth()) >= powerup
                            .getX()
                    && player1.getCollisionY() <= (powerup.getY() + powerup
                            .getHeight())
                    && (player1.getY() + player1.getHeight()) >= powerup.getY()) {
                Logger.log("Player collided with a powerup", 8, 4);
                powerupColObserver.update(powerup, player1, game);

                return true;
            }
        }
        return false;
    }

    /**
     * Checks the collisions between wall and bubble.
     * 
     * @param wallList
     *            all walls in current level
     * @param bubbleList
     *            all bubbles in current level
     * @return true if collides
     */
    public boolean checkBubbleCollisionWall(ArrayList<Wall> wallList,
            ArrayList<Bubble> bubbleList) {
        for (Bubble bubble : bubbleList) {
            for (Wall wall : wallList) {
                if (wall.expectBubbleCollision(bubble.getX(),
                        bubble.getDiameter())) {
                    wallBubbleColObserver.update(wall, bubble, game);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void registerObserver(Observer ob) {
    	observers.add(ob);
    }

    @Override
    public void removeObserver(Observer ob) {
        observers.remove(ob);

    }

    @Override
    public void notifyObservers() {
        // TODO Auto-generated method stub

    }
}
