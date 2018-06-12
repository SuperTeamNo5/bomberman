package com.game.bomberman.model;

public class FactoryMonster {

	public Monster create(String nameMonster, Position position) {
		switch (nameMonster) {
		case "nomalMonster":
			return new NomalMonster("nomalMonster", position);

		default:
			return new NomalMonster("nomalMonster", position);
		}

	}

}
