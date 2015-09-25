package game.screens;

import game.Game;
import game.NormalDriver;
import game.NormalGame;
import game.MathFunctions;
import game.GameCreator;
import game.Level;
import game.MyKeyListener;
import game.Player;
import game.Powerup;
import game.Score;
import game.Settings;
import game.wall.Wall;
import game.bubble.Bubble;
import game.log.LogFilters;
import game.log.LogSettings;
import game.log.Logger;
import game.wall.Wall;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GameScreen extends JPanel {
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
    private boolean dragonJustStopped = false;
    private boolean dragonIsMoving = false;
    private boolean shootRope = false;
    private static boolean iceRope = false;
    private static URL location = StartScreen.class.getProtectionDomain()
            .getCodeSource().getLocation();
    private static String imageLocation = location.getFile();
    private static Color dragonRed = new Color(135, 15, 15);
    private static Level curLevel;
    private Graphics2D g2d;
    private int topMargin;
    private int centerConstant;
    private static Color bg = new Color(191, 191, 191);
    private static Player player;
    private static JFrame frame;
    private static GameScreen gameScreen;

    public GameScreen() throws UnsupportedAudioFileException, IOException,
            LineUnavailableException {
        frame = new JFrame("Game Screen");
        imageLocation = imageLocation.replace("%20", " ");
        imageLocation = imageLocation.replace("target/classes/", "/");
    }

    /**
     * dispose the screen.
     */
    public void dispose() {
        frame.dispose();
    }

    public void startGame() {
        frame.setVisible(true);
        frame.requestFocus();
    }

    public void levelWon() {

        final JLabel label = new JLabel("test");
        label.setText("Congratulations! Level won!");
        frame.add(label);
        final JButton nextLevel = new JButton("Next Level");
        nextLevel.setVerticalTextPosition(AbstractButton.BOTTOM);
        nextLevel.setHorizontalTextPosition(AbstractButton.CENTER);
        nextLevel.setMnemonic(KeyEvent.VK_M);
        nextLevel.setFocusable(false);
        nextLevel.setBounds(700, 950, 250, 50);
        nextLevel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                canDrawGame = true;
                game.gameStart();
                remove(nextLevel);
                remove(label);
            }
        });
        frame.add(nextLevel);
        frame.validate();
    }

    /**
     * refresh the screen.
     */
    public void reload() {
        gameScreen.repaint();
        repaint();
        frame.repaint();
    }

    public static void setupScreen(Game gameInput, Score scoreInput) {
        game = gameInput;
        score = scoreInput;
        try {
            gameScreen = new GameScreen();
        } catch (UnsupportedAudioFileException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (LineUnavailableException e1) {
            e1.printStackTrace();
        }
        frame.addKeyListener(new MyKeyListener(gameInput));
        Logger.log("Added key listener", 9, 4);
        frame.add(gameScreen);
        frame.setSize(Settings.getScreenWidth(), Settings.getScreenHeight());
        Logger.log("Screen size set to " + Settings.getScreenWidth() + " by "
                + Settings.getScreenWidth(), 9, 4);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(false);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            LogScreen logScreen = new LogScreen();
            LogSettings.setLogScreen(true);
            LogSettings.setLogscreen(logScreen);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to draw the game
     */
    @Override
    public void paint(Graphics graph) {

        try {
            iceRope = game.getPlayerList().get(0).hasIceRope();

            // Calculate the margin left to center the board
            centerConstant = Settings.getLeftMargin();
            topMargin = Settings.getTopMargin();
            super.paint(graph);
            g2d = (Graphics2D) graph;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            // TODO Split up in methods

            // Draw the game board
            Level curLevel = game.getCurrentLevel();
            g2d.drawRect(centerConstant, 50, curLevel.getWidth(),
                    curLevel.getHeight());
            if (canDrawGame) {
                g2d.setColor(bg);
                g2d.fillRect(centerConstant + 1, 51, curLevel.getWidth() - 1,
                        curLevel.getHeight() - 1);
                g2d.setColor(Color.BLACK);
            }

            // Draw all the bubbles with a black border

            for (int i = 0; i < curLevel.getBubbleList().size(); i++) {
                Bubble bubble = curLevel.getBubbleList().get(i);
                g2d.setColor(bubble.getColor());
                g2d.fillOval(bubble.getX(), bubble.getY(),
                        bubble.getDiameter(), bubble.getDiameter());
                g2d.setColor(Color.black);

                g2d.drawOval(bubble.getX() - 1, bubble.getY() - 1,
                        bubble.getDiameter() + 2, bubble.getDiameter() + 2);
            }

            // Draw the walls
            for (int i = 0; i < curLevel.getWallList().size(); i++) {
                Wall wall = curLevel.getWallList().get(i);
                if (wall.isActive()) {
                    g2d.setColor(wall.getColor());
                    g2d.fillRect(wall.getX(),
                            wall.getY() + Settings.getTopMargin(),
                            wall.getWidth(), wall.getHeight());
                    g2d.setColor(Color.BLACK);
                }
            }

            // Draw the ropes
            if (curLevel.hasRope() && !(iceRope)) {
                shootRope = true;
                ropeDurationCounter--;

                int rInt127to153 = MathFunctions.randomInt(127, 153);
                int rInt51to102 = MathFunctions.randomInt(51, 102);
                int rInt69to240 = MathFunctions.randomInt(69, 240);
                int rInt255to8 = MathFunctions.randomInt(69, 240);
                int rInt6to11 = MathFunctions.randomInt(6, 11);

                Color fire1 = new Color(255, rInt127to153, 0);
                Color fire2 = new Color(255, rInt51to102, 0);
                Color fire3 = new Color(255, rInt69to240, 0);
                Color fire4 = new Color(250, rInt255to8, rInt6to11);

                Stroke stroke1 = new BasicStroke(1f);
                Stroke stroke2 = new BasicStroke(3f);
                Stroke stroke3 = new BasicStroke(5f);
                Stroke stroke4 = new BasicStroke(7f);

                Color[] colors = { fire4, fire3, fire2, fire1 };
                Stroke[] strokes = { stroke4, stroke3, stroke2, stroke1 };

                g2d.setColor(fire4);
                g2d.setStroke(stroke4);

                if (dragonIsRight) {
                    if (!(addOnce)) {
                        curLevel.getRope().addX(-6);
                        addOnce = true;
                    }
                    for (int i = 0; i < 4; i++) {
                        g2d.setColor(colors[i]);
                        g2d.setStroke(strokes[i]);

                        int random = MathFunctions.randomInt(0, 4);
                        if ((i == 0) && random == 2) {
                            g2d.drawLine(curLevel.getRope().getX(), curLevel
                                    .getRope().getY(), curLevel.getRope()
                                    .getX(), curLevel.getHeight() + 43);
                        } else if (i == 1 || i == 2 || i == 3) {
                            g2d.drawLine(curLevel.getRope().getX(), curLevel
                                    .getRope().getY(), curLevel.getRope()
                                    .getX(), curLevel.getHeight() + 43);
                        }

                    }

                } else {
                    if (!(addOnce)) {
                        curLevel.getRope().addX(-32);
                        addOnce = true;
                    }
                    for (int i = 0; i < 4; i++) {
                        g2d.setColor(colors[i]);
                        g2d.setStroke(strokes[i]);

                        int random = MathFunctions.randomInt(0, 4);
                        if ((i == 0) && random == 2) {
                            g2d.drawLine(curLevel.getRope().getX(), curLevel
                                    .getRope().getY(), curLevel.getRope()
                                    .getX(), curLevel.getHeight() + 43);
                        } else if (i == 1 || i == 2 || i == 3) {
                            g2d.drawLine(curLevel.getRope().getX(), curLevel
                                    .getRope().getY(), curLevel.getRope()
                                    .getX(), curLevel.getHeight() + 43);
                        }
                    }
                }

                // Set g2d back to normal settings
                g2d.setColor(Color.BLACK);
                Stroke normalStroke = new BasicStroke(1f);
                g2d.setStroke(normalStroke);

            }

            if (curLevel.hasRope() && iceRope) {
                shootRope = true;
                ropeDurationCounter--;

                int rInt219to255 = MathFunctions.randomInt(219, 255);
                int rInt120to102 = MathFunctions.randomInt(120, 236);
                int rInt70to133 = MathFunctions.randomInt(70, 133);
                int rInt6to33 = MathFunctions.randomInt(6, 11);

                Color fire1 = new Color(0, rInt219to255, 255);
                Color fire2 = new Color(36, rInt120to102, 165);
                Color fire3 = new Color(29, rInt70to133, 209);
                Color fire4 = new Color(14, rInt6to33, 120);

                Stroke stroke1 = new BasicStroke(1f);
                Stroke stroke2 = new BasicStroke(3f);
                Stroke stroke3 = new BasicStroke(5f);
                Stroke stroke4 = new BasicStroke(7f);

                Color[] colors = { fire4, fire3, fire2, fire1 };
                Stroke[] strokes = { stroke4, stroke3, stroke2, stroke1 };

                g2d.setColor(fire4);
                g2d.setStroke(stroke4);

                if (dragonIsRight) {
                    if (!(addOnce)) {
                        curLevel.getRope().addX(-6);
                        addOnce = true;
                    }
                    for (int i = 0; i < 4; i++) {
                        g2d.setColor(colors[i]);
                        g2d.setStroke(strokes[i]);

                        int random = MathFunctions.randomInt(0, 4);
                        if ((i == 0) && random == 2) {
                            g2d.drawLine(curLevel.getRope().getX(), curLevel
                                    .getRope().getY(), curLevel.getRope()
                                    .getX(), curLevel.getHeight() + 45);
                        } else if (i == 1 || i == 2 || i == 3) {
                            g2d.drawLine(curLevel.getRope().getX(), curLevel
                                    .getRope().getY(), curLevel.getRope()
                                    .getX(), curLevel.getHeight() + 45);
                        }

                    }

                } else {
                    if (!(addOnce)) {
                        curLevel.getRope().addX(-32);
                        addOnce = true;
                    }
                    for (int i = 0; i < 4; i++) {
                        g2d.setColor(colors[i]);
                        g2d.setStroke(strokes[i]);

                        int random = MathFunctions.randomInt(0, 4);
                        if ((i == 0) && random == 2) {
                            g2d.drawLine(curLevel.getRope().getX(), curLevel
                                    .getRope().getY(), curLevel.getRope()
                                    .getX(), curLevel.getHeight() + 43);
                        } else if (i == 1 || i == 2 || i == 3) {
                            g2d.drawLine(curLevel.getRope().getX(), curLevel
                                    .getRope().getY(), curLevel.getRope()
                                    .getX(), curLevel.getHeight() + 43);
                        }
                    }
                }

                // Set g2d back to normal settings
                g2d.setColor(Color.BLACK);
                Stroke normalStroke = new BasicStroke(1f);
                g2d.setStroke(normalStroke);

            }

            // Draw all the players
            for (int i = 0; i < game.getPlayerList().size(); i++) {
                player = game.getPlayerList().get(i);

                g2d.setFont(new Font("Calibri", Font.ITALIC, 25));
                g2d.setColor(dragonRed);

                if(player.getName() != null)
                {
                    g2d.drawString(player.getName(), player.getX() - 25,
                            player.getY() - 70 + topMargin);
                }
                else
                {
                    g2d.drawString("", player.getX() - 25,
                            player.getY() - 70 + topMargin);
                }
                

                g2d.setColor(Color.BLACK);

                // g2d.fillRect(player.getX(),
                // player.getY() + 2,
                // player.getWidth(), player.getHeight());

                // Get the images of the left flying or right flying dragon
                ImageIcon dragonLeft = new ImageIcon(imageLocation
                        + "src/main/Images/dragon/dragonL" + animationLeftCounter
                        + ".png");
                ImageIcon dragonRight = new ImageIcon(imageLocation
                        + "src/main/Images/dragon/dragonR" + animationRightCounter
                        + ".png");
System.out.println(dragonLeft);
                // Get the current X position of the player.
                int newX = player.getX();

                if (ropeDurationCounter < 40 || !(shootRope)) {
                    // Check if the player is moving.
                    if (oldX != newX) {
                        dragonIsMoving = true;
                    } else {
                        dragonIsMoving = false;
                    }

                    // The dragon was last moving right and should be facing
                    // right now.
                    if (dragonIsRight && !(dragonIsMoving)) {
                        ImageIcon dragonRightNormal = new ImageIcon(
                                imageLocation + "src/main/Images/dragon/dragonR"
                                        + 10 + ".png");
                        g2d.drawImage(dragonRightNormal.getImage(),
                                player.getX() - 50, player.getY(), this);
                    }

                    // The dragon was last moving left and should be facing left
                    // now.
                    else if (!(dragonIsMoving)) {
                        ImageIcon dragonLeftNormal = new ImageIcon(
                                imageLocation + "src/main/Images/dragon/dragonL"
                                        + 10 + ".png");
                        g2d.drawImage(dragonLeftNormal.getImage(),
                                player.getX() - 50, player.getY(), this);
                    }

                    // If the dragon is going right, the animation for flying
                    // right is enabled //curLevel.getHeight() -
                    // player.getHeight() - 117 + topMargin
                    if (oldX < newX) {
                        g2d.drawImage(dragonRight.getImage(),
                                player.getX() - 50, player.getY(), this);
                        dragonIsRight = true;
                        if (slowDownCounter % 24 == 0) {
                            animationRightCounter++;
                        }
                        if (animationRightCounter == 7) {
                            animationRightCounter = 4;
                        }
                    }

                    // If the dragon is going left, the animation for flying
                    // left is enabled //
                    else if (oldX > newX) {
                        g2d.drawImage(dragonLeft.getImage(),
                                player.getX() - 50, player.getY(), this);
                        dragonIsRight = false;
                        if (slowDownCounter % 24 == 0) {
                            animationLeftCounter++;
                        }
                        if (animationLeftCounter == 7) {
                            animationLeftCounter = 4;
                        }
                    }
                }
                if (oldX == newX) {
                    animationRightCounter = 1;
                    animationLeftCounter = 1;
                }

            }

            if (shootRope && ropeDurationCounter > 40) {
                // Draw the dragon spitting fire
                if (dragonIsRight) {
                    ImageIcon dragonRightFire = new ImageIcon(imageLocation
                            + "src/main/Images/dragon/fireR" + fireRightCounter
                            + ".png");
                    g2d.drawImage(dragonRightFire.getImage(), game
                            .getPlayerList().get(0).getX() - 50, player.getY(),
                            this);
                    if (fireRightCounter < 3 && slowDownCounter % 8 == 0) {
                        fireRightCounter++;
                    }
                } else {
                    ImageIcon dragonLeftFire = new ImageIcon(imageLocation
                            + "src/main/Images/dragon/fireL" + fireLeftCounter
                            + ".png");
                    g2d.drawImage(dragonLeftFire.getImage(), game
                            .getPlayerList().get(0).getX() - 50, player.getY(),
                            this);
                    if (fireLeftCounter < 3 && slowDownCounter % 8 == 0) {
                        fireLeftCounter++;
                    }
                }
            }

            // Update the old x coordinate of the player with the current
            // one.
            oldX = game.getPlayerList().get(0).getX();

            // When the dragon is in it's last state of the animation, the
            // animation will reset itself.
            if (animationLeftCounter == 10) {
                animationLeftCounter = 1;
            }
            if (animationRightCounter == 10) {
                animationRightCounter = 1;
            }
            if (!curLevel.hasRope()) {
                shootRope = false;
                fireRightCounter = 1;
                fireLeftCounter = 1;
                addOnce = false;
                ropeDurationCounter = 100;
            }

            slowDownCounter++;

            // Draw the powerups
            for (int i = 0; i < curLevel.getPowerupList().size(); i++) {
                Powerup powerup = curLevel.getPowerupList().get(i);

                ImageIcon powerupImage = powerup.getImageIcon();

                if (powerupImage != null) {
                    g2d.drawImage(powerupImage.getImage(), powerup.getX(),
                            powerup.getY() + 13, this);
                }

            }

            Stroke normalStroke = new BasicStroke(1f);
            g2d.setStroke(normalStroke);

            // Show the lives of the player
            g2d.setFont(new Font("Calibri", Font.BOLD, 40));
            g2d.drawString("Lives: ", centerConstant, curLevel.getHeight() + 45
                    + topMargin);
            ImageIcon life = new ImageIcon(imageLocation
                    + "src/main/Images/life.png");
            for (int i = 0; i < game.getLives(); i++) {
                g2d.drawImage(life.getImage(), centerConstant + 125 + 25 * i,
                        curLevel.getHeight() + 16 + topMargin, this);
            }

            // Show the score of the player
            g2d.drawString("Score: ", centerConstant, curLevel.getHeight() + 91
                    + topMargin);
            g2d.setColor(dragonRed);
            g2d.drawString("" + score.getScore(), centerConstant + 135,
                    curLevel.getHeight() + 91 + topMargin);
            g2d.setColor(Color.BLACK);

            // Show current level number
            g2d.drawString("Level:", centerConstant, 45);
            g2d.setColor(dragonRed);
            g2d.drawString(game.getCurrentLevelInt() + " ",
                    centerConstant + 110, 45);
            g2d.setColor(Color.BLACK);

            g2d.setColor(dragonRed);
            g2d.drawString(" " + (game.getCurrentLevelInt() + 1), 1350,
                    curLevel.getHeight() + 51);
            g2d.setColor(Color.BLACK);
        } catch (IndexOutOfBoundsException e) {

        }
    }

}
