package com.game.bomberman.model;

import java.awt.Rectangle;

public class Characters implements Move {
	private String name;
	private int heart = 3;
	private String directional;
	private Position position;
	private Bag bag;
	private int speedRow, speedColumn;
	private final int width = 40;
	private final int height = 50;
	private boolean dead;
	private boolean collisionVsBomb;

	public Characters(String name, int heart, String directional, Position position, Bag bag, int speedRow,
			int speedColumn) {
		super();
		this.name = name;
		this.heart = heart;
		this.directional = directional;
		this.position = position;
		this.bag = bag;
		this.speedRow = speedRow;
		this.speedColumn = speedColumn;
		this.dead = false;
		this.collisionVsBomb = false;
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
		loot = new Boom("bombItem", 1);
		getBag().add(loot);
		loot = new Shoes("shoes", 1);
		getBag().add(loot);
		loot = new Soda("soda", 2);
		getBag().add(loot);
	}

	// chacracter move row
	public void moveARow() {
		if (getPosition().getxCoordinate() < 0) {
			getPosition().setxCoordinate(0);
			return;
		}
		if (getPosition().getxCoordinate() + 45 > 950) {
			getPosition().setxCoordinate(950 - 45);
			return;
		}
		getPosition().setxCoordinate(getPosition().getxCoordinate() + getSpeedRow());
	}

	// chacracter move column
	public void moveAColumn() {
		if (getPosition().getyCoordinate() < -10) {
			getPosition().setyCoordinate(-10);
			return;
		}
		if (getPosition().getyCoordinate() + 65 > 660) {
			getPosition().setyCoordinate(660 - 65);
			return;
		}
		getPosition().setyCoordinate(getPosition().getyCoordinate() + getSpeedColumn());
	}

	public Rectangle recPlayer() {
		return new Rectangle(getPosition().getxCoordinate(), getPosition().getyCoordinate(), getWidth(), getHeight());
	}

	// test collision between player and something
	public boolean collision(Rectangle rec1, Rectangle rec2) {
		return rec1.intersects(rec2);

	}

	public void dead() {
		setDead(true);
	}

	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}

	public boolean isCollisionVsBomb() {
		return collisionVsBomb;
	}

	public void setCollisionVsBomb(boolean collisionVsBomb) {
		this.collisionVsBomb = collisionVsBomb;
	}

	public int getHeart() {
		return heart;
	}

	public void setHeart(int heart) {
		this.heart = heart;
	}
}
