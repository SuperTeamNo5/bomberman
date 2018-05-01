package com.game.bomberman.observer;

import java.util.ArrayList;

public class InformationPanelSubject implements MySubject {
	ArrayList<MyObserver> listObserver;

	public InformationPanelSubject() {
		listObserver = new ArrayList<MyObserver>();
	}

	@Override
	public void registerObserver(MyObserver obs) {
		listObserver.add(obs);
	}

	@Override
	public void removeObserver(MyObserver obs) {
		listObserver.remove(obs);
	}

	@Override
	public void notifyObserver() {
		for (int i = 0; i < listObserver.size(); i++) {
			listObserver.get(i).updateNameItem("hahah");
		}
	}

}
