package com.game.bomberman.model;

public class FactoryLoot {

	public Loot create(String nameMonster, Position position) {
		switch (nameMonster) {
		case "bombItem":
			return new Boom(nameMonster, position);
		case "shoes":
			return new Shoes(nameMonster, position);
		case "soda":
			return new Soda(nameMonster, position);

		default:
			return new Boom(nameMonster, position);
		}

	}

}
