package game.observers;

import game.Collisions;
import game.Game;

public abstract class Observer {
	
	protected Collisions subject;

	public Observer(Collisions collisions){
		this.subject = collisions;
	}
	
	public abstract void update(Object target, Object cause, Game game);

}
