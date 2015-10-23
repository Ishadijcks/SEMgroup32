package game.observers;

/**
 * Observable class.
 * 
 * @author Floris
 *
 */
public interface Observable {

    /**
     * register the observer.
     * 
     * @param ob
     *            The current observer object
     */
    void registerObserver(Observer ob);

    /**
     * Remove the observer.
     * @param ob The observer to remove
     */
    void removeObserver(Observer ob);
    
    /**
     * Notify all observers.
     */
    void notifyObservers();

}
