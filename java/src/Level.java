import java.util.ArrayList;

public class Level {
	private ArrayList<Bubble> bubbleList;
	private ArrayList<Player> playerList;
	private Rope rope = null;
	private int timeLeft;
	private int width = 500;
	private int height = 350;

	/**
	 * Constructor, initializes the bubble- and playerList
	 */
	public Level() {
		this.bubbleList = new ArrayList<Bubble>();
		this.playerList = new ArrayList<Player>();
	}

	/**
	 * Checks if there is a collision in the game and if return true that means
	 * the player died
	 * 
	 * @return
	 */
	public boolean checkCollision() {

		// if the rope hits a bubble
		// remove bubble from list
		// add two new smaller bubbles if old radius was > 1
		if (checkCollisionRope() != -1) {
			
			

		}
		// checks if the player needs to die :(
		if (checkCollisionPlayer()) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if there is collision between player and a bubble
	 * 
	 * @return
	 */
	public boolean checkCollisionPlayer() {
		for (int i = 0; i < bubbleList.size(); i++) {
			// if the x of the player and the bubble is the same
			// then there is a chance the rope hits the bubble
			// /// RADIUS NOT IN ACCOUNT JET AND SIZE OF PLAYER
			Player player = playerList.get(0);
			System.out.println("Bubble " + i + ": " + bubbleList.get(i).getX()
					+ ", " + bubbleList.get(i).getY());
			System.out.println("Player: " + player.getX() + ", "
					+ (height - player.getHeight()));
			System.out.println();
			if (bubbleList.get(i).getX() == player.getX()) {
				if (height - player.getHeight() <= bubbleList.get(i).getY()) {
					System.out.println("Died to bubble: " + i);
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Checks if there is collision between rope and a bubble
	 * 
	 * @return -1 if there is no collision otherwise the index of the bubble
	 */
	public int checkCollisionRope() {
		if (hasRope()) {
			for (int i = 0; i < bubbleList.size(); i++) {
				// if the x of the rope and the bubble is the same
				// then there is a chance the rope hits the bubble
				// /// RADIUS NOT IN ACCOUNT JET
				if (bubbleList.get(i).getX() == rope.getX()) {
					// if the ropes end is higher then the bubble it's a hit
					if (rope.getY() <= bubbleList.get(i).getY()) {
						return i;
					}
				}
			}
		}
		return -1;
	}

	public void resetLevel() {
		// reset the level
	}

	/**
	 * Add a bubble to the bubbleList
	 * 
	 * @param bubble
	 *            bubble to add
	 */
	public void addBubble(Bubble bubble) {
		if (!bubbleList.contains(bubble)) {
			bubbleList.add(bubble);
		}
	}

	/**
	 * Add a player to the playerList
	 * 
	 * @param player
	 *            player to add
	 */
	public void addPlayer(Player player) {
		if (!playerList.contains(player)) {
			playerList.add(player);
		}
	}

	public boolean hasRope() {
		return rope != null;
	}

	// Getters and Setters
	public ArrayList<Bubble> getBubbleList() {
		return bubbleList;
	}

	public ArrayList<Player> getPlayerList() {
		return playerList;
	}

	// Getters and Setters
	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public Rope getRope() {
		return rope;
	}

	public void setRope(Rope rope) {
		this.rope = rope;
	}
}
