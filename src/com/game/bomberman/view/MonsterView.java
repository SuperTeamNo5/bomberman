package com.game.bomberman.view;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.game.bomberman.model.Monster;

import DAO.ImageDAO;

public class MonsterView extends JPanel {
	private Monster monster;
	private Image img;

	public MonsterView(Monster monster) {
		this.monster = monster;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		img(g);
	}

	public void img(Graphics g) {
		switch (monster.getName()) {
		case "nomalMonster":
			if (monster.getDirectional().equalsIgnoreCase("down")) {
				img = new ImageIcon(getClass().getResource(ImageDAO.monster_Down)).getImage();
				g.drawImage(img, monster.getPosition().getxCoordinate(), monster.getPosition().getyCoordinate(), 45, 55,
						null);
			}
			if (monster.getDirectional().equalsIgnoreCase("up")) {
				img = new ImageIcon(getClass().getResource(ImageDAO.monster_UP)).getImage();
				g.drawImage(img, monster.getPosition().getxCoordinate(), monster.getPosition().getyCoordinate(), 45, 55,
						null);
			}
			if (monster.getDirectional().equalsIgnoreCase("right")) {
				img = new ImageIcon(getClass().getResource(ImageDAO.monster_Right)).getImage();
				g.drawImage(img, monster.getPosition().getxCoordinate(), monster.getPosition().getyCoordinate(), 45, 55,
						null);
			}
			if (monster.getDirectional().equalsIgnoreCase("left")) {
				img = new ImageIcon(getClass().getResource(ImageDAO.monster_Left)).getImage();
				g.drawImage(img, monster.getPosition().getxCoordinate(), monster.getPosition().getyCoordinate(), 45, 55,
						null);
			}
			break;

		default:
			break;
		}
	}
}
