package game.collisions;

import java.util.ArrayList;

public class CollisionFactory {

	public CollisionFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Collision> buildAllCollisions() {
		ArrayList<Collision> collisions = new ArrayList<Collision>();
		
		collisions.add(buildPlayerBubbleCollision());
		collisions.add(buildPlayerPowerupCollision());
		collisions.add(buildRopeBubbleCollision());
		collisions.add(buildWallBubbleCollision());
		collisions.add(buildWallPlayerCollision());
		
		return collisions;
	}
	
	public Collision buildPlayerBubbleCollision(){
		return new PlayerBubbleCollision();
	}
	
	public Collision buildPlayerPowerupCollision() {
		return new PlayerPowerupCollision();
	}
	
	public Collision buildRopeBubbleCollision() {
		return new RopeBubbleCollision();
	}
	
	public Collision buildWallBubbleCollision() {
		return new WallBubbleCollision();
	}
	
	public Collision buildWallPlayerCollision() {
		return new WallPlayerCollision();
	}

}
