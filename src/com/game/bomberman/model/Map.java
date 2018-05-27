package com.game.bomberman.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Map {
	protected List<Monster> mons;
	protected List<Barrier> bar;
	protected List<Loot> loot;
	protected Player player1, player2;
	protected int type;

	public Map(Player player1) {
		super();
		this.type = 1;
		this.mons = new ArrayList<>();
		this.bar = new ArrayList<>();
		this.loot = new ArrayList<>();
		this.player1 = player1;
	}

	public Map(Player player1, Player player2) {
		super();
		this.type = 2;
		this.mons = new ArrayList<>();
		this.bar = new ArrayList<>();
		this.loot = new ArrayList<>();
		this.player1 = player1;
		this.player2 = player2;
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

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	protected void createMap(int number) {
		if (number == 1) {
			createBar();
			createChar(number);
			createLoot();
			createMons();
		} else {
			createBar();
			createChar(number);
			createLoot();
			createMons();
		}
	}

	public abstract void createBar();

	public abstract void createChar(int number);

	public abstract void createMons();

	public abstract void createLoot();
}
