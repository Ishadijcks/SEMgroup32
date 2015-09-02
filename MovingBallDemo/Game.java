

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JPanel  {

	public static Ball ball = new Ball(10,true,"red");
	public static Player player = new Player(40);

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		// Draw the ball
		g2d.fillOval(ball.getX(), ball.getY(), ball.getSize(), ball.getSize());
		
		//Draw the player
		g2d.fillRect(player.getX(), 350-player.getHeight()+2, player.getWidth(), player.getHeight()); // 350 should be level.size
		g2d.drawRect(1, 1, 250, 350);

	}

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Bounce test");
		Game game = new Game();
		frame.add(game);
		System.out.println(frame.isFocusable());
		frame.setSize(300, 400);
		frame.setVisible(true);
		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (true) {
			
			if(ball.getX() == 10){
				
			}
			ball.moveBall();
			game.repaint();
			Thread.sleep(1000/60);
		}
	}
	

	
}