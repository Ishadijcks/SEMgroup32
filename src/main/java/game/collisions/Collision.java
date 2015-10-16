package game.collisions;

import java.util.ArrayList;

import game.Game;
import game.Level;
import game.Player;
import game.Rope;
import game.bubble.Bubble;
import game.log.Logger;
import game.observers.GameController;
import game.observers.LevelController;
import game.observers.PlayerController;
import game.observers.Observable;
import game.observers.Observer;
import game.observers.PowerupController;
import game.observers.BubbleController;
import game.observers.PlayerController;
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
        new BubbleController(this);
        new GameController(this);
        new LevelController(this);
        new PowerupController(this);
        new PlayerController(this);
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
