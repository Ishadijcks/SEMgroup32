

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Driver extends JPanel  {

	public static Game game = new Game();
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		// Draw all the bubbles with a black border
		Level curLevel = game.getLevelList().get(game.getCurrentLevel());
		for(int i = 0; i<curLevel.getBubbleList().size(); i++){
			Bubble bubble = curLevel.getBubbleList().get(i);
			g2d.setColor(bubble.getColor());
			g2d.fillOval(bubble.getX(), bubble.getY(), bubble.getRadius(), bubble.getRadius());
			g2d.setColor(Color.black);
			
			g2d.drawOval(bubble.getX()-1,bubble.getY()-1,bubble.getRadius()+2,bubble.getRadius()+2);
		}
		// Draw all the players
		for(int i = 0; i<curLevel.getPlayerList().size(); i++){
			Player player = curLevel.getPlayerList().get(i);
			
			g2d.drawString(player.getName(), player.getX(), curLevel.getHeight()-player.getHeight()-10);
			g2d.fillRect(player.getX(), curLevel.getHeight()-player.getHeight()+2, player.getWidth(), player.getHeight());
		}
		
		// Draw the ropes
		if(curLevel.hasRope()){
		g2d.drawLine(curLevel.getRope().getX(), curLevel.getRope().getY(), curLevel.getRope().getX(), curLevel.getHeight());
		}	
		// Draw the border
		g2d.drawRect(1, 1, curLevel.getWidth(), curLevel.getHeight());

		// Show the lives of the player
		g2d.drawString("Lives: "+game.getLives(),20,curLevel.getHeight()+20);
	}

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Bounce test");
		Driver driver = new Driver();
		frame.addKeyListener(new MyKeyListener());	
		frame.add(driver);
		frame.setSize(600, 500);
		frame.setVisible(true);
		
		Player isha = new Player("Isha",40,10);
		Player tim = new Player("Tim",80,10);
		Bubble bubble1 = new Bubble(4,50,50,true,false);
		Bubble bubble2 = new Bubble(8,50,50,true,true);
		Bubble bubble3 = new Bubble(16,50,50,false,false);
		Bubble bubble4 = new Bubble(8,50,50,false,true);
		Level level1 = new Level();
		level1.addBubble(bubble1);
		level1.addBubble(bubble2);
		level1.addBubble(bubble3);
		level1.addBubble(bubble4);
		level1.addPlayer(isha);
		level1.addPlayer(tim);
		game.addLevel(level1);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (true) {
			
			Level curLevel = game.getLevelList().get(game.getCurrentLevel());
			Player player1 = curLevel.getPlayerList().get(0);
			
			for(int i = 0; i<curLevel.getBubbleList().size(); i++){
				Bubble bubble = curLevel.getBubbleList().get(i);
				bubble.move(curLevel.getWidth(),curLevel.getHeight());
			}
			
			if(curLevel.hasRope()){
			curLevel.getRope().move();
			}
			
			
			player1.move();
			
			driver.repaint();
			
			//120 FPS
			Thread.sleep(1000/120);
		}
	}
	

	
}