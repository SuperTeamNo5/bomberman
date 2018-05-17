package com.game.bomberman.model;

public abstract class Loot {
	protected String name;
	protected Position positon;
	protected int quatity;

	public Loot(String name, Position positon, int quatity) {
		super();
		this.name = name;
		this.positon = positon;
		this.quatity = quatity;
	}

	public Loot(String name, int quatity) {
		super();
		this.name = name;
		this.quatity = quatity;
	}

	public Loot(String name, Position positon) {
		super();
		this.name = name;
		this.positon = positon;
	}

	public Loot(Position positon) {
		super();
		this.positon = positon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Position getPositon() {
		return positon;
	}

	public void setPositon(Position positon) {
		this.positon = positon;
	}

	public int getQuatity() {
		return quatity;
	}

	public void setQuatity(int quatity) {
		this.quatity = quatity;
	}

}
