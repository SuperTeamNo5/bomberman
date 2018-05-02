package com.game.bomberman.model;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NomalMonster extends Monster implements Move {
	List<String> direc;

	public NomalMonster(String name, Position position) {
		super(name, position);
		this.direc = new ArrayList<>();
		direc.add("up");
		direc.add("right");
		direc.add("left");
	}

	@Override
	public void moveARow() {
		if (getPosition().getxCoordinate() < 0) {
			getPosition().setxCoordinate(0);
			changeDirec();
			direc.add("left");
			return;
		}
		if (getPosition().getxCoordinate() + 45 > 950) {
			getPosition().setxCoordinate(950 - 45);
			changeDirec();
			direc.add("right");
			return;
		}
		if (getDirectional().equalsIgnoreCase("right")) {
			getPosition().setxCoordinate(getPosition().getxCoordinate() + 1);
		}
		if (getDirectional().equalsIgnoreCase("left")) {
			getPosition().setxCoordinate(getPosition().getxCoordinate() - 1);
		}
	}

	@Override
	public void moveAColumn() {
		if (getPosition().getyCoordinate() < -10) {
			getPosition().setyCoordinate(-10);
			changeDirec();
			direc.add("up");
			return;
		}
		if (getPosition().getyCoordinate() + 65 > 660) {
			getPosition().setyCoordinate(660 - 65);
			changeDirec();
			direc.add("down");
			return;
		}
		if (getDirectional().equalsIgnoreCase("down")) {
			getPosition().setyCoordinate(getPosition().getyCoordinate() + 1);
		}
		if (getDirectional().equalsIgnoreCase("up")) {
			getPosition().setyCoordinate(getPosition().getyCoordinate() - 1);
		}
	}

	public void changeDirec() {
		Random ran = new Random();
		int dir = ran.nextInt(3);
		setDirectional(direc.get(dir));
		direc.remove(dir);
	}

	public Rectangle recMons() {
		return new Rectangle(getPosition().getxCoordinate(), getPosition().getyCoordinate(), 45, 55);
	}

	public List<String> getDirec() {
		return direc;
	}

}
