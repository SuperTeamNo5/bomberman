package com.game.bomberman.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import DAO.ImageDAO;

@SuppressWarnings("serial")
public class OnePlayerPanel extends JPanel {
	private JPanel pnlOnePlayer, pnlBtn, pnlCenter, pnlPlayerName;
	private JLabel lblBtnBack, lblBtnGo, lblTitle, lblAvatar, lblQuestionName, lblBtnPrevious, lblBtnNext;
	private BufferedImage imgIconBack, imgIconGo, imgAvatar, imgIconPrevious, imgIconNext;
	private JTextField txtName;

	public OnePlayerPanel() {
		// add(pnlView());
	}

	public JPanel pnlView() {
		
		pnlOnePlayer = new JPanel(new BorderLayout());
		lblTitle = new JLabel("Kho Kho", SwingConstants.CENTER);
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblTitle.setForeground(Color.decode("#a71111"));
		lblTitle.setBounds(285, 5, 250, 80);

		lblQuestionName = new JLabel("Your name: ");
		lblQuestionName.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblQuestionName.setForeground(Color.decode("#ee6f07"));
		lblQuestionName.setBounds(265, 275, 150, 80);

		pnlCenter = new JPanel();
		pnlCenter.setBackground(new Color(117, 117, 117, 8));
		lblAvatar = new JLabel();
		pnlPlayerName = new JPanel();
		txtName = new JTextField(10);
		txtName.setFont(new Font("Times New Roman", Font.BOLD, 25));
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.requestFocusInWindow();
		txtName.setForeground(Color.decode("#217ab5"));
		txtName.setBorder(null);
		// txtName.setBackground(new Color(117, 117, 117, 30));
		pnlPlayerName.setBounds(285, 335, 230, 40);
		pnlPlayerName.add(txtName);
		pnlPlayerName.setBackground(new Color(117, 117, 117, 45));

		pnlCenter.add(lblAvatar);
		pnlCenter.setBounds(245, 70, 300, 225);

		pnlBtn = new JPanel(new BorderLayout());
		lblBtnBack = new JLabel();
		lblBtnGo = new JLabel();
		lblBtnPrevious = new JLabel();
		lblBtnPrevious.setBounds(185, 130, 60, 75);
		lblBtnNext = new JLabel();
		lblBtnNext.setBounds(565, 130, 60, 75);
		JLabel lbl = new JLabel("");
		try {
			// buttpn go and back
			imgIconBack = ImageIO.read(getClass().getResource(ImageDAO.backIcon));
			lblBtnBack.setIcon(new ImageIcon(imgIconBack));
			imgIconGo = ImageIO.read(getClass().getResource(ImageDAO.letgoIcon));
			lblBtnGo.setIcon(new ImageIcon(imgIconGo));
			// image avatar
			imgAvatar = ImageIO.read(getClass().getResource(ImageDAO.AVATAR_KHOKHO));
			lblAvatar.setIcon(new ImageIcon(imgAvatar));
			// button next and previous
			imgIconPrevious = ImageIO.read(getClass().getResource(ImageDAO.PREVIOUS));
			lblBtnPrevious.setIcon(new ImageIcon(imgIconPrevious));
			imgIconNext = ImageIO.read(getClass().getResource(ImageDAO.NEXT));
			lblBtnNext.setIcon(new ImageIcon(imgIconNext));
		} catch (IOException e) {
			e.printStackTrace();
		}
		pnlBtn.add(lblBtnBack, BorderLayout.WEST);
		pnlBtn.add(lblBtnGo, BorderLayout.EAST);
		pnlBtn.setBounds(125, 350, 550, 250);

		pnlOnePlayer.add(pnlPlayerName);
		pnlOnePlayer.add(lblQuestionName);
		pnlOnePlayer.add(lblTitle);
		pnlOnePlayer.add(pnlBtn);
		pnlOnePlayer.add(pnlCenter);
		pnlOnePlayer.add(lblBtnNext);
		pnlOnePlayer.add(lblBtnPrevious);
		pnlOnePlayer.add(lbl);

		pnlBtn.setOpaque(false);
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

	public JLabel getLblBtnGo() {
		return lblBtnGo;
	}

	public void setLblBtnGo(JLabel lblBtnGo) {
		this.lblBtnGo = lblBtnGo;
	}

	public JTextField getTxtName() {
		return txtName;
	}

	public JLabel getLblBtnPrevious() {
		return lblBtnPrevious;
	}

	public void setLblBtnPrevious(JLabel lblBtnPrevious) {
		this.lblBtnPrevious = lblBtnPrevious;
	}

	public JLabel getLblBtnNext() {
		return lblBtnNext;
	}

	public void setLblBtnNext(JLabel lblBtnNext) {
		this.lblBtnNext = lblBtnNext;
	}

	public JLabel getLblAvatar() {
		return lblAvatar;
	}

	public void setLblAvatar(JLabel lblAvatar) {
		this.lblAvatar = lblAvatar;
	}

	public JLabel getLblTitle() {
		return lblTitle;
	}

	public void setLblTitle(JLabel lblTitle) {
		this.lblTitle = lblTitle;
	}



}
