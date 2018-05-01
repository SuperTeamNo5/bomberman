package com.game.bomberman.controller;

import java.awt.Rectangle;
import java.util.List;

import com.game.bomberman.model.Barrier;
import com.game.bomberman.model.Boom;
import com.game.bomberman.model.Characters;
import com.game.bomberman.model.Loot;
import com.game.bomberman.model.Map;
import com.game.bomberman.model.Monster;
import com.game.bomberman.model.Player;
import com.game.bomberman.model.Position;
import com.game.bomberman.view.ViewGame;

// including methods action for game
public class Action {
	private Player player;
	private List<Barrier> bar;
	private List<Loot> loot;
	private List<Monster> mons;

	private Map map;
	private ViewGame view;

	public Action(Map map) {
		this.map = map;
		this.player = map.getPlayer();
		this.bar = map.getBar();
		this.loot = map.getLoot();
		this.mons = map.getMons();
	}

	public boolean charDead() {
		return player.getCharacter().isDead();
	}

	// update character
	public void updateChar() {
		if (collisionPlayerAndBar() != null) {
			player.getCharacter().setSpeedColumn(0);
			player.getCharacter().setSpeedRow(0);
			System.out.println("vao");
			updateCharAfterCollision();
			return;
		}
		player.getCharacter().moveARow();
		player.getCharacter().moveAColumn();
		// System.out.println(player.getCharacter().getSpeedColumn());
	}

	public void updateCharAfterCollision() {
		Rectangle rec1 = player.getCharacter().recPlayer();
		Rectangle rec2 = collisionPlayerAndBar();
		Rectangle rec3 = new Rectangle();
		// if (rec2 != null) {
		rec1.intersect(rec1, rec2, rec3);
		String dir = player.getCharacter().getDirectional();
		if (dir.equalsIgnoreCase("down")) {
			player.getCharacter().getPosition()
					.setyCoordinate(player.getCharacter().getPosition().getyCoordinate() - rec3.height - 1);
		}
		if (dir.equalsIgnoreCase("up")) {
			player.getCharacter().getPosition()
					.setyCoordinate(player.getCharacter().getPosition().getyCoordinate() + rec3.height + 1);
		}
		if (dir.equalsIgnoreCase("left")) {
			player.getCharacter().getPosition()
					.setxCoordinate(player.getCharacter().getPosition().getxCoordinate() + rec3.width + 1);
		}
		if (dir.equalsIgnoreCase("right")) {
			player.getCharacter().getPosition()
					.setxCoordinate(player.getCharacter().getPosition().getxCoordinate() - rec3.width - 1);
		}
		// }
	}

	public Rectangle collisionPlayerAndBar() {
		Rectangle rec1 = player.getCharacter().recPlayer();
		Rectangle rec2;
		for (int i = 0; i < bar.size(); i++) {
			rec2 = new Rectangle(bar.get(i).getPosition().getxCoordinate(), bar.get(i).getPosition().getyCoordinate(),
					bar.get(i).getWidth(), bar.get(i).getHeight() - 30);
			if (player.getCharacter().collision(rec1, rec2)) {
				// System.out.println("va cham");
				return rec2;
			}
		}
		return null;
	}

	public void dropBomb() {
		Characters chara = player.getCharacter();
		int x = chara.getPosition().getxCoordinate() + chara.getWidth() / 2;
		int y = chara.getPosition().getyCoordinate() + chara.getHeight() / 2;
		// int x = chara.getPosition().getxCoordinate();
		// int y = chara.getPosition().getyCoordinate();
		Loot bomb = new Boom("bomb", new Position((x / 45) * 45, (y / 50) * 50), 3000);
		loot.add(bomb);
		// map.setLoot(loot);

	}

	public List<Loot> collisionPlayerVsLoot() {
		Rectangle rec1 = player.getCharacter().recPlayer();
		Rectangle rec2;
		// dropBomb();
		for (int i = 0; i < loot.size(); i++) {
			if (loot.get(i).getName().equalsIgnoreCase("bomb")) {

			} else {
				rec2 = new Rectangle(loot.get(i).getPositon().getxCoordinate() + 10,
						loot.get(i).getPositon().getyCoordinate() + 10, 30, 30);
				// System.out.println(player.getCharacter().collision(rec1,
				// rec2));
				if (player.getCharacter().collision(rec1, rec2)) {
					// System.out.println("va cham vs loot");
					player.getCharacter().getBag().add(loot.get(i));
					loot.remove(i);
					map.setLoot(loot);
					return loot;
				}
			}
		}
		return loot;
	}

	public void collisionPlayerVsMons() {
		Rectangle rec1 = player.getCharacter().recPlayer();
		Rectangle rec2;
		for (int i = 0; i < mons.size(); i++) {
			Monster mon = mons.get(i);
			rec2 = new Rectangle(mon.getPosition().getxCoordinate(), mon.getPosition().getyCoordinate(), 45, 55);
			if (player.getCharacter().collision(rec1, rec2)) {
				player.getCharacter().dead();
				// System.out.println("xxxxxxxxxxxx: " +
				// player.getCharacter().isDead());

			}
		}
	}

}
