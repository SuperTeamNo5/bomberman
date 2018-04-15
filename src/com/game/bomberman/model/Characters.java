package com.game.bomberman.model;

public class Characters {
	private String name;
	private String directional;
	private Position position;
	private Bag bag;
	private int speedRow, speedColumn;
	private final int width = 45;
	private final int height = 55;

	public Characters(String name, String directional, Position position, Bag bag, int speedRow, int speedColumn) {
		super();
		this.name = name;
		this.directional = directional;
		this.position = position;
		this.bag = bag;
		this.speedRow = speedRow;
		this.speedColumn = speedColumn;
		defaultLootInBag();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDirectional() {
		return directional;
	}

	public void setDirectional(String directional) {
		this.directional = directional;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Bag getBag() {
		return bag;
	}

	public void setBag(Bag bag) {
		this.bag = bag;
	}

	public int getSpeedRow() {
		return speedRow;
	}

	public void setSpeedRow(int speedRow) {
		this.speedRow = speedRow;
	}

	public int getSpeedColumn() {
		return speedColumn;
	}

	public void setSpeedColumn(int speedColumn) {
		this.speedColumn = speedColumn;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void defaultLootInBag() {
		Loot loot;
		loot = new Boom("boom", 1);
		getBag().add(loot);
		loot = new Shoes("shoes", 1);
		getBag().add(loot);
		loot = new Soda("soda", 1);
		getBag().add(loot);
	}
}
