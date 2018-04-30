package com.game.bomberman.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.game.bomberman.controller.PanelHighScoreController;

import DAO.ImageDAO;

@SuppressWarnings("serial")
public class HighScorePanel extends JPanel {
	private JPanel pnlHighScore, pnlView, pnlBtnBack;
	private JLabel lblNumber, lblName, lblScore, lblBtnBack, lblTitle;
	private BufferedImage imgIconBack;

	public HighScorePanel() {
//		add(pnlView());
	}

	/*
	 * This method will display high score in the HighScore view, include top 10
	 * player's high score
	 */
	public JPanel pnlView() {

		pnlView = new JPanel(new BorderLayout());
		pnlHighScore = new JPanel(new GridLayout(10, 3));
		pnlBtnBack = new JPanel(new FlowLayout());
		lblTitle = new JLabel("High Score", SwingConstants.CENTER);
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblTitle.setForeground(Color.decode("#fd8585"));

		lblBtnBack = new JLabel();
		try {
			imgIconBack = ImageIO.read(getClass().getResource(ImageDAO.backIcon));
			lblBtnBack.setIcon(new ImageIcon(imgIconBack));
		} catch (IOException e) {
			e.printStackTrace();
		}
		pnlBtnBack.add(lblBtnBack);
		pnlView.add(lblTitle, BorderLayout.NORTH);
		pnlView.add(pnlHighScore, BorderLayout.CENTER);
		pnlView.add(pnlBtnBack, BorderLayout.SOUTH);

		pnlHighScore.setBackground(new Color(90, 90, 90, 150));
		pnlBtnBack.setOpaque(false);
		pnlView.setBackground(new Color(255, 255, 255, 10));
		pnlView.setBounds(75, 60, 630, 450);
		return pnlView;

	}

	public JLabel getLblNumber() {
		return lblNumber;
	}

	public void setLblNumber(JLabel lblNumber) {
		this.lblNumber = lblNumber;
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

	public JLabel getLblBtnBack() {
		return lblBtnBack;
	}

	public void setLblBtnBack(JLabel lblBtnBack) {
		this.lblBtnBack = lblBtnBack;
	}

	public JPanel getPnlHighScore() {
		return pnlHighScore;
	}

	public void setPnlHighScore(JPanel pnlHighScore) {
		this.pnlHighScore = pnlHighScore;
	}
	

}
