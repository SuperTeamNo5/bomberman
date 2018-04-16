package com.game.bomberman.controller;

import com.game.bomberman.model.Player;

// including methods action for game
public class Action {
	private Player player;

	public Action(Player player) {
		this.player = player;
	}

	// chacracter move row
	public void moveARow() {
		player.getCharacter().getPosition().setxCoordinate(
				player.getCharacter().getPosition().getxCoordinate() + player.getCharacter().getSpeedRow());
	}

	// chacracter move column
	public void moveAColumn() {
		player.getCharacter().getPosition().setyCoordinate(
				player.getCharacter().getPosition().getyCoordinate() + player.getCharacter().getSpeedColumn());
	}

	// update character
	public void updateChar() {
		moveARow();
		moveAColumn();
		// System.out.println(player.getCharacter().getSpeedColumn());
	}
}
