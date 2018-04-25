package com.game.bomberman.view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.game.bomberman.model.Loot;

import DAO.ImageDAO;

public class LootView extends JPanel {
	private Loot loot;
	private Image img;
	private String name;

	public LootView(Loot loot) {
		this.loot = loot;
		this.name = loot.getName();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		img(g);
	}

	public void img(Graphics g) {
		switch (name) {
		case "bombItem":
			img = new ImageIcon(getClass().getResource(ImageDAO.bomb_item)).getImage();
			g.drawImage(img, loot.getPositon().getxCoordinate(), loot.getPositon().getyCoordinate(), null);

			break;
		case "bomb":
			img = new ImageIcon(getClass().getResource(ImageDAO.bomb)).getImage();
			g.drawImage(img, loot.getPositon().getxCoordinate(), loot.getPositon().getyCoordinate(), null);

			break;
		case "shoes":
			img = new ImageIcon(getClass().getResource(ImageDAO.shoes)).getImage();
			g.drawImage(img, loot.getPositon().getxCoordinate(), loot.getPositon().getyCoordinate(), null);
			break;
		case "soda":
			img = new ImageIcon(getClass().getResource(ImageDAO.soda)).getImage();
			g.drawImage(img, loot.getPositon().getxCoordinate(), loot.getPositon().getyCoordinate(), null);

			break;
		default:
			break;
		}
	}
}
