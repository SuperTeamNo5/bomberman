package com.game.bomberman.model;

public class Barrel extends Barrier {

	public Barrel(String name, Position positon) {
		super(name, positon);
		this.canDestroy = true;
	}


}
