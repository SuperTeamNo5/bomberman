package com.game.bomberman.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.game.bomberman.model.Boom;
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
		case "bombang":
			Boom bombang = (Boom) loot;
			img = new ImageIcon(getClass().getResource(ImageDAO.bombang_down)).getImage();
			g.drawImage(img, loot.getPositon().getxCoordinate(), loot.getPositon().getyCoordinate(), 45,
					45 + (45 * bombang.getBombang_down()), null);
			img = new ImageIcon(getClass().getResource(ImageDAO.bombang_up)).getImage();
			g.drawImage(img, loot.getPositon().getxCoordinate(),
					loot.getPositon().getyCoordinate() - (45 * bombang.getBombang_up()), 45,
					45 + (45 * bombang.getBombang_up()), null);
			img = new ImageIcon(getClass().getResource(ImageDAO.bombang_right)).getImage();
			// System.out.println("/////////////////////"+bombang.getBombang_right());
			g.drawImage(img, loot.getPositon().getxCoordinate(), loot.getPositon().getyCoordinate(),
					45 + (45 * bombang.getBombang_right()), 45, null);
			img = new ImageIcon(getClass().getResource(ImageDAO.bombang_left)).getImage();
			g.drawImage(img, loot.getPositon().getxCoordinate() - (45 * bombang.getBombang_left()),
					loot.getPositon().getyCoordinate(), 45 + (45 * bombang.getBombang_left()), 45, null);

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
		// Rectangle rec = new Rectangle(loot.getPositon().getxCoordinate() +
		// 10, loot.getPositon().getyCoordinate() + 10,
		// 30, 30);
		// g.drawRect(rec.x, rec.y, rec.width, rec.height);
	}
}
