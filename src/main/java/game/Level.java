package game;

import game.bubble.Bubble;
import game.log.Logger;
import game.powerups.Powerup;
import game.wall.BubbleWall;
import game.wall.DuoWall;
import game.wall.Wall;

import java.util.ArrayList;

/**
 * Class that will handle everything in a level.
 * @author Boning
 */
public abstract class Level {
    protected ArrayList<Bubble> bubbleList;
    protected ArrayList<Player> playerList;
    protected ArrayList<Powerup> powerupList;
    protected ArrayList<Wall> wallList;
    protected Rope rope = null;
    protected int numberOfRopes = 0;
    protected int timeLeft;
    protected int width = Settings.getLevelWidth();
    protected int height = Settings.getLevelHeight();
    protected boolean increasedPowerupTime = false;

    /**
     * Constructor, initializes the bubble- and playerList.
     * @param playerList list of players in the level
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
     * @param bubble The bubble that is added
     */
    public abstract void addBubble(Bubble bubble);

    /**
     * Resets all bubbles by setting the list to null.
     */
    public void resetBubble() {
        bubbleList = null;
    }

    /**
     * Getter for the list of the players.
     * @return the list of players
     */
    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    /**
     * Setter for the list of the players.
     * @param playerList The new list of players that should be used
     */
    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }

    /**
     * Setter for the list of the powerups.
     * @param powerupList The new list of the powerups that should be used
     */
    public void setPowerupList(ArrayList<Powerup> powerupList) {
        this.powerupList = powerupList;
    }

    /**
     * Calls the add score method from the game.
     * @param diameter the diameter of the ball
     */
    public void addScore(int diameter) {
        switch (diameter) {
        case 8:
            NormalDriver.score.addScore(10);
            break;
        case 16:
            NormalDriver.score.addScore(15);
            break;
        case 32:
            NormalDriver.score.addScore(20);
            break;
        case 64:
            NormalDriver.score.addScore(25);
            break;
        case 128:
            NormalDriver.score.addScore(30);
            break;
        default:
            break;
        }
    }

    /**
     * Moves all the bubbles in the bubbleList.
     */
    public void moveBubbles() {
        for (int i = 0; i < bubbleList.size(); i++) {
            if (bubbleBounceWall(bubbleList.get(i))) {
                bubbleList.get(i).bounceH();

            }
            bubbleList.get(i).move();
        }
    }

    /**
     * Checks if there is a duo wall.
     * @param playerX x-Coordinate of the player
     */
    public void checkDuoWalls(int playerX) {
        for (int i = 0; i < wallList.size(); i++) {
            Wall wall = wallList.get(i);
            if (wall instanceof DuoWall) {
                if (playerX < wall.getxCoord()) {
                    if (checkLeftOfWall(wall)) {
                    wall.setActive(false);
                    }
                    
                } else {
                    if (checkRightOfWall(wall)) {
                        wall.setActive(false);
                    }
                }
            }

        }

    }

    /**
     * Check the left side of the wall.
     * @param wall The wall that is checked
     * @return True if the bubble is left of the wall, false if it is right
     */
    public boolean checkLeftOfWall(Wall wall) {
        for (int i = 0; i < bubbleList.size(); i++) {
            if (bubbleList.get(i).getX() < wall.getxCoord()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check the right side of the wall.
     * @param wall The wall that is checked
     * @return True if the bubble is right of the wall, false if it is left
     */
    public boolean checkRightOfWall(Wall wall) {
        for (int i = 0; i < bubbleList.size(); i++) {
            if (bubbleList.get(i).getX() > wall.getxCoord()) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Returns true if the bubble is going to bounce on a wall.
     * 
     * @param bubble
     *            to check
     * @return if the bubble is going to bounce on a wall
     */
    private boolean bubbleBounceWall(Bubble bubble) {

        for (int i = 0; i < wallList.size(); i++) {
            Wall wall = wallList.get(i);

            if ((wall instanceof BubbleWall || wall instanceof DuoWall)
                    && wall.isActive()) {
                if ((bubble.getX() <= (wall.getxCoord() + wall.getWidth()) && (bubble
                        .getX() + bubble.getDiameter()) >= wall.getxCoord())
                        && wall.isActive()) {
                    if (wall instanceof BubbleWall) {
                        wall.bouncedOn();
                    }

                    return true;
                }
            }
        }
        return false;
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
     * @param wall that is added
     */
    public void addWall(Wall wall) {
        if (!wallList.contains(wall)) {
            wallList.add(wall);
        }
    }

    /**
     * Checks if the level has a rope.
     * @return true if it has, false otherwise
     */
    public boolean hasRope() {
        return rope != null;
    }

    /**
     * Getter for the bubble list.
     * @return List of the bubbles
     */
    public ArrayList<Bubble> getBubbleList() {
        return bubbleList;
    }

    /**
     * Getter for the wall list.
     * @return List of the walls
     */
    public ArrayList<Wall> getWallList() {
        return wallList;
    }

    /**
     * Getter for the powerup list.
     * @return List of the powerups
     */
    public ArrayList<Powerup> getPowerupList() {
        return powerupList;
    }

    /**
     * Getter of the height of the level.
     * @return height of the level
     */
    public int getHeight() {
        return height;
    }

    /**
     * Getter of the width of the level.
     * @return width of the level
     */
    public int getWidth() {
        return width;
    }

    /**
     * Getter of the rope of the level.
     * @return rope of the level
     */
    public Rope getRope() {
        return rope;
    }

    /**
     * Setter for the rope.
     * @param rope that is active
     */
    public void setRope(Rope rope) {
        this.rope = rope;
    }

    /**
     * Generated equals method to check if all attributes 
     * equals another of the same class.
     * @param obj Object that it will compare to
     * @return true if the object is from the same type and has the same attributes
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
		if (timeLeft != other.timeLeft) {
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

}
