package game;

import game.log.Logger;

public class Rope {
    protected int x;
    protected int y;
    
    private boolean normalMode;

    public Rope(int x, int y, boolean isNormalMode) {
        this.x = x;
        this.y = y;
        normalMode = isNormalMode;
    }

    /**
     * The rope moves up and gets destroyed when it hits the roof
     */
    public void move() {
            if(normalMode)  
            {
                if (y <= Settings.getTopMargin() - 2) {
                    NormalDriver.game.getCurrentLevel()
                             .setRope(null);
                    Logger.log("Rope hit the roof", 5, 4);
                 } else {
                     Logger.log("Rope moved from "+x+","+y+ " to "+ x + ","+(y-Settings.getRopeSpeed()), 5, 5);
                     y -= Settings.getRopeSpeed();
                 } 
            }
            else
            {
                if (y <= Settings.getTopMargin() - 2) {
                    SurvivalDriver.game.getCurrentLevel()
                             .setRope(null);
                    Logger.log("Rope hit the roof", 5, 4);
                 } else {
                     Logger.log("Rope moved from "+x+","+y+ " to "+ x + ","+(y-Settings.getRopeSpeed()), 5, 5);
                     y -= Settings.getRopeSpeed();
                 } 
            }
            
    }
    
    public void addX(int extra) {
        this.x += extra;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
