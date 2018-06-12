package com.game.bomberman.model;

public class Boom extends Loot {
	private int deadLine;
	private int bombang_left, bombang_right, bombang_up, bombang_down;
	private String bombOf;

	public Boom(String name, int quatity) {// use for bag
		super(name, quatity);
	}

	public Boom(String name, Position positon) {// use for boomItem
		super(name, positon);
	}

	public Boom(Position positon, String bombOf) {// use for bomb
		super(positon);
		this.name = "bomb";
		this.deadLine = 450;
		this.bombOf = bombOf;
		this.bombang_down = 1;
		this.bombang_left = 1;
		this.bombang_right = 1;
		this.bombang_up = 1;
	}

	public int getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(int deadLine) {
		this.deadLine = deadLine;
	}

	public int getBombang_left() {
		return bombang_left;
	}

	public void setBombang_left(int bombang_left) {
		this.bombang_left = bombang_left;
	}

	public int getBombang_right() {
		return bombang_right;
	}

	public void setBombang_right(int bombang_right) {
		this.bombang_right = bombang_right;
	}

	public int getBombang_up() {
		return bombang_up;
	}

	public void setBombang_up(int bombang_up) {
		this.bombang_up = bombang_up;
	}

	public int getBombang_down() {
		return bombang_down;
	}

	public void setBombang_down(int bombang_down) {
		this.bombang_down = bombang_down;
	}

	public String getBombOf() {
		return bombOf;
	}

	public void setBombOf(String bombOf) {
		this.bombOf = bombOf;
	}

}
