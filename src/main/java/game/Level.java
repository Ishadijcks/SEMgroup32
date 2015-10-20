package game;

import game.bubble.Bubble;
import game.log.Logger;
import game.powerups.Powerup;
import game.wall.Wall;

import java.util.ArrayList;

/**
 * Class that will handle everything in a level.
 * 
 * @author Boning
 */
public abstract class Level {
    protected ArrayList<Bubble> bubbleList;
    protected ArrayList<Player> playerList;
    protected ArrayList<Powerup> powerupList;
    protected ArrayList<Wall> wallList;
    protected Rope rope = null;
    protected int numberOfRopes = 0;
    protected final int width = 850;
    protected final int height = 500;
    protected boolean increasedPowerupTime = false;
    
    protected final int topMargin = 50;
    protected final int leftMargin = 75;

    /**
     * Constructor, initializes the bubble- and playerList.
     * 
     * @param playerList
     *            list of players in the level
     */
    public Level(ArrayList<Player> playerList) {
        this.bubbleList = new ArrayList<Bubble>();
        this.playerList = playerList;
        this.powerupList = new ArrayList<Powerup>();
        this.wallList = new ArrayList<Wall>();

        Logger.log("Level created", 8, 4);

    }

    /**
     * Add a bubble to the bubbleList.
     * 
     * @param bubble
     *            The bubble that is added
     */
    public abstract void addBubble(Bubble bubble);

    /**
     * Resets all bubbles by setting the list to null.
     */
    public void resetBubble() {
        bubbleList = new ArrayList<Bubble>();
    }

    /**
     * Getter for the list of the players.
     * 
     * @return the list of players
     */
    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    /**
     * Setter for the list of the players.
     * 
     * @param playerList
     *            The new list of players that should be used
     */
    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }

    /**
     * Setter for the list of the powerups.
     * 
     * @param powerupList
     *            The new list of the powerups that should be used
     */
    public void setPowerupList(ArrayList<Powerup> powerupList) {
        this.powerupList = powerupList;
    }

    /**
     * Moves all the bubbles in the bubbleList.
     */
    public void moveBubbles() {
        for (Bubble bubble : bubbleList) {
            bubble.move();
        }
    }

    /**
     * Add a powerup to the powerupList.
     * 
     * @param powerup
     *            powerup to add
     */
    public void addPowerup(Powerup powerup) {
        if (!powerupList.contains(powerup)) {
            powerupList.add(powerup);
        }
    }

    /**
     * Add a wall to a level.
     * 
     * @param wall
     *            that is added
     */
    public void addWall(Wall wall) {
        if (!wallList.contains(wall)) {
            wallList.add(wall);
        }
    }

    /**
     * Checks if the level has a rope.
     * 
     * @return true if it has, false otherwise
     */
    public boolean hasRope() {
        return rope != null;
    }

    /**
     * Getter for the bubble list.
     * 
     * @return List of the bubbles
     */
    public ArrayList<Bubble> getBubbleList() {
        return bubbleList;
    }

    /**
     * Getter for the wall list.
     * 
     * @return List of the walls
     */
    public ArrayList<Wall> getWallList() {
        return wallList;
    }

    /**
     * Getter for the powerup list.
     * 
     * @return List of the powerups
     */
    public ArrayList<Powerup> getPowerupList() {
        return powerupList;
    }

    /**
     * Getter of the height of the level.
     * 
     * @return height of the level
     */
    public int getHeight() {
        return height;
    }

    /**
     * Getter of the width of the level.
     * 
     * @return width of the level
     */
    public int getWidth() {
        return width;
    }

    /**
     * Getter of the rope of the level.
     * 
     * @return rope of the level
     */
    public Rope getRope() {
        return rope;
    }

    /**
     * Setter for the rope.
     * 
     * @param rope
     *            that is active
     */
    public void setRope(Rope rope) {
        this.rope = rope;
    }

    /**
     * Generated equals method to check if all attributes equals another of the
     * same class.
     * 
     * @param obj
     *            Object that it will compare to
     * @return true if the object is from the same type and has the same
     *         attributes
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Level other = (Level) obj;
        if (bubbleList == null) {
            if (other.bubbleList != null) {
                return false;
            }
        } else if (!bubbleList.equals(other.bubbleList)) {
            return false;
        }
        if (height != other.height) {
            return false;
        }
        if (increasedPowerupTime != other.increasedPowerupTime) {
            return false;
        }
        if (numberOfRopes != other.numberOfRopes) {
            return false;
        }
        if (playerList == null) {
            if (other.playerList != null) {
                return false;
            }
        } else if (!playerList.equals(other.playerList)) {
            return false;
        }
        if (powerupList == null) {
            if (other.powerupList != null) {
                return false;
            }
        } else if (!powerupList.equals(other.powerupList)) {
            return false;
        }
        if (rope == null) {
            if (other.rope != null) {
                return false;
            }
        } else if (!rope.equals(other.rope)) {
            return false;
        }
        if (wallList == null) {
            if (other.wallList != null) {
                return false;
            }
        } else if (!wallList.equals(other.wallList)) {
            return false;
        }
        if (width != other.width) {
            return false;
        }
        return true;
    }

	/**
	 * @return the topMargin
	 */
	public int getTopMargin() {
		return topMargin;
	}

	/**
	 * @return the leftMargin
	 */
	public int getLeftMargin() {
		return leftMargin;
	}

}
