package game;
import java.util.ArrayList;

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

    /**
     * Checks if there is collision between player and a bubble
     * 
     * @return
     */
    public boolean checkCollisionPlayer() {
        for (int i = 0; i < bubbleList.size(); i++) {
            // if the x of the player and the bubble is the same
            // then there is a chance the rope hits the bubble
            // /// Diameter NOT IN ACCOUNT JET AND SIZE OF PLAYER
            Player player = playerList.get(0);

            if (bubbleList.get(i).getX() == player.getX()) {
                if (height - player.getHeight() <= bubbleList.get(i).getY()) {

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
    public void checkCollisionRope(boolean dragonIsRight) {
        if (hasRope()) {
            for (int i = 0; i < bubbleList.size(); i++) {
                // if the x of the rope and the bubble is the same
                // then there is a chance the rope hits the bubble
                // /// RADIUS NOT IN ACCOUNT JET
            	if(dragonIsRight)
            	{
            		if (bubbleList.get(i).getX() < rope.getX()) {
                        if (bubbleList.get(i).getX()
                                + bubbleList.get(i).getDiameter() > rope.getX()) {
                            if (bubbleList.get(i).getY()
                                    + bubbleList.get(i).getDiameter() >= rope.getY()) {
                                destroyBubble(i);
                                setRope(null);
                                return;
                            }
                        }
                    }
            	}
            	else
            	{
            		if (bubbleList.get(i).getX() < rope.getX() - 35) {
                        if (bubbleList.get(i).getX()
                                + bubbleList.get(i).getDiameter() > rope.getX() - 35) {
                            if (bubbleList.get(i).getY()
                                    + bubbleList.get(i).getDiameter() >= rope.getY()) {
                                destroyBubble(i);
                                setRope(null);
                                return;
                            }
                        }
                    }
            	}
                
            }
        }
    }

    /**
     * Checks if the player collided with a powerup
     */

    public void checkPowerupCollision() {

        Player player1 = playerList.get(0);
        for (int i = 0; i < powerupList.size(); i++) {
            Powerup powerup = powerupList.get(i);

            if (player1.getX() <= (powerup.getX() + powerup.getWidth())
                    && (player1.getX() + player1.getWidth()) >= powerup.getX()
                    && player1.getY() <= (powerup.getY() + powerup.getHeight())
                    && (powerup.getY() + powerup.getHeight()) >= powerup.getY()) {
                playerList.get(0).setPowerup(powerupList.get(i));
                powerupList.remove(i);
            }
        }
    }


    public void destroyBubble(int i) {

        Bubble bubble = bubbleList.get(i);
        int x = bubble.getX();
        int y = bubble.getY();
        int diameter = bubble.getDiameter();
        bubbleList.remove(i);


        if (diameter > 10) {
            Bubble newBubble1 = new Bubble(diameter / 2, x, y, false, false);
            Bubble newBubble2 = new Bubble(diameter / 2, x, y, true, false);

            bubbleList.add(newBubble1);
            bubbleList.add(newBubble2);

        }
        if (Settings.getPowerupChance() > Math.random() * 100) {
            Powerup powerup = generatePowerup(x, y);
            powerupList.add(powerup);
        }

        if (bubbleList.isEmpty()) {
            System.out.println("Yay you won!!!!");
        }

    }

    public Powerup generatePowerup(int x, int y) {
        int randomNumber = (int) Math.floor(Math.random() * 1 + 1);
        switch (randomNumber) {
            case 1:
                return new Powerup("speed", x, y);
            default:
                return new Powerup("speed", x, y);
        }
    }

    public void resetLevel() {
        // reset the level
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