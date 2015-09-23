package game;

import game.log.Logger;

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
    private ArrayList<Powerup> powerupList = new ArrayList<Powerup>();

    public Player(String name, int x) {
        this.name = name;
        this.x = x;
        this.colX = x - 50;
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
        int powerupListSize = powerupList.size();
        if (powerupListSize > 0) {
            for (int i = 0; i < powerupListSize; i++) {
                if (powerupList.get(i).getName().equals("speed")
                        && powerupList.get(i).isActive()) {
                    stepSize = Settings.getPlayerPowerupStepSize();
                    ;
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
                System.out.println(wallCollisionRight(wallList));
                if (!wallCollisionRight(wallList)) {

                    x += stepSize;
                    colX += stepSize;
                }

            } else {
                Logger.log("Player is at the right border", 1, 4);
            }
        }

        if (powerupList.size() != 0) {
            // System.out.println(powerupList.get(0).getName() + " " +
            // powerupList.get(0).getFramesLeft());
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
        if (!NormalDriver.game.getCurrentLevel().hasRope()) {
            int ropeY = NormalDriver.game.getCurrentLevel().getHeight()
                    - height;
            int ropeX = x + width / 2;
            int powerupListSize = powerupList.size();
            if (powerupListSize > 0) {
                for (int i = 0; i < powerupListSize; i++) {
                    if (powerupList.get(i).getName().equals("ice")
                            && powerupList.get(i).isActive()) {
                        Rope rope = new IceRope(ropeX, ropeY);
                        NormalDriver.game.getCurrentLevel().setRope(rope);
                        return;
                    } else if (powerupList.get(i).getName().equals("ice")
                            && !(powerupList.get(i).isActive())) {
                        powerupList.remove(i);
                    }
                }

            }

            Rope rope = new Rope(ropeX, ropeY);
            NormalDriver.game.getCurrentLevel().setRope(rope);
            Logger.log("Shot a rope", 1, 4);

        }
    }

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

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setPowerup(Powerup powerup) {
        powerupList.add(powerup);
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

    public ArrayList<Powerup> getPowerupList() {
        return powerupList;
    }

    public void removePowerUp(Powerup pu) {
        powerupList.remove(pu);
    }

    public void removeAllPowerUps() {
        while (powerupList.size() != 0) {
            powerupList.get(0).deActivate();
            powerupList.remove(0);
        }
    }

    public boolean hasPowerup() {
        return this.powerupList.size() != 0;
    }

}
