package com.game.bomberman.model;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

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

	public boolean checkNomalMons(Monster mon) {
		Monster mo;
		try {
			mo = (NomalMonster) mon;
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean collision(Rectangle rec1, Rectangle rec2) {
		return rec1.intersects(rec2);
	}

}
