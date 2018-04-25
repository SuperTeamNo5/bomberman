package com.game.bomberman.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.game.bomberman.model.Characters;

public class KeyBoard implements KeyListener {
	Characters charactes;

	public KeyBoard(Characters charactes) {
		this.charactes = charactes;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int x = charactes.getBag().search("shoes").getQuatity();
		switch (e.getKeyCode()) {
		case KeyEvent.VK_A:
			charactes.setDirectional("left");
			charactes.setSpeedRow(-x);
			charactes.setSpeedColumn(0);
			break;
		case KeyEvent.VK_S:
			charactes.setDirectional("down");
			charactes.setSpeedColumn(x);
			charactes.setSpeedRow(0);
			break;
		case KeyEvent.VK_D:
			charactes.setDirectional("right");
			charactes.setSpeedRow(x);
			charactes.setSpeedColumn(0);
			break;
		case KeyEvent.VK_W:
			charactes.setDirectional("up");
			charactes.setSpeedRow(0);
			charactes.setSpeedColumn(-x);
			break;

		default:
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_A:
			// charactes.setDirectional("down");
			charactes.setSpeedRow(0);
			break;
		case KeyEvent.VK_S:
			// charactes.setDirectional("down");
			charactes.setSpeedColumn(0);
			break;
		case KeyEvent.VK_D:
			// charactes.setDirectional("down");
			charactes.setSpeedRow(0);
			break;
		case KeyEvent.VK_W:
			// charactes.setDirectional("down");
			charactes.setSpeedColumn(0);
			break;

		default:
			break;
		}
	}

}
