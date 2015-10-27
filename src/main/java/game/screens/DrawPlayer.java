package game.screens;

import game.Driver;
import game.Game;
import game.Player;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Draws the player in-game.
 * 
 * @author Boning
 *
 */
public class DrawPlayer {

    public static Game game;
    private int animationRightCounter = 1;
    private int fireRightCounter = 1;
    private int animationLeftCounter = 1;
    private int fireLeftCounter = 1;
    private int slowDownCounter = 100;
    private int ropeDurationCounter = 0;
    private int oldX;
    private int newX;
    private int topMargin;
    private Graphics2D g2d;
    private static Color dragonRed = new Color(135, 15, 15);
    private static boolean dragonIsRight = true;
    private boolean dragonIsMoving = false;
    public boolean shootRope = false;
    private static URL location = StartScreen.class.getProtectionDomain()
            .getCodeSource().getLocation();
    private static String imageLocation = location.getFile();
    private Player player;
    private static JPanel panel;
    private static Painter painter;

    /**
     * Constructor for the draw player game.
     * 
     * @param game
     *            in where the player will be drawn
     * @param panel
     *            where everything will be drawn
     * @param painter
     *            that will use this class
     */
    public DrawPlayer(Game game, JPanel panel, Painter painter){
        DrawPlayer.game = game;
        DrawPlayer.panel = panel;
        DrawPlayer.painter = painter;
        
        topMargin = Driver.game.getCurrentLevel().getTopMargin();
        imageLocation = imageLocation.replace("%20", " ");
        imageLocation = imageLocation.replace("target/classes/", "/");
    }

    /**
     * Draw the player.
     * @param g2d The 2DGraphics to draw on
     */
    public void drawPlayer(Graphics2D g2d) {
        this.g2d = g2d;
        player = game.getPlayerList().get(0);
        drawPlayerName();
        newX = player.getX();

        if (ropeDurationCounter < 40 || !(shootRope)) {
            if (oldX != newX) {
                dragonIsMoving = true;
            } else {
                dragonIsMoving = false;
            }

            drawDragonStandingStill();
            drawDragonFlying(newX);
        }
        if (oldX == newX) {
            animationRightCounter = 1;
            animationLeftCounter = 1;
        }

        drawDragonSpittingFire();

        drawPlayerUpdateVar();
    }

    /**
     * Update all variables that the draw player function requires.
     */
    public void drawPlayerUpdateVar() {
        oldX = game.getPlayerList().get(0).getX();

        if (animationLeftCounter == 10) {
            animationLeftCounter = 1;
        }
        if (animationRightCounter == 10) {
            animationRightCounter = 1;
        }
        if (!game.getCurrentLevel().hasRope()) {
            shootRope = false;
            fireRightCounter = 1;
            fireLeftCounter = 1;
            ropeDurationCounter = 100;

            painter.shootRope = false;
            Painter.addOnce = false;
            painter.ropeDurationCounter = 100;
        }
        slowDownCounter++;
    }

    /**
     * Draws the name of the player.
     */
    public void drawPlayerName() {
        player = game.getPlayerList().get(0);

        g2d.setFont(new Font("Calibri", Font.ITALIC, 25));
        g2d.setColor(dragonRed);

        if (player.getName() != null) {
            g2d.drawString(player.getName(), player.getX() - 25, player.getY()
                    - 70 + topMargin);
        } else {
            g2d.drawString("", player.getX() - 25, player.getY() - 70
                    + topMargin);
        }

        g2d.setColor(Color.BLACK);
    }

    /**
     * Draw the dragon standing still and doing nothing.
     */
    public void drawDragonStandingStill() {
        if (dragonIsRight && !(dragonIsMoving)) {
            ImageIcon dragonRightNormal = new ImageIcon(imageLocation
                    + "src/main/Images/dragon/dragonR" + 10 + ".png");
            g2d.drawImage(dragonRightNormal.getImage(), player.getX() - 50,
                    player.getY(), panel);
        } else if (!(dragonIsMoving)) {
            ImageIcon dragonLeftNormal = new ImageIcon(imageLocation
                    + "src/main/Images/dragon/dragonL" + 10 + ".png");
            g2d.drawImage(dragonLeftNormal.getImage(), player.getX() - 50,
                    player.getY(), panel);
        }
    }

    /**
     * Draw the dragon flying either to the left or to the right.
     * @param newX - The xCoord the player is moving to
     */
    public void drawDragonFlying(int newX) {
        drawDragonFlyRight(newX);
        drawDragonFlyLeft(newX);
    }

    /**
     * Draw the dragon flying to the right.
     * @param newX - The xCoord the player is moving to
     */
    public void drawDragonFlyRight(int newX) {
        ImageIcon dragonRight = new ImageIcon(imageLocation
                + "src/main/Images/dragon/dragonR" + animationRightCounter
                + ".png");

        if (oldX < newX) {
            g2d.drawImage(dragonRight.getImage(), player.getX() - 50,
                    player.getY(), panel);
            dragonIsRight = true;
            Painter.dragonIsRight = true;
            if (slowDownCounter % 24 == 0) {
                animationRightCounter++;
            }
            if (animationRightCounter == 7) {
                animationRightCounter = 4;
            }
        }
    }

    /**
     * Draw the dragon flying to the left.
     * @param newX - The xCoord the player is moving to
     */
    public void drawDragonFlyLeft(int newX) {
        ImageIcon dragonLeft = new ImageIcon(imageLocation
                + "src/main/Images/dragon/dragonL" + animationLeftCounter
                + ".png");

        if (oldX > newX) {
            g2d.drawImage(dragonLeft.getImage(), player.getX() - 50,
                    player.getY(), panel);
            dragonIsRight = false;
            Painter.dragonIsRight = false;
            if (slowDownCounter % 24 == 0) {
                animationLeftCounter++;
            }
            if (animationLeftCounter == 7) {
                animationLeftCounter = 4;
            }
        }
    }

    /**
     * Draw the dragon spitting fire.
     */
    public void drawDragonSpittingFire() {

        if (shootRope && ropeDurationCounter > 40) {
            if (dragonIsRight) {
                ImageIcon dragonRightFire = new ImageIcon(imageLocation
                        + "src/main/Images/dragon/fireR" + fireRightCounter
                        + ".png");
                g2d.drawImage(dragonRightFire.getImage(), game.getPlayerList()
                        .get(0).getX() - 50, player.getY(), panel);
                if (fireRightCounter < 3 && slowDownCounter % 8 == 0) {
                    fireRightCounter++;
                }
            } else {
                ImageIcon dragonLeftFire = new ImageIcon(imageLocation
                        + "src/main/Images/dragon/fireL" + fireLeftCounter
                        + ".png");
                g2d.drawImage(dragonLeftFire.getImage(), game.getPlayerList()
                        .get(0).getX() - 50, player.getY(), panel);
                if (fireLeftCounter < 3 && slowDownCounter % 8 == 0) {
                    fireLeftCounter++;
                }
            }
        }
    }

}
