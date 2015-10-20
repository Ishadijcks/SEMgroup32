package game.collisions;

import java.util.ArrayList;

import game.Game;
import game.Level;
import game.Player;
import game.Rope;
import game.bubble.Bubble;
import game.log.Logger;
import game.observers.GameObserver;
import game.observers.LevelObserver;
import game.observers.PlayerObserver;
import game.observers.Observable;
import game.observers.Observer;
import game.observers.PowerupObserver;
import game.observers.BubbleObserver;
import game.observers.PlayerObserver;
import game.powerups.Powerup;
import game.wall.Wall;

/**
 * Handles all the collisions.
 * 
 * @author Tim
 *
 */
public abstract class Collision implements Observable {

    private Game game;
    protected ArrayList<Observer> observers = new ArrayList<Observer>();

    /**
     * constructor.
     */
    public Collision() {
        new BubbleObserver(this);
        new GameObserver(this);
        new LevelObserver(this);
        new PowerupObserver(this);
        new PlayerObserver(this);
    }
    
    /**
     * Abstract method for children to have a correct 
     * respond to a collision.
     * @param game that bares the current state
     */
    public abstract boolean checkCollision(Game game);
    
    /**
     * Notify the observers listening to the current class
     */
    public abstract void notifyListeningObservers();
    
    /**
     * Notify the observers listening to the current class
     * @param o object which might be needed.
     */
    public abstract void notifyListeningObservers(Object object);

    @Override
    public void registerObserver(Observer ob) {
    	observers.add(ob);
    }

    @Override
    public void removeObserver(Observer ob) {
        observers.remove(ob);

    }

    @Override
    public void notifyObservers() {
        // TODO Auto-generated method stub

    }
    
    
}
