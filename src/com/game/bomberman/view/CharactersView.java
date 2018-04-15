package com.game.bomberman.view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.game.bomberman.model.Characters;

import DAO.ImageDAO;

public class CharactersView extends JPanel {
	private Characters characters;
	private BufferedImage img;

	public CharactersView(Characters characters) {
		super();
		this.characters = characters;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		image(g);
	}

	public void image(Graphics g) {
		switch (characters.getName()) {
		case "bongmo":
			if (characters.getDirectional().equalsIgnoreCase("down")) {
				try {
					img = ImageIO.read(getClass().getResource(ImageDAO.bomber_down));
					g.drawImage(img, characters.getPosition().getxCoordinate(),
							characters.getPosition().getyCoordinate(), characters.getWidth(), characters.getHeight(),
							null);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (characters.getDirectional().equalsIgnoreCase("up")) {
				try {
					img = ImageIO.read(getClass().getResource(ImageDAO.bomber_up));
					g.drawImage(img, characters.getPosition().getxCoordinate(),
							characters.getPosition().getyCoordinate(), characters.getWidth(), characters.getHeight(),
							null);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (characters.getDirectional().equalsIgnoreCase("left")) {
				try {
					img = ImageIO.read(getClass().getResource(ImageDAO.bomber_left));
					g.drawImage(img, characters.getPosition().getxCoordinate(),
							characters.getPosition().getyCoordinate(), characters.getWidth(), characters.getHeight(),
							null);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (characters.getDirectional().equalsIgnoreCase("right")) {
				try {
					img = ImageIO.read(getClass().getResource(ImageDAO.bomber_right));
					g.drawImage(img, characters.getPosition().getxCoordinate(),
							characters.getPosition().getyCoordinate(), characters.getWidth(), characters.getHeight(),
							null);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			break;

		default:
			break;
		}
	}
}
