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
    private int y = Settings.getLevelHeight() - Settings.getPlayerHeight();
    private int height = Settings.getPlayerHeight();
    private int width = Settings.getPlayerWidth();
    private int stepSize = Settings.getPlayerStepSize();
    private boolean movingLeft = false;
    private boolean movingRight = false;
    private Image image;
    private Powerup powerup = null;

    Player(String name, int x, int y) {
        this.name = name;
        this.x = x;

        URL location = StartScreen.class.getProtectionDomain().getCodeSource()
                .getLocation();
        String imageLocation = location.getFile();
        ImageIcon ii = new ImageIcon(imageLocation + "Images/dragon.png");
        image = ii.getImage();
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
            if (x - stepSize > 0) {
                x -= stepSize;
            }
        }

        if (movingRight) {
            if (x + stepSize + width < Driver.game.getLevelList()
                    .get(Driver.game.getCurrentLevel()).getWidth()) {
                x += stepSize;
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
        if (!Driver.game.getLevelList().get(Driver.game.getCurrentLevel())
                .hasRope()) {
            int ropeY = Driver.game.getLevelList()
                    .get(Driver.game.getCurrentLevel()).getHeight()
                    - height + 2;
            int ropeX = x + width / 2;
            Rope rope = new Rope(ropeX, ropeY);

            Driver.game.getLevelList().get(Driver.game.getCurrentLevel())
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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Image getImage() {
        return image;
    }

    public Powerup getPowerup() {
        return this.powerup;
    }

}