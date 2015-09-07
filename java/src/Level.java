import java.util.ArrayList;

public class Level {
    private ArrayList<Bubble> bubbleList;
    private ArrayList<Player> playerList;
    private ArrayList<Powerup> powerupList;
    private Rope rope = null;
    private int timeLeft;
    private int width = 675;
    private int height = 350;

    /**
     * Constructor, initializes the bubble- and playerList
     */
    public Level() {
        this.bubbleList = new ArrayList<Bubble>();
        this.playerList = new ArrayList<Player>();
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
            // /// RADIUS NOT IN ACCOUNT JET AND SIZE OF PLAYER
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
    public void checkCollisionRope() {
        if (hasRope()) {
            for (int i = 0; i < bubbleList.size(); i++) {
                // if the x of the rope and the bubble is the same
                // then there is a chance the rope hits the bubble
                // /// RADIUS NOT IN ACCOUNT JET
                if (bubbleList.get(i).getX() < rope.getX()) {
                    if (bubbleList.get(i).getX()
                            + bubbleList.get(i).getRadius() > rope.getX()) {
                        if (bubbleList.get(i).getY()
                                + bubbleList.get(i).getRadius() >= rope.getY()) {
                            destroyBubble(i);
                            setRope(null);
                            return;
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

    private double distance(float x, float y, float x2, float y2) {
        // TODO Auto-generated method stub
        float xDis = x - x2;
        float yDis = y - y2;

        return Math.sqrt(xDis * xDis + yDis * yDis);
    }

    public void destroyBubble(int i) {

        Bubble bubble = bubbleList.get(i);
        int x = bubble.getX();
        int y = bubble.getY();
        int radius = bubble.getRadius();
        bubbleList.remove(i);
        if (radius > 5) {
            Bubble newBubble1 = new Bubble(radius / 2, x, y, false, false);
            Bubble newBubble2 = new Bubble(radius / 2, x, y, true, false);
            bubbleList.add(newBubble1);
            bubbleList.add(newBubble2);

        }
        if (10 > Math.random() * 100) {
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

    public void addPowerup(Powerup powerup) {
        if (!powerupList.contains(powerup)) {
            powerupList.add(powerup);
        }
    }

    /**
     * Add a player to the playerList
     * 
     * @param player
     *            player to add
     */
    public void addPlayer(Player player) {
        if (!playerList.contains(player)) {
            playerList.add(player);
        }
    }

    public boolean hasRope() {
        return rope != null;
    }

    // Getters and Setters
    public ArrayList<Bubble> getBubbleList() {
        return bubbleList;
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
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
