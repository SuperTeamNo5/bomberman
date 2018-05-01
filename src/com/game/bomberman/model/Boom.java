package com.game.bomberman.model;

public class Boom extends Loot {
	private int deadLine;

	public Boom(String name, int quatity) {// use for bag
		super(name, quatity);
	}

	public Boom(String name, Position positon) {// use for boomItem
		super(name, positon);
	}

	public Boom(String name, Position positon, int deadLine) {// use for boom
		super(name, positon);
		this.deadLine = deadLine;
	}

	public int getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(int deadLine) {
		this.deadLine = deadLine;
	}

}
