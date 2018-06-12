package com.game.bomberman.observer;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import DAO.ImageDAO;

public class PlayerInformationPanel extends JPanel {
	private JPanel information;
	private JLabel lblMapLevel,lblName, lblScore, lblImageHeart, lblQuantityHeart, lblImageBomb, lblQuantityBomb, lblImageSoda,
			lblQuantitySoda, lblImageShoes, lblQuantityShoes;

	public PlayerInformationPanel() {
		setLayout(new FlowLayout());
		setBackground(Color.decode("#1d66da"));
		setOpaque(false);
		paints();
	}

	public void paints() {
		JPanel content = new JPanel(new FlowLayout());
		//Maplevel
		lblMapLevel = new JLabel("Map Level 1 ", SwingConstants.CENTER);
		lblMapLevel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblMapLevel.setForeground(Color.decode("#63b7e0"));
		content.add(lblMapLevel);
		// information of player
		information = new JPanel(new GridLayout(2, 1));
		lblName = new JLabel("Unknow", SwingConstants.CENTER);
		lblScore = new JLabel("Score: 0");

		lblName.setForeground(Color.decode("#d41339"));
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblName.setBackground(new Color(117, 117, 117, 100));

		lblScore.setForeground(Color.decode("#e21b7f"));
		lblScore.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblScore.setBackground(new Color(117, 117, 117, 100));

		information.add(lblName);
		information.add(lblScore);
		information.setOpaque(false);

		content.add(information);
		// heart
		lblImageHeart = new JLabel();
		lblQuantityHeart = new JLabel("0");
		content.add(paints("Live", ImageDAO.HEART_ITEM, lblQuantityHeart, lblImageHeart));
		// bobm
		lblImageBomb = new JLabel();
		lblQuantityBomb = new JLabel("0");
		content.add(paints("Bobm", ImageDAO.bomb_item, lblQuantityBomb, lblImageBomb));
		// soda
		lblImageSoda = new JLabel();
		lblQuantitySoda = new JLabel("0");
		content.add(paints("Soda", ImageDAO.soda, lblQuantitySoda, lblImageSoda));// bobm
		// shoes
		lblImageShoes = new JLabel();
		lblQuantityShoes = new JLabel("0");
		content.add(paints("Shoes", ImageDAO.shoes, lblQuantityShoes, lblImageShoes));// bobm

		add(content);
	}

	public JPanel paints(String itemName, String pathImageItem, JLabel lblQuantityItem, JLabel lblImageItem) {
		JPanel pnl = new JPanel();

		// declare two lables, the one display image item, and the other display it's
		// quantity
		setImage(lblImageItem, pathImageItem);

		// set property
		lblQuantityItem.setForeground(Color.decode("#1d66da"));
		lblQuantityItem.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblQuantityItem.setBackground(new Color(117, 117, 117, 100));

		pnl.add(lblQuantityItem);
		pnl.add(lblImageItem);
		pnl.setToolTipText("Your " + itemName);
		pnl.setOpaque(false);
		// revalidate();

		return pnl;
	}

	public void setImage(JLabel lblImageItem, String pathImageItem) {
		try {
			BufferedImage myImage = ImageIO.read(getClass().getResource(pathImageItem));
			Image newLoaderImage = myImage.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
			lblImageItem.setIcon(new ImageIcon(newLoaderImage));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public JLabel getLblName() {
		return lblName;
	}

	public void setLblName(JLabel lblName) {
		this.lblName = lblName;
	}

	public JLabel getLblScore() {
		return lblScore;
	}

	public void setLblScore(JLabel lblScore) {
		this.lblScore = lblScore;
	}

	public JLabel getLblQuantityHeart() {
		return lblQuantityHeart;
	}

	public void setLblQuantityHeart(JLabel lblQuantityHeart) {
		this.lblQuantityHeart = lblQuantityHeart;
	}

	public JLabel getLblQuantityBomb() {
		return lblQuantityBomb;
	}

	public void setLblQuantityBomb(JLabel lblQuantityBomb) {
		this.lblQuantityBomb = lblQuantityBomb;
	}

	public JLabel getLblQuantitySoda() {
		return lblQuantitySoda;
	}

	public void setLblQuantitySoda(JLabel lblQuantitySoda) {
		this.lblQuantitySoda = lblQuantitySoda;
	}

	public JLabel getLblQuantityShoes() {
		return lblQuantityShoes;
	}

	public void setLblQuantityShoes(JLabel lblQuantityShoes) {
		this.lblQuantityShoes = lblQuantityShoes;
	}

	public JLabel getLblMapLevel() {
		return lblMapLevel;
	}

	public void setLblMapLevel(JLabel lblMapLevel) {
		this.lblMapLevel = lblMapLevel;
	}


	
}
