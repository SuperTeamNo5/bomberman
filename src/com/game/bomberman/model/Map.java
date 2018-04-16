package com.game.bomberman.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Map {
	protected List<Monster> mons;
	protected List<Barrier> bar;
	protected List<Loot> loot;
	protected Player player;

	public Map(Player player) {
		super();
		this.mons = new ArrayList<>();
		this.bar = new ArrayList<>();
		this.loot = new ArrayList<>();
		this.player = player;
	}

	public List<Monster> getMons() {
		return mons;
	}

	public void setMons(List<Monster> mons) {
		this.mons = mons;
	}

	public List<Barrier> getBar() {
		return bar;
	}

	public void setBar(List<Barrier> bar) {
		this.bar = bar;
	}

	public List<Loot> getLoot() {
		return loot;
	}

	public void setLoot(List<Loot> loot) {
		this.loot = loot;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public abstract void createMap();
}
