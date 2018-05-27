package com.game.bomberman.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import com.game.bomberman.model.Characters;

public class KeyBoard implements KeyListener {
	Characters charactes, charactes1;
	List<Action> act;

	public KeyBoard(Characters charactes, List<Action> act) {
		this.charactes = charactes;
		this.act = act;
	}

	public KeyBoard(Characters charactes, Characters charactes1, List<Action> act) {
		this.charactes = charactes;
		this.charactes1 = charactes1;
		this.act = act;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int x = charactes.getBag().search("shoes").getQuatity();
		int y = test();
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			charactes.setDirectional("left");
			charactes.setSpeedRow(-x);
			charactes.setSpeedColumn(0);
			break;
		case KeyEvent.VK_A:
			if (test() != 0) {
				charactes1.setDirectional("left");
				charactes1.setSpeedRow(-y);
				charactes1.setSpeedColumn(0);
			}
			break;
		case KeyEvent.VK_DOWN:
			charactes.setDirectional("down");
			charactes.setSpeedColumn(x);
			charactes.setSpeedRow(0);
			break;
		case KeyEvent.VK_S:
			if (test() != 0) {
				charactes1.setDirectional("down");
				charactes1.setSpeedColumn(y);
				charactes1.setSpeedRow(0);
			}
			break;
		case KeyEvent.VK_RIGHT:
			charactes.setDirectional("right");
			charactes.setSpeedRow(x);
			charactes.setSpeedColumn(0);
			break;
		case KeyEvent.VK_D:
			if (test() != 0) {
				charactes1.setDirectional("right");
				charactes1.setSpeedRow(y);
				charactes1.setSpeedColumn(0);
			}
			break;
		case KeyEvent.VK_UP:
			charactes.setDirectional("up");
			charactes.setSpeedRow(0);
			charactes.setSpeedColumn(-x);
			break;
		case KeyEvent.VK_W:
			if (test() != 0) {
				charactes1.setDirectional("up");
				charactes1.setSpeedRow(0);
				charactes1.setSpeedColumn(-y);
			}
			break;
		case KeyEvent.VK_SPACE:
			act.get(0).dropBomb();
			System.out.println("dropbom");
			break;
		case KeyEvent.VK_G:
			if (test() != 0) {
				act.get(1).dropBomb();
				System.out.println("dropbom");
			}
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
		case KeyEvent.VK_A:
			// charactes.setDirectional("down");
			if (test() != 0) {
				charactes1.setSpeedRow(0);
			}
			break;
		case KeyEvent.VK_DOWN:
			// charactes.setDirectional("down");
			charactes.setSpeedColumn(0);
			break;
		case KeyEvent.VK_S:
			// charactes.setDirectional("down");
			if (test() != 0) {
				charactes1.setSpeedColumn(0);
			}
			break;
		case KeyEvent.VK_RIGHT:
			// charactes.setDirectional("down");
			charactes.setSpeedRow(0);
			break;
		case KeyEvent.VK_D:
			// charactes.setDirectional("down");
			if (test() != 0) {
				charactes1.setSpeedRow(0);
			}
			break;
		case KeyEvent.VK_UP:
			// charactes.setDirectional("down");
			charactes.setSpeedColumn(0);
			break;
		case KeyEvent.VK_W:
			// charactes.setDirectional("down");
			if (test() != 0) {
				charactes1.setSpeedColumn(0);
			}
			break;

		default:
			break;
		}
	}

	public int test() {
		try {
			return charactes1.getBag().search("shoes").getQuatity();
		} catch (Exception e) {
			return 0;
		}
	}

}
