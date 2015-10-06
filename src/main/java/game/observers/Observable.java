package game.observers;

public interface Observable {

	public void registerObserver(Observer ob);
	public void removeObserver();
	public void notifyObservers();

}
