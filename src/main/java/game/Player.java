package game;

import game.log.Logger;
import game.wall.DuoWall;
import game.wall.PlayerWall;
import game.wall.Wall;

import java.util.ArrayList;

/**
 * Class that will control a player.
 * @author Boning
 *
 */
public class Player {
    private String name;
    private int xCoord;
    private int yCoord = Settings.getLevelHeight() - Settings.getPlayerHeight()
            + Settings.getTopMargin();
    private int colY = yCoord + 61;
    private int colX;
    private int height = Settings.getPlayerHeight();
    private int width = Settings.getPlayerWidth();
    private int stepSize = Settings.getPlayerStepSize();
    private boolean movingLeft = false;
    private boolean movingRight = false;
    private boolean normalMode;
    private ArrayList<Powerup> powerupList = new ArrayList<Powerup>();

    /**
     * Constructor for a player.
     * @param name of the player
     * @param xCoord x-Coordinate of the player
     * @param isNormalMode true if it is a normal game, false otherwise
     */
    public Player(String name, int xCoord, boolean isNormalMode) {
        this.name = name;
        this.xCoord = xCoord;
        
        this.colX = xCoord - 50;
        normalMode = isNormalMode;
        Logger.log("Player created", 1, 4);
    }

    /**
     * The player moves left.
     */
    public void movingLeft() {
        movingLeft = true;
        Logger.log("Player is moving left", 1, 5);
    }

    /**
     * The player stops moving left.
     */
    public void stopMovingLeft() {
        movingLeft = false;
        Logger.log("Player stopped moving left", 1, 5);
    }

    /**
     * The player moves right.
     */
    public void movingRight() {
        movingRight = true;
        Logger.log("Player is moving right", 1, 5);
    }

    /**
     * The player stops moving right.
     */
    public void stopMovingRight() {
        movingRight = false;
        Logger.log("Player stopped moving right", 1, 5);
    }

    /**
     * Moves the player left or right, depending on what key is pressed.
     * @param wallList list of walls
     */
    public void move(ArrayList<Wall> wallList) {
        int powerupListSize = powerupList.size();
        if (powerupListSize > 0) {
            for (int i = 0; i < powerupListSize; i++) {
                if (powerupList.get(i).getName().equals("speed")
                        && powerupList.get(i).isActive()) {
                    stepSize = Settings.getPlayerPowerupStepSize();
                } else if (powerupList.get(i).getName().equals("speed")
                        && !(powerupList.get(i).isActive())) {
                    powerupList.remove(i);
                    stepSize = Settings.getPlayerStepSize();
                    powerupListSize = powerupList.size();
                    Logger.log("Speed powerup removed", 6, 4);
                } else if (powerupList.get(i).getName().equals("ice")
                        && !(powerupList.get(i).isActive())) {
                    powerupList.remove(i);
                    powerupListSize = powerupList.size();
                    Logger.log("Icerope powerup removed", 6, 4);
                }
            }
        }

        if (powerupList.size() == 0) {
            stepSize = Settings.getPlayerStepSize();
        }

        if (movingLeft) {
            if (xCoord - stepSize > Settings.getLeftMargin()) {
                if (!wallCollisionLeft(wallList)) {
                    xCoord -= stepSize;
                    colX -= stepSize;
                }
            } else {
                Logger.log("Player is at the left border", 1, 4);
            }
        }

        if (movingRight) {
            if (xCoord + stepSize + width < Settings.getLevelWidth()
                    + Settings.getLeftMargin() + 37) {
             
                if (!wallCollisionRight(wallList)) {

                    xCoord += stepSize;
                    colX += stepSize;
                }

            } else {
                Logger.log("Player is at the right border", 1, 4);
            }
        }
    }

    /**
     * Checks collisions with the right side of walls.
     * @param wallList List of walls that will be checked
     * @return true if there is a collision, false otherwise
     */
    public boolean wallCollisionRight(ArrayList<Wall> wallList) {
        for (int i = 0; i < wallList.size(); i++) {
            Wall wall = wallList.get(i);
            if (wall instanceof PlayerWall || wall instanceof DuoWall) {
                if (xCoord + stepSize <= (wall.getxCoord() + wall.getWidth())
                        && (xCoord + stepSize + width) >= wall.getxCoord() && wall.isActive()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks collisions with the left side of walls.
     * @param wallList List of walls that will be checked
     * @return true if there is a collision, false otherwise
     */
    public boolean wallCollisionLeft(ArrayList<Wall> wallList) {
        for (int i = 0; i < wallList.size(); i++) {
            Wall wall = wallList.get(i);
            if (wall instanceof PlayerWall || wall instanceof DuoWall) {
                if (xCoord - stepSize <= (wall.getxCoord() + wall.getWidth())
                        && (xCoord - stepSize + width) >= wall.getxCoord() && wall.isActive()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * The player shoots a rope from his current position The rope is added to
     * the level.
     */
    public void shootRope() {
        if (normalMode) {
            if (!NormalDriver.game.getCurrentLevel()
                    .hasRope()) {
                int ropeY = NormalDriver.game.getCurrentLevel().getHeight()
                        - height;
                int ropeX = xCoord + width / 2;
                int powerupListSize = powerupList.size();
                if (powerupListSize > 0) {
                    for (int i = 0; i < powerupListSize; i++) {
                        if (powerupList.get(i).getName().equals("ice") && powerupList.get(i).isActive()) {
                                Rope rope = new IceRope(ropeX, ropeY, normalMode);
                                NormalDriver.game.getCurrentLevel()
                                .setRope(rope);
                                return;
                        }
                        else if (powerupList.get(i).getName().equals("ice") && !(powerupList.get(i).isActive())) {
                                powerupList.remove(i);
                        }
                    }
                    
                }
                
                Rope rope = new Rope(ropeX, ropeY, normalMode);
                NormalDriver.game.getCurrentLevel().setRope(rope);
                Logger.log("Shot a rope", 1, 4);
                
            }
        }
        else {
            if (!SurvivalDriver.game.getCurrentLevel()
                    .hasRope()) {
                int ropeY = SurvivalDriver.game.getCurrentLevel().getHeight()
                        - height;
                int ropeX = xCoord + width / 2;
                int powerupListSize = powerupList.size();
                if (powerupListSize > 0) {
                    for (int i = 0; i < powerupListSize; i++) {
                        if (powerupList.get(i).getName().equals("ice") && powerupList.get(i).isActive()) {
                                Rope rope = new IceRope(ropeX, ropeY, normalMode);
                                SurvivalDriver.game.getCurrentLevel()
                                .setRope(rope);
                                return;
                        }
                        else if (powerupList.get(i).getName().equals("ice") && !(powerupList.get(i).isActive())) {
                                powerupList.remove(i);
                        }

                    }
                    
                }

                Rope rope = new Rope(ropeX, ropeY, normalMode);
                SurvivalDriver.game.getCurrentLevel().setRope(rope);
                Logger.log("Shot a rope", 1, 4);    
            }
        }
    }

    /**
     * Checks if the player has an ice rope.
     * @return true if it has, false otherwise
     */
    public boolean hasIceRope() {
        int powerupListSize = powerupList.size();
        if (powerupListSize > 0) {
            for (int i = 0; i < powerupListSize; i++) {
                if (powerupList.get(i).getName().equals("ice")
                        && powerupList.get(i).isActive()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Getter for the name of the player.
     * @return String name of player
     */
    public String getName() {
        return name;
    }
    
    /**
     * Setter for the name of the player.
     * @param newName for the player
     */
    public void setName(String newName) {
        name = newName;
    }

    /**
     * Setter for a powerup.
     * @param powerup that the player has
     */
    public void setPowerup(Powerup powerup) {
        powerupList.add(powerup);
    }

    /**
     * Getter for the moving left attribute.
     * @return true if player is moving left, false otherwise
     */
    public boolean getMovingLeft() {
        return movingLeft;
    }

    /**
     * Getter for the moving right attribute.
     * @return true if player is moving right, false otherwise
     */
    public boolean getMovingRight() {
        return movingRight;
    }

    /**
     * Getter for the x-Coordinate.
     * @return xCoord x-Coordinate
     */
    public int getX() {
        return xCoord;
    }

    /**
     * Getter for the y-Coordinate.
     * @return yCoord y-Coordinate
     */
    public int getY() {
        return yCoord;
    }

    /**
     * Getter for the collisionX attribute.
     * @return x-Coordinate of the collision.
     */
    public int getCollisionX() {
        return this.colX;
    }

    /**
     * Getter for the collisionY attribute.
     * @return y-Coordinate of the collision.
     */
    public int getCollisionY() {
        return this.colY;
    }

    /**
     * Getter for the width of the player.
     * @return width of the player
     */
    public int getWidth() {
        return width;
    }

    /**
     * Getter for the height of the player.
     * @return height of the player
     */
    public int getHeight() {
        return height;
    }

    /**
     * Getter for the powerup list.
     * @return List of powerups
     */
    public ArrayList<Powerup> getPowerupList() {
        return powerupList;
    }

    /**
     * Remove a powerup from the player.
     * @param pu powerup that will be removed
     */
    public void removePowerUp(Powerup pu) {
        powerupList.remove(pu);
    }

    /**
     * Remove all powerups of the player.
     */
    public void removeAllPowerUps() {
        while (powerupList.size() != 0) {
            powerupList.get(0).deActivate();
            powerupList.remove(0);
        }
    }

    /**
     * Check if the player has a powerup.
     * @return true if the player has 1 powerup or more, false otherwise
     */
    public boolean hasPowerup() {
        return this.powerupList.size() != 0;
    }

}
