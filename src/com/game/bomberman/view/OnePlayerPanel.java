package com.game.bomberman.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import DAO.ImageDAO;

public class OnePlayerPanel extends JPanel {
	private JPanel pnlOnePlayer, pnlBtn, pnlCenter;
	private JLabel lblName, lblBtnBack, lblBtnGo, lblTitle, lblAvatar,lblHello;
	private BufferedImage imgIconBack, imgIconGo, imgAvatar;
	private JTextField txtName;
	private Image newLoaderImage;

	public OnePlayerPanel() {
		add(pnlView());
	}

	public JPanel pnlView() {
		pnlOnePlayer = new JPanel(new BorderLayout());
		lblTitle = new JLabel("Kho Kho", SwingConstants.CENTER);
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblTitle.setForeground(Color.decode("#fd8585"));

		pnlCenter = new JPanel();
		pnlCenter.setBorder(new TitledBorder(
				javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.LEFT,
						javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.decode("#fbfbfb"))));
		lblName = new JLabel("Tell me your name:",SwingConstants.CENTER);
		lblHello = new JLabel("Hi my boss!",SwingConstants.CENTER);
		lblName.setForeground(Color.decode("#e02b2b"));
		lblAvatar = new JLabel();
		txtName = new JTextField(10);
		txtName.setBackground(null);
		txtName.setOpaque(false);
		txtName.validate();
		txtName.setForeground(Color.decode("#a71111"));
		txtName.setBorder(null);

		pnlCenter.add(lblAvatar);
		pnlCenter.add(lblHello);
		pnlCenter.add(lblName);
		pnlCenter.add(txtName);
		pnlCenter.setOpaque(false);

		pnlBtn = new JPanel(new BorderLayout());
		lblBtnBack = new JLabel();
		lblBtnGo = new JLabel();
		try {
			imgIconBack = ImageIO.read(getClass().getResource(ImageDAO.backIcon));
			lblBtnBack.setIcon(new ImageIcon(imgIconBack));

			imgIconGo = ImageIO.read(getClass().getResource(ImageDAO.letgoIconIcon));
			lblBtnGo.setIcon(new ImageIcon(imgIconGo));
			imgAvatar = ImageIO.read(getClass().getResource(ImageDAO.avatarkhokhoImage));
			newLoaderImage = imgAvatar.getScaledInstance(200, 208, java.awt.Image.SCALE_SMOOTH);
			lblAvatar.setIcon(new ImageIcon(newLoaderImage));
		} catch (IOException e) {
			e.printStackTrace();
		}
		pnlBtn.add(lblBtnBack, BorderLayout.WEST);
		pnlBtn.add(lblBtnGo, BorderLayout.EAST);
		pnlOnePlayer.add(lblTitle, BorderLayout.NORTH);
		// pnlOnePlayer.add(pnlOnePlayer, BorderLayout.CENTER);
		pnlOnePlayer.add(pnlBtn, BorderLayout.SOUTH);
		pnlOnePlayer.add(pnlCenter, BorderLayout.CENTER);

		// pnlOnePlayer.setBackground(new Color(90, 90, 90, 150));
		pnlBtn.setOpaque(false);
		pnlOnePlayer.setBackground(new Color(255, 255, 255, 10));

		return pnlOnePlayer;
	}
	
	

	public JLabel getLblBtnBack() {
		return lblBtnBack;
	}

	public void setLblBtnBack(JLabel lblBtnBack) {
		this.lblBtnBack = lblBtnBack;
	}

	public JLabel getLblBtnGo() {
		return lblBtnGo;
	}

	public void setLblBtnGo(JLabel lblBtnGo) {
		this.lblBtnGo = lblBtnGo;
	}

	public JTextField getTxtName() {
		return txtName;
	}

	public void setTxtName(JTextField txtName) {
		this.txtName = txtName;
	}

	public static void main(String[] args) {
		new OnePlayerPanel();
	}
}
