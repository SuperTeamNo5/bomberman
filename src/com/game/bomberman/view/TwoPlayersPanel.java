package com.game.bomberman.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
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
public class TwoPlayersPanel extends JPanel {
	private JPanel pnlOnePlayer, pnlBtn, pnlCenter1,pnlCenter2, pnlPlayerName1,pnlPlayerName2;
	private JLabel lblBtnBack, lblBtnGo, lblTitle1,lblTitle2, lblAvatar1, lblQuestionName1,lblQuestionName2, lblBtnPrevious1, lblBtnNext1,lblBtnPrevious2, lblBtnNext2;
	private BufferedImage imgIconBack, imgIconGo, imgAvatar1, imgIconPrevious1, imgIconNext1, imgIconPrevious2,
			imgIconNext2;
	private JTextField txtNamePlayer1, txtNamePlayer2;

	public TwoPlayersPanel() {
		// add(pnlView());
	}

	public JPanel pnlView() {
		//player 1
		pnlOnePlayer = new JPanel(new BorderLayout());
		lblTitle1 = new JLabel("Kho Kho", SwingConstants.CENTER);
		lblTitle1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblTitle1.setForeground(Color.decode("#a71111"));
		lblTitle1.setBounds(150, 5, 250, 80);

		lblQuestionName1 = new JLabel("Your name: ");
		lblQuestionName1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblQuestionName1.setForeground(Color.decode("#ee6f07"));
		lblQuestionName1.setBounds(130, 275, 150, 80);

		pnlCenter1 = new JPanel();
		pnlCenter1.setBackground(new Color(117, 117, 117, 8));
		lblAvatar1 = new JLabel();
		pnlPlayerName1 = new JPanel();
		txtNamePlayer1 = new JTextField(10);
		txtNamePlayer1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		txtNamePlayer1.setHorizontalAlignment(SwingConstants.CENTER);
		txtNamePlayer1.requestFocusInWindow();
		txtNamePlayer1.setForeground(Color.decode("#217ab5"));
		txtNamePlayer1.setBorder(null);
		// txtName.setBackground(new Color(117, 117, 117, 30));
		pnlPlayerName1.setBounds(150, 335, 230, 40);
		pnlPlayerName1.add(txtNamePlayer1);
		pnlPlayerName1.setBackground(new Color(117, 117, 117, 45));

		pnlCenter1.add(lblAvatar1);
		pnlCenter1.setBounds(115, 70, 300, 225);

		pnlBtn = new JPanel(new BorderLayout());
		lblBtnBack = new JLabel();
		lblBtnGo = new JLabel();
		lblBtnPrevious1 = new JLabel();
		lblBtnPrevious1.setBounds(55, 130, 60, 75);
		lblBtnNext1 = new JLabel();
		lblBtnNext1.setBounds(435, 130, 60, 75);
		JLabel lbl = new JLabel("");
		try {
			// buttpn go and back
			imgIconBack = ImageIO.read(getClass().getResource(ImageDAO.backIcon));
			lblBtnBack.setIcon(new ImageIcon(imgIconBack));
			imgIconGo = ImageIO.read(getClass().getResource(ImageDAO.letgoIcon));
			lblBtnGo.setIcon(new ImageIcon(imgIconGo));
			// image avatar
			imgAvatar1 = ImageIO.read(getClass().getResource(ImageDAO.AVATAR_KHOKHO));
			lblAvatar1.setIcon(new ImageIcon(imgAvatar1));
			// button next and previous
			imgIconPrevious1 = ImageIO.read(getClass().getResource(ImageDAO.PREVIOUS));
			lblBtnPrevious1.setIcon(new ImageIcon(imgIconPrevious1));
			
			imgIconNext1 = ImageIO.read(getClass().getResource(ImageDAO.NEXT));
			lblBtnNext1.setIcon(new ImageIcon(imgIconNext1));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//player 2
		lblTitle2 = new JLabel("Kho Kho", SwingConstants.CENTER);
		lblTitle2.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblTitle2.setForeground(Color.decode("#a71111"));
		lblTitle2.setBounds(285, 5, 250, 80);

		lblQuestionName2 = new JLabel("Your name: ");
		lblQuestionName2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblQuestionName2.setForeground(Color.decode("#ee6f07"));
		lblQuestionName2.setBounds(265, 275, 150, 80);

		pnlCenter1 = new JPanel();
		pnlCenter1.setBackground(new Color(117, 117, 117, 8));
		lblAvatar1 = new JLabel();
		pnlPlayerName1 = new JPanel();
		txtNamePlayer1 = new JTextField(10);
		txtNamePlayer1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		txtNamePlayer1.setHorizontalAlignment(SwingConstants.CENTER);
		txtNamePlayer1.requestFocusInWindow();
		txtNamePlayer1.setForeground(Color.decode("#217ab5"));
		txtNamePlayer1.setBorder(null);
		// txtName.setBackground(new Color(117, 117, 117, 30));
		pnlPlayerName1.setBounds(285, 335, 230, 40);
		pnlPlayerName1.add(txtNamePlayer1);
		pnlPlayerName1.setBackground(new Color(117, 117, 117, 45));

		pnlCenter1.add(lblAvatar1);
		pnlCenter1.setBounds(245, 70, 300, 225);

		pnlBtn = new JPanel(new BorderLayout());
		lblBtnBack = new JLabel();
		lblBtnGo = new JLabel();
		lblBtnPrevious1 = new JLabel();
		lblBtnPrevious1.setBounds(185, 130, 60, 75);
		lblBtnNext1 = new JLabel();
		lblBtnNext1.setBounds(565, 130, 60, 75);
		try {
			// buttpn go and back
			imgIconBack = ImageIO.read(getClass().getResource(ImageDAO.backIcon));
			lblBtnBack.setIcon(new ImageIcon(imgIconBack));
			imgIconGo = ImageIO.read(getClass().getResource(ImageDAO.letgoIcon));
			lblBtnGo.setIcon(new ImageIcon(imgIconGo));
			// image avatar
			imgAvatar1 = ImageIO.read(getClass().getResource(ImageDAO.AVATAR_KHOKHO));
			lblAvatar1.setIcon(new ImageIcon(imgAvatar1));
			// button next and previous
			imgIconPrevious1 = ImageIO.read(getClass().getResource(ImageDAO.PREVIOUS));
			lblBtnPrevious1.setIcon(new ImageIcon(imgIconPrevious1));
			imgIconPrevious1 = ImageIO.read(getClass().getResource(ImageDAO.NEXT));
			lblBtnNext1.setIcon(new ImageIcon(imgIconNext1));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//button
		pnlBtn.add(lblBtnBack, BorderLayout.WEST);
		pnlBtn.add(lblBtnGo, BorderLayout.EAST);
		pnlBtn.setBounds(125, 350, 550, 250);
		
		pnlOnePlayer.add(pnlPlayerName1);
		pnlOnePlayer.add(lblQuestionName1);
		pnlOnePlayer.add(lblTitle1);
		pnlOnePlayer.add(pnlBtn);
		pnlOnePlayer.add(pnlCenter1);
		pnlOnePlayer.add(lblBtnNext1);
		pnlOnePlayer.add(lblBtnPrevious1);
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

	public JTextField getTxtNamePlayer1() {
		return txtNamePlayer1;
	}

	public JLabel getLblBtnPrevious1() {
		return lblBtnPrevious1;
	}

	public void setLblBtnPrevious1(JLabel lblBtnPrevious1) {
		this.lblBtnPrevious1 = lblBtnPrevious1;
	}

	public JLabel getLblBtnNext1() {
		return lblBtnNext1;
	}

	public void setLblBtnNext1(JLabel lblBtnNext1) {
		this.lblBtnNext1 = lblBtnNext1;
	}

	public JLabel getLblAvatar1() {
		return lblAvatar1;
	}

	public void setLblAvatar1(JLabel lblAvatar) {
		this.lblAvatar1 = lblAvatar;
	}

	public JLabel getLblTitle1() {
		return lblTitle1;
	}

	public void setLblTitle1(JLabel lblTitle1) {
		this.lblTitle1 = lblTitle1;
	}

}
