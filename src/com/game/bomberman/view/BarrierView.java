package com.game.bomberman.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.game.bomberman.model.Barrier;

import DAO.ImageDAO;

public class BarrierView extends JPanel {
	private Barrier bar;
	private Image img;
	private String name;

	public BarrierView(Barrier bar) {
		this.bar = bar;
		this.name = bar.getName();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		try {
			imgUp(g);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void imgDown(Graphics g) {
		switch (name) {
		case "barrel":
			img = new ImageIcon(getClass().getResource(ImageDAO.box2)).getImage();
			g.drawImage(img, bar.getPosition().getxCoordinate(), bar.getPosition().getyCoordinate(), bar.getWidth(),
					bar.getHeight(), null);
			break;
		case "wall":
			img = new ImageIcon(getClass().getResource(ImageDAO.box1)).getImage();
			g.drawImage(img, bar.getPosition().getxCoordinate(), bar.getPosition().getyCoordinate(), bar.getWidth(),
					bar.getHeight(), null);
			break;

		default:
			break;
		}
	}

	public void imgUp(Graphics g) throws IOException {
		switch (name) {
		case "barrel":
			img = new ImageIcon(getClass().getResource(ImageDAO.box22)).getImage();
			g.drawImage(img, bar.getPosition().getxCoordinate(), bar.getPosition().getyCoordinate() - 5,
					bar.getWidth(), 5, null);
			break;
		case "wall":
			img = new ImageIcon(getClass().getResource(ImageDAO.box11)).getImage();
			g.drawImage(img, bar.getPosition().getxCoordinate(), bar.getPosition().getyCoordinate() - 15, bar.getWidth(),
					15, null);
			break;

		default:
			break;
		}
	}

}
