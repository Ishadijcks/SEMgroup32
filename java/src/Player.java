import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player {
    private String name;
    private int x;
    private int y;
    private int height = 40;
    private int width = 20;
    private int stepSize = 2;
    private boolean movingLeft = false;
    private boolean movingRight = false;
    private Image image;

    Player(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
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

}
