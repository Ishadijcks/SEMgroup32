package game;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class Level {
    private ArrayList<Bubble> bubbleList;
    private ArrayList<Player> playerList;
    private ArrayList<Powerup> powerupList;
    private Rope rope = null;
    private int timeLeft;
    private int width = Settings.getLevelWidth();
    private int height = Settings.getLevelHeight();

    /**
     * Constructor, initializes the bubble- and playerList
     */
    public Level(ArrayList<Player> playerList) {
        this.bubbleList = new ArrayList<Bubble>();
        this.playerList = playerList;
        this.powerupList = new ArrayList<Powerup>();
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


            if (bubble.getX() < player.getX() + 22 && bubble.getX() > player.getX() - 58) {
                if (player.getCollisionY() <= bubble.getY()) {
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
                            destroyBubble(i);
                            setRope(null);
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
                playerList.get(0).setPowerup(powerupList.get(i));
                powerupList.remove(i);
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
        // Sets the color depending on the radius of the bubble
        addScore(diameter);
        bubbleList.remove(i);

        if (diameter > 10) {
            Bubble newBubble1 = new Bubble(diameter / 2, x, y, false, false);
            Bubble newBubble2 = new Bubble(diameter / 2, x, y, true, false);

            bubbleList.add(newBubble1);
            bubbleList.add(newBubble2);

        }
        if (Settings.getPowerupChance() > Math.random() * 100) {
            Powerup powerup = generatePowerup(x, y, randomInt(1,2));
            powerupList.add(powerup);
        }

        if (bubbleList.isEmpty()) {
          
        }

    }
    
    /**
     * Calls the add score method from the game.
     * @param diameter
     */
    public void addScore(int diameter){
        switch (diameter) {
        case 8:
            Driver.game.addScore(10);
            break;
        case 16:
            Driver.game.addScore(15);
            break;
        case 32:
            Driver.game.addScore(20);
            break;
        case 64:
            Driver.game.addScore(25);
            break;
        case 128:
            Driver.game.addScore(30);
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

    public Powerup generatePowerup(int x, int y, int randomNum) {
        int randomNumber = randomNum;
        switch (randomNumber) {
        case 1:
            return new Powerup("speed", x, y);
        case 2:
            return new Powerup("life", x, y);
        default:
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

    public boolean hasRope() {
        return rope != null;
    }

    // Getters and Setters
    public ArrayList<Bubble> getBubbleList() {
        return bubbleList;
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

    public void setRope(Rope rope) {
        this.rope = rope;
    }
}
