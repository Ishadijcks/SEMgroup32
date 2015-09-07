import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Driver extends JPanel {

	public static Game game = new Game();
	private int animationRightCounter = 1;
	private int animationLeftCounter = 1;
	private int slowDownCounter = 0;
	private int oldX;
	private static boolean dragonIsRight = true;
	private boolean dragonIsMoving = false;
	private boolean shootRope = false;
	private static URL location = StartScreen.class.getProtectionDomain().getCodeSource().getLocation();
	private static String imageLocation = location.getFile();

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
				g2d.fillOval(bubble.getX(), bubble.getY(), bubble.getRadius(),
						bubble.getRadius());
				g2d.setColor(Color.black);

				g2d.drawOval(bubble.getX() - 1, bubble.getY() - 1,
						bubble.getRadius() + 2, bubble.getRadius() + 2);
			}
			
			// Draw the ropes
						if (curLevel.hasRope()) {
							shootRope = true;
							Player player = curLevel.getPlayerList().get(0);
							g2d.setColor(Color.RED);
							// creates a solid stroke with line width is 2
							Stroke stroke = new BasicStroke(2f);
							g2d.setStroke(stroke);
							if(dragonIsRight)
							{
								g2d.drawLine(curLevel.getRope().getX(), curLevel.getRope()
										 .getY(), curLevel.getRope().getX(), curLevel
										 .getHeight());
							}
							else
							{
								g2d.drawLine(curLevel.getRope().getX() - 35, curLevel.getRope()
										 .getY(), curLevel.getRope().getX() - 35, curLevel
										 .getHeight());
							}
							 
							 
							 //Set g2d back to normal settings
							 g2d.setColor(Color.BLACK);
								// creates a solid stroke with line width is 2
								Stroke normalStroke = new BasicStroke(1f);
								g2d.setStroke(normalStroke);

						}
			
			// Draw all the players
			for (int i = 0; i < curLevel.getPlayerList().size(); i++) {
				Player player = curLevel.getPlayerList().get(i);

				g2d.drawString(player.getName(), player.getX(),
						curLevel.getHeight() - player.getHeight() - 10);
				
				// g2d.fillRect(player.getX(),
				// curLevel.getHeight() - player.getHeight() + 2,
				// player.getWidth(), player.getHeight());

				// Get the images of the left flying or right flying dragon
				ImageIcon dragonLeft = new ImageIcon(imageLocation + "Images/dragonL" + animationLeftCounter + ".png");
				ImageIcon dragonRight = new ImageIcon(imageLocation + "Images/dragonR" + animationRightCounter + ".png");
				
				// Get the current X position of the player.
				int newX = player.getX();
				
				if(!shootRope)
				{
					// Check if the player is moving.
					if(oldX != newX)
					{
						dragonIsMoving = true;
					}
					else
					{
						dragonIsMoving = false;
					}
					
					// The dragon was last moving right and should be facing right now.
					if(dragonIsRight && !(dragonIsMoving))
					{
						ImageIcon dragonRightNormal = new ImageIcon(imageLocation + "Images/dragonR" + 10 + ".png");
						g2d.drawImage(dragonRightNormal.getImage(), player.getX() - 100,
								curLevel.getHeight() - player.getHeight() - 117, this);
					}
					// The dragon was last moving left and should be facing left now.
					else if(!(dragonIsMoving))
					{
						ImageIcon dragonLeftNormal = new ImageIcon(imageLocation + "Images/dragonL" + 10 + ".png");
						g2d.drawImage(dragonLeftNormal.getImage(), player.getX() - 100,
								curLevel.getHeight() - player.getHeight() - 117, this);
					}
					
					// If the dragon is going right, the animation for flying right is enabled
					if(oldX < newX)
					{
						g2d.drawImage(dragonRight.getImage(), player.getX() - 100,
								curLevel.getHeight() - player.getHeight() - 117, this);
						dragonIsRight = true;
						if(slowDownCounter%20 == 0)
						{
							animationRightCounter++;
						}
					}
					// If the dragon is going left, the animation for flying left is enabled
					else if(oldX > newX)
					{
						g2d.drawImage(dragonLeft.getImage(), player.getX() - 100,
								curLevel.getHeight() - player.getHeight() - 117, this);
						dragonIsRight = false;
						if(slowDownCounter%20 == 0)
						{
							animationLeftCounter++;
						}
					}
				}
				
				// Draw the dragon spitting fire
				if(dragonIsRight && shootRope)
				{
					ImageIcon dragonRightFire = new ImageIcon(imageLocation + "Images/dragonRFire.png");
					g2d.drawImage(dragonRightFire.getImage(), player.getX() - 100,
							curLevel.getHeight() - player.getHeight() - 112, this);
				}
				else if(shootRope)
				{
					ImageIcon dragonLeftFire = new ImageIcon(imageLocation + "Images/dragonLFire.png");
					g2d.drawImage(dragonLeftFire.getImage(), player.getX() - 100,
							curLevel.getHeight() - player.getHeight() - 112, this);
				}
				
				// Update the old x coordinate of the player with the current one.
				oldX = player.getX();
				
				// When the dragon is in it's last state of the animation, the animation will reset itself.
				if(animationLeftCounter == 10)
				{
					animationLeftCounter = 1;
				}
				if(animationRightCounter == 10)
				{
					animationRightCounter = 1;
				}
				if(!curLevel.hasRope())
				{
					shootRope = false;
				}
				
				slowDownCounter++;
			}

			// Draw the border
			g2d.drawRect(1, 1, curLevel.getWidth(), curLevel.getHeight());

			// Show the lives of the player
			g2d.setFont(new Font("Calibri", Font.BOLD, 30));
			g2d.drawString("Lives: ", 20,
					curLevel.getHeight() + 35);
			ImageIcon life = new ImageIcon(imageLocation + "Images/life.png");
			for(int i = 0; i < game.getLives(); i++)
			{
				g2d.drawImage(life.getImage(), 88 + 25*i,
						curLevel.getHeight() + 7, this);
			}
			
			// Show the score of the player
			g2d.drawString("Score: ", 20,
					curLevel.getHeight() + 70);
			
			// Show current level number
			g2d.drawString("Level: " + game.getCurrentLevel(), 20,
					curLevel.getHeight() + 105);
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
		frame.setSize(1125, 800);
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

				if (curLevel.hasRope()) {
					curLevel.getRope().move();
				}

				curLevel.checkCollisionRope(dragonIsRight);

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
			Thread.sleep(1000 / 120);
		}

	}

}