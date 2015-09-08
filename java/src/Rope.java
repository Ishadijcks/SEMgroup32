public class Rope {
    private int x;
    private int y;

    Rope(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * The rope moves up and gets destroyed when it hits the roof
     */
    public void move() {
        if (y <= 0) {
            Driver.game.getLevelList().get(Driver.game.getCurrentLevel())
                    .setRope(null);
        } else {
            y -= Settings.getRopeSpeed();
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
