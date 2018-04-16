package com.game.bomberman.model;

import java.util.ArrayList;
import java.util.List;

public class Bag {
	private List<Loot> lootList;

	public Bag() {
		lootList = new ArrayList<>();
	}

	public void add(Loot loot) {
		lootList.add(loot);
	}

	public Loot search(String name) {
		for (int i = 0; i < lootList.size(); i++) {
			if (name.equalsIgnoreCase(lootList.get(i).getName())) {
				return lootList.get(i);
			}
		}
		return null;
	}
}
