package com.game.bomberman.model;

public abstract class Monster {
	protected String name;
	protected Position position;
	protected String directional;

	public Monster(String name, Position position) {
		super();
		this.name = name;
		this.position = position;
		this.directional = "down";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String getDirectional() {
		return directional;
	}

	public void setDirectional(String directional) {
		this.directional = directional;
	}

}
