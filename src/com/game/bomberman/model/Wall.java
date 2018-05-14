package com.game.bomberman.model;

public class Wall extends Barrier {

	public Wall(String name, Position positon) {
		super(name, positon);
		this.canDestroy = false;
	}


}
