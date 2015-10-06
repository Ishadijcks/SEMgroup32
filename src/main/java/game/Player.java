package game;

import game.log.Logger;
import game.powerups.Powerup;
import game.wall.DuoWall;
import game.wall.PlayerWall;
import game.wall.Wall;

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
    private int y = Settings.getLevelHeight() - Settings.getPlayerHeight()
            + Settings.getTopMargin();
    private int colY = y + 61;
    private int colX;
    private int height = Settings.getPlayerHeight();
    private int width = Settings.getPlayerWidth();
    private int stepSize = Settings.getPlayerStepSize();
    private boolean movingLeft = false;
    private boolean movingRight = false;
    private boolean normalMode;

    public Player(String name, int x, boolean isNormalMode) {
        this.name = name;
        this.x = x;
        
        this.colX = x - 50;
        normalMode = isNormalMode;
        Logger.log("Player created", 1, 4);
    }

    /**
     * The player moves left
     */
    public void movingLeft() {
        movingLeft = true;
        Logger.log("Player is moving left", 1, 5);
    }

    /**
     * The player stops moving left
     */
    public void stopMovingLeft() {
        movingLeft = false;
        Logger.log("Player stopped moving left", 1, 5);
    }

    /**
     * The player moves right
     */
    public void movingRight() {
        movingRight = true;
        Logger.log("Player is moving right", 1, 5);
    }

    /**
     * The player stops moving right
     */
    public void stopMovingRight() {
        movingRight = false;
        Logger.log("Player stopped moving right", 1, 5);
    }

    /**
     * Moves the player left or right, depending on what key is pressed
     */
    public void move(ArrayList<Wall> wallList) {
        if (movingLeft) {
            if (x - stepSize > Settings.getLeftMargin()) {
                if (!wallCollisionLeft(wallList)) {
                    x -= stepSize;
                    colX -= stepSize;
                }
            } else {
                Logger.log("Player is at the left border", 1, 4);
            }
        }

        if (movingRight) {
            if (x + stepSize + width < Settings.getLevelWidth()
                    + Settings.getLeftMargin() + 37) {
             
                if (!wallCollisionRight(wallList)) {

                    x += stepSize;
                    colX += stepSize;
                }

            } else {
                Logger.log("Player is at the right border", 1, 4);
            }
        }

    }

    public boolean wallCollisionRight(ArrayList<Wall> wallList) {
        for (int i = 0; i < wallList.size(); i++) {
            Wall wall = wallList.get(i);
            if (wall instanceof PlayerWall || wall instanceof DuoWall) {
                if (x + stepSize <= (wall.getX() + wall.getWidth())
                        && (x + stepSize + width) >= wall.getX() && wall.isActive()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean wallCollisionLeft(ArrayList<Wall> wallList) {
        for (int i = 0; i < wallList.size(); i++) {
            Wall wall = wallList.get(i);
            if (wall instanceof PlayerWall || wall instanceof DuoWall) {
                if (x-stepSize <= (wall.getX() + wall.getWidth())
                        && (x - stepSize + width) >= wall.getX() && wall.isActive()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * The player shoots a rope from his current position The rope is added to
     * the level
     */
    public void shootRope() {

        if(normalMode)
        {
            if (!NormalDriver.game.getCurrentLevel()
                    .hasRope()) {
                int ropeY = NormalDriver.game.getCurrentLevel().getHeight()
                        - height;
                int ropeX = x + width / 2;
                if(Settings.getPlayerHasIceRope()){
                	System.out.println("YISSS");
                	Rope rope = new IceRope(ropeX, ropeY, normalMode);
                    NormalDriver.game.getCurrentLevel()
                    .setRope(rope);
                    return;
                }else{
	                Rope rope = new Rope(ropeX, ropeY, normalMode);
	                NormalDriver.game.getCurrentLevel().setRope(rope);
	                Logger.log("Shot a rope", 1, 4);
                }
                
            }
        }
        else
        {
            if (!SurvivalDriver.game.getCurrentLevel()
                    .hasRope()) {
                int ropeY = SurvivalDriver.game.getCurrentLevel().getHeight()
                        - height;
                int ropeX = x + width / 2;
                if(Settings.getPlayerHasIceRope()){
                	Rope rope = new IceRope(ropeX, ropeY, normalMode);
                    NormalDriver.game.getCurrentLevel()
                    .setRope(rope);
                    return;
                }else{
	                Rope rope = new Rope(ropeX, ropeY, normalMode);
	                NormalDriver.game.getCurrentLevel().setRope(rope);
	                Logger.log("Shot a rope", 1, 4);                    
                }                
            }

        }
    }

    public boolean hasIceRope() {
        return Settings.getPlayerHasIceRope();
    }

    // Getters and setters
    public String getName() {
        return name;
    }
    
    public void setName(String newName)
    {
        name = newName;
    }

    public boolean getMovingLeft() {
        return movingLeft;
    }

    public boolean getMovingRight() {
        return movingRight;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getCollisionX() {
        return this.colX;
    }

    public int getCollisionY() {
        return this.colY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

	/**
	 * @return the stepSize
	 */
	public int getStepSize() {
		return stepSize;
	}

	/**
	 * @param stepSize the stepSize to set
	 */
	public void setStepSize(int stepSize) {
		this.stepSize = stepSize;
	}

}
