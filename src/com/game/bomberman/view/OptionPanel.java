package com.game.bomberman.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import DAO.ImageDAO;

public class OptionPanel extends JFrame {
	private JPanel pnlOnePlayer;
	private JLabel lblBtnBack, lblSound, lblMusic, lblTitle, lblBtnOn1, lblBtnOn2, lblTemp;
	private BufferedImage imgIconBack, img1, img2;
	private Image newLoaderImage;

	public JPanel pnlView() {
		pnlOnePlayer = new JPanel();
		pnlOnePlayer.setLayout(new BorderLayout());

		try {
			lblTitle = new JLabel();
			img1 = ImageIO.read(getClass().getResource(ImageDAO.OPTION_IMAGE));
			newLoaderImage = img1.getScaledInstance(150, 45, java.awt.Image.SCALE_SMOOTH);
			lblTitle.setIcon(new ImageIcon(newLoaderImage));
			lblTitle.setBounds(325, 20, 150, 45);
			pnlOnePlayer.add(lblTitle);

			lblSound = new JLabel();
			img1 = ImageIO.read(getClass().getResource(ImageDAO.SOUND_IMAGE));
			newLoaderImage = img1.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
			lblSound.setIcon(new ImageIcon(newLoaderImage));
			lblSound.setBounds(140, 100, 200, 200);
			pnlOnePlayer.add(lblSound);

			lblBtnOn1 = new JLabel();
			lblBtnOn1.setBounds(360, 180, 83, 56);
			pnlOnePlayer.add(lblBtnOn1);

			lblMusic = new JLabel();
			img2 = ImageIO.read(getClass().getResource(ImageDAO.MUSIC_IMAGE));
			newLoaderImage = img2.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
			lblMusic.setIcon(new ImageIcon(newLoaderImage));
			lblMusic.setBounds(240, 300, 150, 150);
			pnlOnePlayer.add(lblMusic);

			lblBtnOn2 = new JLabel();
			
			lblBtnOn2.setBounds(410, 345, 83, 56);
			pnlOnePlayer.add(lblBtnOn2);
			//
			lblBtnBack = new JLabel();
			imgIconBack = ImageIO.read(getClass().getResource(ImageDAO.backIcon));
			lblBtnBack.setIcon(new ImageIcon(imgIconBack));
			lblBtnBack.setBounds(325, 480, 130, 68);
			pnlOnePlayer.add(lblBtnBack);

			lblTemp = new JLabel();
			pnlOnePlayer.add(lblTemp);
		} catch (IOException e) {
			e.printStackTrace();
		}

		pnlOnePlayer.setOpaque(false);
		pnlOnePlayer.setBounds(0, 0, 780, 620);
		return pnlOnePlayer;
	}

	public JLabel getLblBtnBack() {
		return lblBtnBack;
	}

	public void setLblBtnBack(JLabel lblBtnBack) {
		this.lblBtnBack = lblBtnBack;
	}

	public JLabel getLblBtnOn1() {
		return lblBtnOn1;
	}

	public void setLblBtnOn1(JLabel lblBtnOn1) {
		this.lblBtnOn1 = lblBtnOn1;
	}

	public JLabel getLblBtnOn2() {
		return lblBtnOn2;
	}

	public void setLblBtnOn2(JLabel lblBtnOn2) {
		this.lblBtnOn2 = lblBtnOn2;
	}


}
