package game.observers;

import game.Collisions;
import game.Game;

public abstract class Observer {
	
	protected Object subject;

	public Observer(Object subject){
		this.subject = subject;
	}
	
	public abstract void update(Object target, Object cause, Game game);

}
