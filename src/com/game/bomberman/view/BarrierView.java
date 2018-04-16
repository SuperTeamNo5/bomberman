package com.game.bomberman.view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.game.bomberman.model.Barrier;

import DAO.ImageDAO;

public class BarrierView extends JPanel {
	private Barrier bar;
	private BufferedImage img;

	public BarrierView(Barrier bar) {
		this.bar = bar;
	}

	public void imgDown(Graphics g) {
		switch (bar.getName()) {
		case "barrel":
			try {
				img = ImageIO.read(getClass().getResource(ImageDAO.box1));
				g.drawImage(img, bar.getPosition().getxCoordinate(), bar.getPosition().getyCoordinate(), bar.getWidth(),
						bar.getHeight(), null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "wall":
			try {
				img = ImageIO.read(getClass().getResource(ImageDAO.box2));
				g.drawImage(img, bar.getPosition().getxCoordinate(), bar.getPosition().getyCoordinate(), bar.getWidth(),
						bar.getHeight(), null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		default:
			break;
		}
	}

	public void imgUp(Graphics g) {
		switch (bar.getName()) {
		case "barrel":
			try {
				img = ImageIO.read(getClass().getResource(ImageDAO.box11));
				g.drawImage(img, bar.getPosition().getxCoordinate(), bar.getPosition().getyCoordinate() - 15,
						bar.getWidth(), 15, null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "wall":
			try {
				img = ImageIO.read(getClass().getResource(ImageDAO.box22));
				g.drawImage(img, bar.getPosition().getxCoordinate(), bar.getPosition().getyCoordinate() - 5,
						bar.getWidth(), 5, null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		default:
			break;
		}
	}

}
