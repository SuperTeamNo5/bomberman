package com.game.bomberman.observer;

public interface MySubject {

	public void registerObserver(MyObserver myobs);

	public void removeObserver(MyObserver myobs);

	public void notifyObserver();

}
