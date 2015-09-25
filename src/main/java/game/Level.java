package game;

import game.bubble.Bubble;
import game.log.Logger;
import game.wall.Wall;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

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
     * Constructor, initializes the bubble- and playerList
     */
    public Level(ArrayList<Player> playerList) {
        this.bubbleList = new ArrayList<Bubble>();
        this.playerList = playerList;
        this.powerupList = new ArrayList<Powerup>();
        this.wallList = new ArrayList<Wall>();

        Logger.log("Level created", 8, 4);

    }

    /**
     * Remove bubble.
     * 
     * @param i
     */
    public abstract void destroyBubble(int i);

    public abstract Powerup generatePowerup(int x, int y, int randomNumber1);

    /**
     * Add a bubble to the bubbleList
     * 
     * @param bubble
     */
    public abstract void addBubble(Bubble bubble);

    public void resetBubble() {
        bubbleList = null;
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }

    public void setPowerupList(ArrayList<Powerup> powerupList) {
        this.powerupList = powerupList;
    }

    /**
     * Checks if there is collision between player and a bubble
     * 
     * @return
     */
    public boolean checkCollisionPlayer() {

        return Collisions.checkCollisionPlayer(bubbleList, playerList);

    }

    /**
     * Checks if there is collision between rope and a bubble
     * 
     * @return -1 if there is no collision otherwise the index of the bubble
     */

    public boolean handleCollisionRope() {
        if(hasRope()){
            int collision = Collisions.checkCollisionRope(bubbleList, rope);
            if (collision != -1) {
                destroyBubble(collision);
                setRope(null);
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the player collided with a powerup
     */

    public boolean handlePowerupCollision() {
        int i = Collisions.checkCollisionPowerup(playerList, powerupList);
        if (i != -1) {
            Powerup powerup = powerupList.get(i);

            int powerupListSize = playerList.get(0).getPowerupList().size();
            if (powerupListSize > 0) {
                for (int i1 = 0; i1 < powerupListSize; i1++) {
                    if (playerList.get(0).getPowerupList().get(i1)
                            .samePowerup(powerup)) {
                        playerList.get(0).getPowerupList().get(i1)
                                .resetFramesLeft();
                        Logger.log("Power up time "
                                + playerList.get(0).getPowerupList().get(i1)
                                        .getName() + " reset", 6, 4);
                        increasedPowerupTime = true;
                        powerupList.remove(i);
                    }
                }

            }
            if (!increasedPowerupTime) {
                playerList.get(0).setPowerup(powerupList.get(i));
                Logger.log("Power up time " + powerupList.get(i).getName()
                        + " added", 6, 4);

                powerupList.remove(i);
            }
            increasedPowerupTime = false;
            return true;
        }
        return false;
    }



    /**
     * Calls the add score method from the game.
     * 
     * @param diameter
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
     * Generate random integer.
     * 
     * @param min
     * @param max
     * @return
     */
    public int randomInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
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

    public void checkDuoWalls(int playerX) {
        for (int i = 0; i < wallList.size(); i++) {
            Wall wall = wallList.get(i);
            if (wall instanceof DuoWall) {
                if (playerX < wall.getX()) {
                    if(checkLeftOfWall(wall)){
                    wall.setActive(false);
                    }
                    
                } else {
                    if(checkRightOfWall(wall)){
                        wall.setActive(false);
                    }
                }
            }

        }

    }

    public boolean checkLeftOfWall(Wall wall) {
        for (int i = 0; i < bubbleList.size(); i++) {
            if (bubbleList.get(i).getX() < wall.getX()) {
                return false;
            }
        }
        return true;
    }

    public boolean checkRightOfWall(Wall wall) {
        for (int i = 0; i < bubbleList.size(); i++) {
            if (bubbleList.get(i).getX() > wall.getX()) {
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
                if ((bubble.getX() <= (wall.getX() + wall.getWidth()) && (bubble
                        .getX() + bubble.getDiameter()) >= wall.getX())
                        && wall.isActive()) {
                    if (wall instanceof BubbleWall) {
                        wall.BouncedOn();
                    }

                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Add a powerup to the powerupList
     * 
     * @param powerup
     *            powerup to add
     */
    public void addPowerup(Powerup powerup) {
        if (!powerupList.contains(powerup)) {
            powerupList.add(powerup);
        }
    }

    public void addWall(Wall wall) {
        if (!wallList.contains(wall)) {
            wallList.add(wall);
        }
    }

    public boolean hasRope() {
        return rope != null;
    }

    // Getters and Setters
    public ArrayList<Bubble> getBubbleList() {
        return bubbleList;
    }

    public ArrayList<Wall> getWallList() {
        return wallList;
    }

    public ArrayList<Powerup> getPowerupList() {
        return powerupList;
    }

    // Getters and Setters
    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Rope getRope() {
        return rope;
    }

    public int getNumberOfRopes() {
        return this.numberOfRopes;
    }

    public void setRope(Rope rope) {
        this.rope = rope;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Level other = (Level) obj;
		if (bubbleList == null) {
			if (other.bubbleList != null)
				return false;
		} else if (!bubbleList.equals(other.bubbleList))
			return false;
		if (height != other.height)
			return false;
		if (increasedPowerupTime != other.increasedPowerupTime)
			return false;
		if (numberOfRopes != other.numberOfRopes)
			return false;
		if (playerList == null) {
			if (other.playerList != null)
				return false;
		} else if (!playerList.equals(other.playerList))
			return false;
		if (powerupList == null) {
			if (other.powerupList != null)
				return false;
		} else if (!powerupList.equals(other.powerupList))
			return false;
		if (rope == null) {
			if (other.rope != null)
				return false;
		} else if (!rope.equals(other.rope))
			return false;
		if (timeLeft != other.timeLeft)
			return false;
		if (wallList == null) {
			if (other.wallList != null)
				return false;
		} else if (!wallList.equals(other.wallList))
			return false;
		if (width != other.width)
			return false;
		return true;
	}

}
