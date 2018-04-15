package com.game.bomberman.model;

public class Barrel extends Barrier {
	private boolean canDestroy;

	public Barrel(String name, Position positon) {
		super(name, positon);
		this.canDestroy = true;
	}

	public boolean isCanDestroy() {
		return canDestroy;
	}

}
