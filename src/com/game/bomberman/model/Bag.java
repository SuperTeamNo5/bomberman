package com.game.bomberman.model;

import java.util.ArrayList;
import java.util.List;

public class Bag {
	private List<Loot> lootList;

	public Bag() {
		lootList = new ArrayList<>();
	}

	// update bag 
	public void add(Loot loot) {
		for (int i = 0; i < lootList.size(); i++) {
			Loot lo = lootList.get(i);
			if (loot.getName().equalsIgnoreCase(lo.getName())) {
				lo.setQuatity(lo.getQuatity() + 1);
			}
		}
		lootList.add(loot);
	}

	// get quality of loot in list
	public Loot search(String name) {
		for (int i = 0; i < lootList.size(); i++) {
			if (name.equalsIgnoreCase(lootList.get(i).getName())) {
				return lootList.get(i);
			}
		}
		return null;
	}

	public List<Loot> getLootList() {
		return lootList;
	}

	public void setLootList(List<Loot> lootList) {
		this.lootList = lootList;
	}
}
