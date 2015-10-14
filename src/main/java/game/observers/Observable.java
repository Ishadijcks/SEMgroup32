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
     *            Observer
     */
    void registerObserver(Observer ob);

    /**
     * Removed The observer.
     */
    void removeObserver(Observer ob);
    
    /**
     * Notify all observers.
     */
    void notifyObservers();

}
