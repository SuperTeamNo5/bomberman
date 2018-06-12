package com.game.bomberman.model;

import java.util.ArrayList;
import java.util.List;

public class MapLv1 extends Map {
	

	public MapLv1(Player player) {
		super(player);
		createMap(type);
	}

	public MapLv1(Player player1, Player player2) {
		super(player1, player2);
		createMap(type);
	}

	// method create map for class map
	@Override
	public void createBar() {
		int x = 0;
		int y = 50;
		int xmax = 950;
		int ymax = 650;
		int o = 1;
		// create position
		List<Position> positions = new ArrayList<>();
		for (int i = x; i < xmax; i += 50) {
			for (int j = y; j < ymax; j += 100) {
				Position toaDo = new Position(i, j);
				positions.add(toaDo);
			}
		}
		// create position of wall
		CreateCentre wallFactory = new FactoryBarrier();
		for (int i = 0; i < positions.size(); i++) {
			if (o % 2 == 0) {
				bar.add((Barrier)wallFactory.createBarrier("wall", positions.get(i)));
			} else {
				bar.add((Barrier)wallFactory.createBarrier("barrel", positions.get(i)));
			}
			if (i % 6 == 0) {
				o += 1;
			}
		}
<<<<<<< HEAD
		// create position of player
		getPlayer().getCharacter().setPosition(new Position(0, 595));
		// create position of loot
		Loot boom1 = new Boom("bombItem", new Position(50, 150));
		Loot boom2 = new Soda("soda", new Position(50, 250));
		Loot boom3 = new Shoes("shoes", new Position(0, 200));
		loot.add(boom1);
		loot.add(boom2);
		loot.add(boom3);
=======
	}
>>>>>>> 5cc0dd67bbf0af59816c426aa654996b8b3b126d

	@Override
	public void createChar(int number) {
		if (number != 2) {
			getPlayer1().getCharacter().setPosition(new Position(0, 595));
		} else {
			getPlayer1().getCharacter().setPosition(new Position(0, 595));
			getPlayer2().getCharacter().setPosition(new Position(400, 595));
		}
	}

	@Override
	public void createMons() {
		// create position of monster
		Monster monster1 = new NomalMonster("nomalMonster", new Position(0, 87));
		Monster monster2 = new NomalMonster("nomalMonster", new Position(187, 187));
		Monster monster3 = new NomalMonster("nomalMonster", new Position(100, 487));
		Monster monster4 = new NomalMonster("nomalMonster", new Position(450, 387));
		Monster monster5 = new NomalMonster("nomalMonster", new Position(600, -13));
		Monster monster6 = new NomalMonster("nomalMonster", new Position(800, 287));
		mons.add(monster1);
		mons.add(monster2);
		mons.add(monster3);
		mons.add(monster4);
		mons.add(monster5);
		mons.add(monster6);
	}

	@Override
	public void createLoot() {
		// create position of loot
		Loot boom1 = new Boom("bombItem", new Position(50, 150));
		Loot boom3 = new Shoes("shoes", new Position(0, 200));
		Loot boom2 = new Soda("soda", new Position(50, 250));
		loot.add(boom1);
		loot.add(boom2);
		loot.add(boom3);
	}

}
