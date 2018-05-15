package com.game.bomberman.model;

public abstract class Barrier {
	protected String name;
	protected Position position;
	protected final int width = 50;
	protected final int height = 50;
	protected boolean canDestroy;

	public Barrier(String name, Position position) {
		super();
		this.name = name;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public Position getPosition() {
		return position;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public boolean isCanDestroy() {
		return canDestroy;
	}
}
