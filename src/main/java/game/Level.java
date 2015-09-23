package game;

import game.bubble.Bubble;
import game.log.Logger;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class Level {
    private ArrayList<Bubble> bubbleList;
    private ArrayList<Player> playerList;
    private ArrayList<Powerup> powerupList;
    private ArrayList<Wall> wallList;
    private Rope rope = null;
    private int numberOfRopes = 0;
    private int timeLeft;
    private int width = Settings.getLevelWidth();
    private int height = Settings.getLevelHeight();
    private boolean increasedPowerupTime = false;

    /**
     * Constructor, initializes the bubble- and playerList
     */
    public Level(ArrayList<Player> playerList) {
        this.bubbleList = new ArrayList<Bubble>();
        this.playerList = playerList;
        this.powerupList = new ArrayList<Powerup>();
        this.wallList = new ArrayList<Wall>();
        Logger.log("Level created",8,4);
    }

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
        for (int i = 0; i < bubbleList.size(); i++) {
        	Bubble bubble = bubbleList.get(i);
            // if the x of the player and the bubble is the same
            // then there is a chance the rope hits the bubble
            // /// Diameter NOT IN ACCOUNT JET AND SIZE OF PLAYER
            Player player = playerList.get(0);


            if (player.getX() <= (bubble.getX() + bubble.getDiameter())
                    && (player.getCollisionX() + player.getWidth()) >= bubble.getX()
                    && player.getCollisionY() <= (bubble.getY() + bubble.getDiameter())
                    && (player.getY() + player.getHeight()) >= bubble.getY()) {
                if (player.getCollisionY() <= bubble.getY()) {
                    Logger.log("Player collided with a bubble",8,4);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if there is collision between rope and a bubble
     * 
     * @return -1 if there is no collision otherwise the index of the bubble
     */
    public boolean checkCollisionRope() {
        if (hasRope()) {
            for (int i = 0; i < bubbleList.size(); i++) {
                // if the x of the rope and the bubble is the same
                // then there is a chance the rope hits the bubble
                // /// RADIUS NOT IN ACCOUNT JET
                if (bubbleList.get(i).getX() <= rope.getX()) {
                    if (bubbleList.get(i).getX()
                            + bubbleList.get(i).getDiameter() >= rope.getX()) {
                        if (bubbleList.get(i).getY()
                                + bubbleList.get(i).getDiameter() >= rope
                                    .getY()) {
                        	System.out.println(i);
                            destroyBubble(i);
                            setRope(null);
                            Logger.log("Rope collided with a bubble",8,4);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * Checks if the player collided with a powerup
     */

    public boolean checkPowerupCollision() {

        Player player1 = playerList.get(0);
        for (int i = 0; i < powerupList.size(); i++) {
            Powerup powerup = powerupList.get(i);
            
            if (player1.getCollisionX() <= (powerup.getX() + powerup.getWidth())
                    && (player1.getCollisionX() + player1.getWidth()) >= powerup.getX()
                    && player1.getCollisionY() <= (powerup.getY() + powerup.getHeight())
                    && (player1.getY() + player1.getHeight()) >= powerup.getY()) {
                
                Logger.log("Player collided with a powerup",8,4);
                
                int powerupListSize = playerList.get(0).getPowerupList().size();
                if(powerupListSize > 0)
                {
                    for(int i1 = 0; i1 < powerupListSize; i1++)
                    {
                        if(playerList.get(0).getPowerupList().get(i1).samePowerup(powerup))
                        {
                            playerList.get(0).getPowerupList().get(i1).resetFramesLeft();
                            Logger.log("Power up time " +playerList.get(0).getPowerupList().get(i1).getName()+" reset", 6, 4);
                            increasedPowerupTime = true;
                            powerupList.remove(i);
                        }
                    }
                }
                if(!increasedPowerupTime)
                {
                    playerList.get(0).setPowerup(powerupList.get(i));
                    Logger.log("Power up time " +powerupList.get(i).getName()+" added", 6, 4);
                    
                    powerupList.remove(i);
                }
                increasedPowerupTime = false;
                return true;
            }
        }
        return false;
    }

    /**
     * Remove bubble.
     * @param i
     */
    public void destroyBubble(int i) {

        Bubble bubble = bubbleList.get(i);
        int x = bubble.getX();
        int y = bubble.getY();
        int diameter = bubble.getDiameter();
        
        addScore(diameter);
        bubbleList.remove(i);

        bubbleList.addAll(bubble.destroyBubble(x, y));
        
        if (Settings.getPowerupChance() > Math.random() * 100) {
            Powerup powerup = generatePowerup(x, y, randomInt(1,3));
            powerupList.add(powerup);
        }
    }
    
    /**
     * Calls the add score method from the game.
     * @param diameter
     */
    public void addScore(int diameter){
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
     * @param min
     * @param max
     * @return
     */
    public int randomInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public Powerup generatePowerup(int x, int y, int randomNumber1) {
        int randomNumber = randomNumber1;
        switch (randomNumber) {
        case 1:
            Logger.log("Powerup speed spawned", 6, 4);
            return new Powerup("speed", x, y);
        case 2:
            Logger.log("Powerup life spawned", 6, 4);
            return new Powerup("life", x, y);
        case 3:
            Logger.log("Powerup ice spawned", 6, 4);
            return new Powerup("ice", x, y);
        default:
            Logger.log("Powerup speed spawned", 6, 4);
            Logger.log("generatePowerup switch default triggered",6, 3);
            return new Powerup("speed", x, y);
        }
    }

    /**
     * Add a bubble to the bubbleList
     * 
     * @param bubble
     *            bubble to add
     */
    public void addBubble(Bubble bubble) {
        if (!bubbleList.contains(bubble)) {
            bubbleList.add(bubble);
        }
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
}
