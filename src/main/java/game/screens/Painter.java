package game.screens;

import game.Game;
import game.NormalLevel;
import game.Score;
import game.bubble.Bubble;
import game.powerups.Powerup;
import game.wall.Wall;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.net.URL;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import settings.screenSettings;

/**
 * Class that will paint everything in a game.
 * @author Boning
 *
 */
public class Painter {
    public static int totalFrames = 1;
    public static Game game;
    public static Score score;
    public int ropeDurationCounter = 0;
    public static boolean dragonIsRight = true;
    private static boolean canDrawGame = true;
    public static boolean addOnce = false;
    public boolean shootRope = false;
    private static boolean iceRope = false;
    private static URL location = StartScreen.class.getProtectionDomain()
            .getCodeSource().getLocation();
    private static String imageLocation = location.getFile();
    private static Color dragonRed = new Color(135, 15, 15);
    private Graphics2D g2d;
    private int topMargin;
    private int centerConstant;
    private static Color bg = new Color(191, 191, 191);
    private static JPanel panel;
    private static DrawPlayer playerDrawer; 

    /**
     * Constructor that will make a painter object.
     * @param panel The panel where it will paint on
     * @param gameInput The game that is currently being displayed
     * @param scoreInput The current score of the player
     */
    public Painter(JPanel panel, Game gameInput, Score scoreInput) {
        game = gameInput;
        score = scoreInput;
        this.panel = panel;
        
        centerConstant = screenSettings.getLeftMargin();
        topMargin = screenSettings.getTopMargin();
        
        imageLocation = imageLocation.replace("%20", " ");
        imageLocation = imageLocation.replace("target/classes/", "/");
        playerDrawer = new DrawPlayer(game, this.panel, this);
    }
    
    /**
     * Paint everything that has to be painted.
     * @param g2d Graphics object that will help us paint
     */
    public void paint(Graphics2D g2d) {
            this.g2d = g2d;
           
            drawLevel(); // Draw the board for each level
            drawBubbles(); // Draw the bubbles of the level with a black border
            drawWalls(); // Draw the walls of the level
            drawRopes(); // Draw the rope of the player
            drawPlayer(); // Draw the player
            drawPowerups(); // Draw the powerups
            drawLives(); // Show the lives of the player
            drawScore(); // Show the score of the player
            drawLevelNumber(); // Show the number of the current level
    }
    
    /**
     * Draw the board for all levels.
     */
    public void drawLevel() {
        iceRope = game.getPlayerList().get(0).hasIceRope();
        g2d.drawRect(centerConstant, 50, game.getCurrentLevel().getWidth(),
                game.getCurrentLevel().getHeight());
        if (canDrawGame) {
            g2d.setColor(bg);
            g2d.fillRect(centerConstant + 1, 51, game.getCurrentLevel().getWidth() - 1,
                    game.getCurrentLevel().getHeight() - 1);
            g2d.setColor(Color.BLACK);
        }
    }
    
    /**
     * Draw the bubbles.
     */
    public void drawBubbles() {
        for (int i = 0; i < game.getCurrentLevel().getBubbleList().size(); i++) {
            Bubble bubble = game.getCurrentLevel().getBubbleList().get(i);
            g2d.setColor(bubble.getColor());
            g2d.fillOval(bubble.getX(), bubble.getY(),
                    bubble.getDiameter(), bubble.getDiameter());
            g2d.setColor(Color.black);
            g2d.drawOval(bubble.getX() - 1, bubble.getY() - 1,
                    bubble.getDiameter() + 2, bubble.getDiameter() + 2);
        }
    }
    
    /**
     * Draw the walls.
     */
    public void drawWalls() {
        for (int i = 0; i < game.getCurrentLevel().getWallList().size(); i++) {
            Wall wall = game.getCurrentLevel().getWallList().get(i);
            if (wall.isActive()) {
                g2d.setColor(wall.getColor());
                g2d.fillRect(wall.getxCoord(),
                        wall.getyCoord() + screenSettings.getTopMargin(),
                        wall.getWidth(), wall.getHeight());
                g2d.setColor(Color.BLACK);
            }
        }
    }
    
    /**
     * Draw all the ropes.
     */
    public void drawRopes() {
        if (game.getCurrentLevel().hasRope() && !(iceRope)) {
            drawNormalRope();
        }
        if (game.getCurrentLevel().hasRope() && iceRope) {
            drawIceRope();
        }
    }
    
    /**
     * Draw a normal rope.
     */
    public void drawNormalRope() {
        shootRope = true;
        playerDrawer.shootRope = true;
        
        ropeDurationCounter--;

        Color[] colors = getNormalRopeColors();
        Stroke[] strokes = getBasicStrokes();

        g2d.setColor(colors[3]);
        g2d.setStroke(strokes[3]);

        if (dragonIsRight) {
            drawNormalRopeDragonRight();

        } else {
            drawNormalRopeDragonLeft();
        }

        resetg2d();
    }
    
    /**
     * Gives 4 different colors for making the rope look like fire.
     * @return array of 4 different colors
     */
    public Color[] getNormalRopeColors() {
        Random rand = new Random();
        int rInt127to153 = rand.nextInt((153 - 127) + 1) + 127;
        int rInt51to102 = rand.nextInt((102 - 51) + 1) + 51;
        int rInt69to240 = rand.nextInt((240 - 69) + 1) + 69;
        int rInt255to8 = rand.nextInt((255 - 8) + 1) + 8;
        int rInt6to11 = rand.nextInt((11 - 6) + 1) + 6;

        Color fire1 = new Color(255, rInt127to153, 0);
        Color fire2 = new Color(255, rInt51to102, 0);
        Color fire3 = new Color(255, rInt69to240, 0);
        Color fire4 = new Color(250, rInt255to8, rInt6to11);
        
        Color[] res = { fire4, fire3, fire2, fire1 };
        return res;
    }
    
    /**
     * Draw a normal rope while the dragon is facing to the right side.
     */
    public void drawNormalRopeDragonRight() {
        Random rand = new Random();
        Color[] colors = getNormalRopeColors();
        Stroke[] strokes = getBasicStrokes();
        
        if (!(addOnce)) {
            game.getCurrentLevel().getRope().addX(-6);
            addOnce = true;
        }
        for (int i = 0; i < 4; i++) {
            g2d.setColor(colors[i]);
            g2d.setStroke(strokes[i]);

            int random = rand.nextInt((4 - 0) + 1) + 0;
            if ((i == 0) && random == 2) {
                g2d.drawLine(game.getCurrentLevel().getRope().getX(), game.getCurrentLevel()
                        .getRope().getY(), game.getCurrentLevel().getRope()
                        .getX(), game.getCurrentLevel().getHeight() + 43);
            } else if (i == 1 || i == 2 || i == 3) {
                g2d.drawLine(game.getCurrentLevel().getRope().getX(), game.getCurrentLevel()
                        .getRope().getY(), game.getCurrentLevel().getRope()
                        .getX(), game.getCurrentLevel().getHeight() + 43);
            }

        }
    }
    
    /**
     * Draw a normal rope while the dragon is facing to the left side.
     */
    public void drawNormalRopeDragonLeft() {
        Random rand = new Random();
        Color[] colors = getNormalRopeColors();
        Stroke[] strokes = getBasicStrokes();
        
        if (!(addOnce)) {
            game.getCurrentLevel().getRope().addX(-32);
            addOnce = true;
        }
        for (int i = 0; i < 4; i++) {
            g2d.setColor(colors[i]);
            g2d.setStroke(strokes[i]);

            int random = rand.nextInt((4 - 0) + 1) + 0;
            if ((i == 0) && random == 2) {
                g2d.drawLine(game.getCurrentLevel().getRope().getX(), game.getCurrentLevel()
                        .getRope().getY(), game.getCurrentLevel().getRope()
                        .getX(), game.getCurrentLevel().getHeight() + 43);
            } else if (i == 1 || i == 2 || i == 3) {
                g2d.drawLine(game.getCurrentLevel().getRope().getX(), game.getCurrentLevel()
                        .getRope().getY(), game.getCurrentLevel().getRope()
                        .getX(), game.getCurrentLevel().getHeight() + 43);
            }
        }
    }
    
    /**
     * Draw an ice rope.
     */
    public void drawIceRope() {
        shootRope = true;
        playerDrawer.shootRope = true;
        ropeDurationCounter--;

        Random rand = new Random();
        Color[] colors = getIceRopeColors();
        Stroke[] strokes = getBasicStrokes();

        g2d.setColor(colors[3]);
        g2d.setStroke(strokes[3]);

        if (dragonIsRight) {
            drawIceRopeDragonRight();

        } else {
            drawIceRopeDragonLeft();
        }
        resetg2d();
    }
    
    /**
     * Gives 4 different colors for making the rope look like ice.
     * @return array of 4 different colors
     */
    public Color[] getIceRopeColors() {
        Random rand = new Random();
        int rInt219to255 = rand.nextInt((255 - 219) + 1) + 219;
        int rInt120to102 = rand.nextInt((120 - 102) + 1) + 102;
        int rInt70to133 = rand.nextInt((133 - 70) + 1) + 70;
        int rInt6to33 = rand.nextInt((33 - 6) + 1) + 6;

        Color fire1 = new Color(0, rInt219to255, 255);
        Color fire2 = new Color(36, rInt120to102, 165);
        Color fire3 = new Color(29, rInt70to133, 209);
        Color fire4 = new Color(14, rInt6to33, 120);
        
        Color[] res = { fire4, fire3, fire2, fire1 };
        return res;
    }
    
    /**
     * Draw an ice rope while the dragon is facing to the right side.
     */
    public void drawIceRopeDragonRight() {
        Random rand = new Random();
        Color[] colors = getIceRopeColors();
        Stroke[] strokes = getBasicStrokes();
        
        if (!(addOnce)) {
            game.getCurrentLevel().getRope().addX(-6);
            addOnce = true;
        }
        for (int i = 0; i < 4; i++) {
            g2d.setColor(colors[i]);
            g2d.setStroke(strokes[i]);

            int random = rand.nextInt((4 - 0) + 1) + 0;
            if ((i == 0) && random == 2) {
                g2d.drawLine(game.getCurrentLevel().getRope().getX(), game.getCurrentLevel()
                        .getRope().getY(), game.getCurrentLevel().getRope()
                        .getX(), game.getCurrentLevel().getHeight() + 45);
            } else if (i == 1 || i == 2 || i == 3) {
                g2d.drawLine(game.getCurrentLevel().getRope().getX(), game.getCurrentLevel()
                        .getRope().getY(), game.getCurrentLevel().getRope()
                        .getX(), game.getCurrentLevel().getHeight() + 45);
            }

        }
    }
    
    /**
     * Draw an ice rope while the dragon is facing to the left side.
     */
    public void drawIceRopeDragonLeft() {
        Random rand = new Random();
        Color[] colors = getIceRopeColors();
        Stroke[] strokes = getBasicStrokes();
        
        if (!(addOnce)) {
            game.getCurrentLevel().getRope().addX(-32);
            addOnce = true;
        }
        for (int i = 0; i < 4; i++) {
            g2d.setColor(colors[i]);
            g2d.setStroke(strokes[i]);

            int random = rand.nextInt((4 - 0) + 1) + 0;
            if ((i == 0) && random == 2) {
                g2d.drawLine(game.getCurrentLevel().getRope().getX(), game.getCurrentLevel()
                        .getRope().getY(), game.getCurrentLevel().getRope()
                        .getX(), game.getCurrentLevel().getHeight() + 43);
            } else if (i == 1 || i == 2 || i == 3) {
                g2d.drawLine(game.getCurrentLevel().getRope().getX(), game.getCurrentLevel()
                        .getRope().getY(), game.getCurrentLevel().getRope()
                        .getX(), game.getCurrentLevel().getHeight() + 43);
            }
        }
    }
    
    /**
     * Gives 4 different strokes that differ in thickness.
     * @return array of 4 different strokes
     */
    public Stroke[] getBasicStrokes() {
        Stroke stroke1 = new BasicStroke(1f);
        Stroke stroke2 = new BasicStroke(3f);
        Stroke stroke3 = new BasicStroke(5f);
        Stroke stroke4 = new BasicStroke(7f);
        
        Stroke[] res = { stroke4, stroke3, stroke2, stroke1 };
        return res;
    }
    
    /**
     * Draw the player.
     */
    public void drawPlayer() {
           playerDrawer.drawPlayer(this.g2d);
    }
    
    /**
     * Draw all powerups.
     */
    public void drawPowerups() {
        for (int i = 0; i < game.getCurrentLevel().getPowerupList().size(); i++) {
            Powerup powerup = game.getCurrentLevel().getPowerupList().get(i);

            ImageIcon powerupImage = powerup.getImageIcon();

            if (powerupImage != null) {
                g2d.drawImage(powerupImage.getImage(), powerup.getX(),
                        powerup.getY() + 13, panel);
            }

        }
        Stroke normalStroke = new BasicStroke(1f);
        g2d.setStroke(normalStroke);
    }
    
    /**
     * Draw lives of player.
     */
    public void drawLives() {
        g2d.setFont(new Font("Calibri", Font.BOLD, 40));
        g2d.drawString("Lives: ", centerConstant, game.getCurrentLevel().getHeight() + 45
                + topMargin);
        ImageIcon life = new ImageIcon(imageLocation
                + "src/main/Images/life.png");
        for (int i = 0; i < game.getLives(); i++) {
            g2d.drawImage(life.getImage(), centerConstant + 125 + 25 * i,
                    game.getCurrentLevel().getHeight() + 16 + topMargin, panel);
        }
    }
    
    /**
     * Draw score of player.
     */
    public void drawScore() {
        g2d.drawString("Score: ", centerConstant, game.getCurrentLevel().getHeight() + 91
                + topMargin);
        g2d.setColor(dragonRed);
        g2d.drawString("" + score.getScore(), centerConstant + 135,
                game.getCurrentLevel().getHeight() + 91 + topMargin);
        g2d.setColor(Color.BLACK);
    }
    
    /**
     * Draw the levelnumber.
     */
    public void drawLevelNumber() {
        if (game.getCurrentLevel() instanceof NormalLevel) {
            NormalLevel curNormalLevel = (NormalLevel) game.getCurrentLevel();
            g2d.drawString("Level:", centerConstant, 45);
            g2d.setColor(dragonRed);
            g2d.drawString(curNormalLevel.getLevelNumber() + " ",
                    centerConstant + 110, 45);
            g2d.setColor(Color.BLACK);

            g2d.setColor(dragonRed);
            g2d.drawString(" " + (game.getCurrentLevelInt() + 1), 1350,
                    game.getCurrentLevel().getHeight() + 51);
            g2d.setColor(Color.BLACK);
        }
    }
    
    /**
     * Set g2d back to normal settings
     */
    public void resetg2d() {
        g2d.setColor(Color.BLACK);
        Stroke normalStroke = new BasicStroke(1f);
        g2d.setStroke(normalStroke);
    }
    
}
