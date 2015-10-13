package game.screens;

import game.Game;
import game.Player;
import game.Score;

import java.awt.Color;
import java.awt.Graphics2D;
import java.net.URL;

import javax.swing.JFrame;

public class PaintGame {
    public static int totalFrames = 1;
    public static Game game;
    public static Score score;
    private int animationRightCounter = 1;
    private int fireRightCounter = 1;
    private int animationLeftCounter = 1;
    private int fireLeftCounter = 1;
    private int slowDownCounter = 100;
    private int ropeDurationCounter = 0;
    private int oldX;
    private static boolean dragonIsRight = true;
    private static boolean canDrawGame = true;
    private static boolean addOnce = false;
    private boolean dragonIsMoving = false;
    private boolean shootRope = false;
    private static boolean iceRope = false;
    private static URL location = StartScreen.class.getProtectionDomain()
            .getCodeSource().getLocation();
    private static String imageLocation = location.getFile();
    private static Color dragonRed = new Color(135, 15, 15);
    private Graphics2D g2d;
    private int topMargin;
    private int centerConstant;
    private static Color bg = new Color(191, 191, 191);
    private static Player player;
    private static JFrame frame;
    private static GameScreen gameScreen;
    
    public PaintGame()
    {
        
    }
    
}
