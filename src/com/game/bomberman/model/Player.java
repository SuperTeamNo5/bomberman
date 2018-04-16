package com.game.bomberman.model;

public class Player {
	private String name;
	private int score;
	private Characters characters;

	public Player(String name, int score, Characters character) {
		super();
		this.name = name;
		this.score = score;
		this.characters = character;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public Characters getCharacter() {
		return characters;
	}
}
