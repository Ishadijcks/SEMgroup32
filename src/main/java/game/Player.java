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
    private ArrayList<Powerup> powerupList = new ArrayList<Powerup>();
    private static boolean iceRope = false;

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
        int powerupListSize = powerupList.size();
        if (powerupListSize > 0) {
               for(int i = 0; i < powerupListSize; i++)
               {
                   System.out.println("Old size: " + powerupListSize);
                   System.out.println("New size: " + powerupList.size());
                       if (powerupList.get(i).getName().equals("speed") && powerupList.get(i).isActive()) {
                           stepSize = Settings.getPlayerPowerupStepSize();;
                       }
                       else if(powerupList.get(i).getName().equals("speed") && !(powerupList.get(i).isActive()))
                       {
                           powerupList.remove(i);
                           stepSize = Settings.getPlayerStepSize();
                           powerupListSize = powerupList.size();
                       }
                       else if(powerupList.get(i).getName().equals("ice") && !(powerupList.get(i).isActive()))
                       {
                           powerupList.remove(i);
                           iceRope = false;
                           powerupListSize = powerupList.size();
                       }
               }
        }

        if (movingLeft) {
            if (x - stepSize > Settings.getLeftMargin()) {
                x -= stepSize;
                colX -= stepSize;
            }
        }

        if (movingRight) {
            if (x + stepSize + width < Settings.getLevelWidth() + Settings.getLeftMargin() + 37) {
                x += stepSize;
                colX += stepSize;
            }
        }
        if(powerupList.size() != 0)
        {
            System.out.println(powerupList.get(0).getFramesLeft());
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
            int powerupListSize = powerupList.size();
            if(powerupListSize > 0)
            {
                for(int i = 0; i < powerupListSize; i++)
                {
                    if(powerupList.get(i).getName().equals("ice") && powerupList.get(i).isActive())
                    {
                            iceRope = true;
                            Rope rope = new Rope(ropeX, ropeY, iceRope);
                            Driver.game.getCurrentLevel()
                            .setRope(rope);
                            return;
                    }
                    else if(powerupList.get(i).getName().equals("ice") && !(powerupList.get(i).isActive()))
                    {
                            iceRope = false;
                            powerupList.remove(i);
                    }
                }
                
            }
            
            iceRope = false;
            
            Rope rope = new Rope(ropeX, ropeY, iceRope);
            Driver.game.getCurrentLevel().setRope(rope);
            
        }
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setPowerup(Powerup powerup) {
        powerupList.add(powerup);
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

    public ArrayList<Powerup> getPowerupList() {
        return powerupList;
    }
    
    public boolean getIceRope() {
        return this.iceRope;
    }
    
    public void removePowerUp(Powerup pu)
    {
        powerupList.remove(pu);
    }
    
    public void removeAllPowerUps()
    {
        int puListSize = powerupList.size();
        for(int i = 0; i < puListSize ; i++)
        {
            powerupList.get(i).deActive();
            powerupList.remove(i);
            puListSize = powerupList.size();
        }
        iceRope = false;
    }
    
    public boolean hasPowerup(){
    	return this.powerupList.size() != 0;
    }

}
