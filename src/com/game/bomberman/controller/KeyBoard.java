package com.game.bomberman.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.game.bomberman.model.Characters;

public class KeyBoard implements KeyListener {
	Characters charactes;
	Action act;

	public KeyBoard(Characters charactes, Action act) {
		this.charactes = charactes;
		this.act = act;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int x = charactes.getBag().search("shoes").getQuatity();
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			charactes.setDirectional("left");
			charactes.setSpeedRow(-x);
			charactes.setSpeedColumn(0);
			break;
		case KeyEvent.VK_DOWN:
			charactes.setDirectional("down");
			charactes.setSpeedColumn(x);
			charactes.setSpeedRow(0);
			break;
		case KeyEvent.VK_RIGHT:
			charactes.setDirectional("right");
			charactes.setSpeedRow(x);
			charactes.setSpeedColumn(0);
			break;
		case KeyEvent.VK_UP:
			charactes.setDirectional("up");
			charactes.setSpeedRow(0);
			charactes.setSpeedColumn(-x);
			break;
		case KeyEvent.VK_SPACE:
			act.dropBomb();
			break;

		default:
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			// charactes.setDirectional("down");
			charactes.setSpeedRow(0);
			break;
		case KeyEvent.VK_DOWN:
			// charactes.setDirectional("down");
			charactes.setSpeedColumn(0);
			break;
		case KeyEvent.VK_RIGHT:
			// charactes.setDirectional("down");
			charactes.setSpeedRow(0);
			break;
		case KeyEvent.VK_UP:
			// charactes.setDirectional("down");
			charactes.setSpeedColumn(0);
			break;

		default:
			break;
		}
	}

}
