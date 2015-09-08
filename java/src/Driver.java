import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Driver extends JPanel {

    public static Game game = new Game();

    @Override
    public void paint(Graphics g) {
        try {

            super.paint(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            // TODO Split up in methods

            // Draw all the bubbles with a black border
            Level curLevel = game.getLevelList().get(game.getCurrentLevel());
            for (int i = 0; i < curLevel.getBubbleList().size(); i++) {
                Bubble bubble = curLevel.getBubbleList().get(i);
                g2d.setColor(bubble.getColor());
                g2d.fillOval(bubble.getX(), bubble.getY(),
                        bubble.getDiameter(), bubble.getDiameter());
                g2d.setColor(Color.black);

                g2d.drawOval(bubble.getX() - 1, bubble.getY() - 1,
                        bubble.getDiameter() + 2, bubble.getDiameter() + 2);
            }
            // Draw all the players
            for (int i = 0; i < curLevel.getPlayerList().size(); i++) {
                Player player = curLevel.getPlayerList().get(i);

                g2d.drawString(player.getName(), player.getX(),
                        curLevel.getHeight() - player.getHeight() - 10);
                g2d.fillRect(player.getX(),
                        curLevel.getHeight() - player.getHeight() + 2,
                        player.getWidth(), player.getHeight());
                // g2d.drawImage(player.getImage(), player.getX(),
                // curLevel.getHeight() - player.getHeight()- 30, this);
            }

            // Draw the powerups
            for (int i = 0; i < curLevel.getPowerupList().size(); i++) {
                Powerup powerup = curLevel.getPowerupList().get(i);

                g2d.fillRect(powerup.getX(), powerup.getY(),
                        powerup.getWidth(), powerup.getHeight());
            }

            // Draw the ropes
            if (curLevel.hasRope()) {
                g2d.drawLine(curLevel.getRope().getX(), curLevel.getRope()
                        .getY(), curLevel.getRope().getX(), curLevel
                        .getHeight());
            }
            // Draw the border
            g2d.drawRect(1, 1, curLevel.getWidth(), curLevel.getHeight());

            // Show the lives of the player
            g2d.drawString("Lives: " + game.getLives(), 20,
                    curLevel.getHeight() + 20);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("First time");
        }
    }

    public void levelWonFrame() {
        if (game.getCurrentLevel() == game.getLevelList().size() - 1) {
            JLabel label = new JLabel("test");
            label.setText("Congratulations! Game won!");
            add(label);
        } else {
            final JLabel label = new JLabel("test");
            label.setText("Congratulations! Level won!");
            add(label);
            final JButton nextLevel = new JButton("Next Level");
            nextLevel.setVerticalTextPosition(AbstractButton.BOTTOM);
            nextLevel.setHorizontalTextPosition(AbstractButton.CENTER);
            nextLevel.setMnemonic(KeyEvent.VK_M);
            nextLevel.setFocusable(false);
            nextLevel.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    game.gameStart();
                    remove(nextLevel);
                    remove(label);
                }
            });
            add(nextLevel);
        }
        validate();
    }

    public void startGame(JFrame frame) {
        frame.setVisible(true);
        game.gameStart();
    }

    public void addStartButton() {
        final JButton nextLevel = new JButton("Start game");
        nextLevel.setVerticalTextPosition(AbstractButton.BOTTOM);
        nextLevel.setHorizontalTextPosition(AbstractButton.CENTER);
        nextLevel.setMnemonic(KeyEvent.VK_M);
        nextLevel.setFocusable(false);
        nextLevel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                game.gameStart();
                remove(nextLevel);
            }
        });
        add(nextLevel);
        validate();
    }

    public static void main(String[] args) throws InterruptedException {

        final JFrame frame = new JFrame("Bounce test");
        Driver driver = new Driver();
        frame.addKeyListener(new MyKeyListener());
        frame.add(driver);
        frame.setSize(Settings.getScreenWidth(), Settings.getScreenHeight());
        frame.setLocationRelativeTo(null);
        frame.setVisible(false);
        new StartScreen(driver, frame);

        Player isha = new Player("Isha", 350, 10);
        Player tim = new Player("Tim", 80, 10);
        Bubble bubble1 = new Bubble(2, 50, 50, false, false);
        Bubble bubble2 = new Bubble(2, 50, 50, true, true);
        Bubble bubble3 = new Bubble(64, 50, 50, false, false);
        Bubble bubble4 = new Bubble(32, 50, 50, false, true);

        Level level1 = new Level();
        Level level2 = new Level();
        level2.addBubble(bubble3);
        level1.addBubble(bubble4);

        level1.addPlayer(isha);
        // level1.addPlayer(tim);
        level2.addPlayer(isha);
        // level2.addPlayer(tim);
        game.addLevel(level1);
        game.addLevel(level2);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            if (game.inProgress()) {
                Level curLevel = game.getLevelList()
                        .get(game.getCurrentLevel());
                Player player1 = curLevel.getPlayerList().get(0);

                for (int i = 0; i < curLevel.getBubbleList().size(); i++) {
                    Bubble bubble = curLevel.getBubbleList().get(i);
                    bubble.move(curLevel.getWidth(), curLevel.getHeight());
                }

                for (int i = 0; i < curLevel.getPowerupList().size(); i++) {
                    curLevel.getPowerupList().get(i).move();
                    curLevel.checkPowerupCollision();
                }

                if (curLevel.hasRope()) {
                    curLevel.getRope().move();
                }

                curLevel.checkCollisionRope();

                if (curLevel.checkCollisionPlayer()) {
                    game.loseLife();
                }
                driver.repaint();
                player1.move();

                if (curLevel.getBubbleList().size() == 0) {
                    boolean once = true;
                    if (once) {
                        once = false;
                        driver.levelWonFrame();
                    }
                    game.gameWon();
                }
            }

            // 120 FPS
            Thread.sleep(1000 / Settings.getFps());
        }

    }

}