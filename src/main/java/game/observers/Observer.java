package game.observers;

import game.Game;

/**
 * Observer class for the game.
 * @author Floris
 *
 */
public abstract class Observer {
	
	protected Object subject;

	/**
     * constructor.
     * @param collisions object
     */
	public Observer(Object subject){
		this.subject = subject;
	}

    /**
     * The update method of the observer.
     * @param target object
     * @param cause object
     * @param game object
     */
    public abstract void update(Object target, Object cause, Game game);

}
