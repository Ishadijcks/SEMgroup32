package game;

public class Rope {
    private int x;
    private int y;

    public Rope(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * The rope moves up and gets destroyed when it hits the roof
     */
    public void move() {
        if (y <= Settings.getTopMargin() - 2) {
           Driver.game.getCurrentLevel()
                    .setRope(null);
        } else {
            y -= Settings.getRopeSpeed();
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