package com.game.bomberman.controller;

import java.awt.Rectangle;
import java.util.List;

import com.game.bomberman.model.Barrier;
import com.game.bomberman.model.Map;
import com.game.bomberman.model.Player;

// including methods action for game
public class Action {
	private Player player;
	private List<Barrier> bar;

	public Action(Map map) {
		this.player = map.getPlayer();
		this.bar = map.getBar();
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
				return rec2;
			}
		}
		return null;
	}
}
