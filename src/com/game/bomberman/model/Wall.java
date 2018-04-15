package com.game.bomberman.model;

public class Wall extends Barrier {
	private boolean canDestroy;

	public Wall(String name, Position positon) {
		super(name, positon);
		this.canDestroy = false;
	}

	public boolean isCanDestroy() {
		return canDestroy;
	}

}
