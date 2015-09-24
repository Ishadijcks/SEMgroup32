package game;

import game.log.Logger;
import game.screens.StartScreen;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public abstract class Driver {
    public static int totalFrames = 1;
    public static Score score;
    protected static Level curLevel;
    protected static boolean canDrawGame = true;
    protected static boolean iceRope = false;
    protected static Player player;

    public abstract void startScreen();

    public abstract void startGame(String name);

    public abstract void setupGame();
    
    public abstract void initGame();
    
    

}
