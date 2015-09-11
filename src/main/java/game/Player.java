package game;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player {
    private String name;
    private int x;
    private int y = Settings.getLevelHeight() - Settings.getPlayerHeight() + Settings.getTopMargin();
    private int colY = y + 61;
    private int colX;
    private int height = Settings.getPlayerHeight();
    private int width = Settings.getPlayerWidth();
    private int stepSize = Settings.getPlayerStepSize();
    private boolean movingLeft = false;
    private boolean movingRight = false;
    private Powerup powerup = null;

    public Player(String name, int x) {
        this.name = name;
        this.x = x;
        this.colX = x - 50;
    }

    /**
     * The player moves left
     */
    public void movingLeft() {
        movingLeft = true;
    }

    /**
     * The player stops moving left
     */
    public void stopMovingLeft() {
        movingLeft = false;
    }

    /**
     * The player moves right
     */
    public void movingRight() {
        movingRight = true;
    }

    /**
     * The player stops moving right
     */
    public void stopMovingRight() {
        movingRight = false;
    }

    /**
     * Moves the player left or right, depending on what key is pressed
     */
    public void move() {

        if (powerup != null) {

            if (powerup.getName().equals("speed") && powerup.isActive()) {
                stepSize = Settings.getPlayerPowerupStepSize();
            }
        }

        if (movingLeft) {
            if (x - stepSize > Settings.getLeftMargin() + 37) {
                x -= stepSize;
                colX -= stepSize;
            }
        }

        if (movingRight) {
            if (x + stepSize + width < Settings.getLevelWidth() + Settings.getLeftMargin()) {
                x += stepSize;
                colX += stepSize;
            }
        }

        if (powerup != null) {
            if (powerup.getName().equals("speed") && powerup.isActive()) {
                stepSize = Settings.getPlayerStepSize();
                powerup.decreaseFramesLeft();
            }
        }

    }

    /**
     * The player shoots a rope from his current position The rope is added to
     * the level
     */
    public void shootRope() {
        if (!Driver.game.getCurrentLevel()
                .hasRope()) {
            int ropeY = Driver.game.getCurrentLevel().getHeight()
                    - height;
            int ropeX = x + width / 2;
            Rope rope = new Rope(ropeX, ropeY);

            Driver.game.getCurrentLevel()
                    .setRope(rope);
        }
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setPowerup(Powerup powerup) {
        this.powerup = powerup;
    }

    public boolean getMovingLeft(){
        return movingLeft;
    }
    
    public boolean getMovingRight(){
        return movingRight;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public int getCollisionX(){
    	return this.colX;
    }
    
    public int getCollisionY(){
    	return this.colY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Powerup getPowerup() {
        return this.powerup;
    }
    
    public void removePowerUp()
    {
        this.powerup = null;
    }
    
    public boolean hasPowerup(){
    	return this.powerup != null;
    }

}
