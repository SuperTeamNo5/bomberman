package com.game.bomberman.controller;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.game.bomberman.view.OnePlayerPanel;

import DAO.ImageDAO;
import DAO.MusicDAO;

public class OnePlayerController implements MouseListener {
	OnePlayerPanel playerPanel;
	JFrame frame;
	JPanel pnlView;
	MainViewController mainViewController;
	private BufferedImage bufferImage;

	public OnePlayerController(JFrame frame, MainViewController mainViewController) {
		this.frame = frame;
		this.mainViewController = mainViewController;
		playerPanel = new OnePlayerPanel();
	}

	/*
	 * This method will set up View high score, change about abstract frame's
	 * background
	 */
	public void setUpView() {
		try {
			bufferImage = ImageIO.read(getClass().getResource(ImageDAO.backgroundOnePlayer));
			Image newLoaderImage = bufferImage.getScaledInstance(780, 620, java.awt.Image.SCALE_SMOOTH);
			frame.setContentPane(new JLabel(new ImageIcon(newLoaderImage)));
			pnlView = playerPanel.pnlView();
			frame.add(pnlView, BorderLayout.CENTER);
			setEventProcessing();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	public void setEventProcessing() {
		playerPanel.getLblBtnBack().addMouseListener(this);
		playerPanel.getLblBtnGo().addMouseListener(this);
	}

	public void setAttributeOfLabel(String imgIcon, JLabel lblItem) {
		try {
			BufferedImage myImage = ImageIO.read(getClass().getResource(imgIcon));
			lblItem.setIcon(new ImageIcon(myImage));
			lblItem.setBackground(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == playerPanel.getLblBtnBack()) {
			pnlView.setVisible(false);
			mainViewController.playSounds(MusicDAO.pressMusic, false);
			mainViewController.setMainView(true);
			frame.repaint();
		} else if (e.getSource() == playerPanel.getLblBtnGo()) {
			pnlView.setVisible(false);
			mainViewController.playSounds(MusicDAO.pressMusic, false);
			// mainViewController.setMainView(true);
			frame.repaint();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == playerPanel.getLblBtnBack()) {
			setAttributeOfLabel(ImageDAO.sbackIcon, playerPanel.getLblBtnBack());
			mainViewController.playSounds(MusicDAO.enteredMusic, false);
			frame.repaint();
		} else if (e.getSource() == playerPanel.getLblBtnGo()) {
			setAttributeOfLabel(ImageDAO.sletgoIcon, playerPanel.getLblBtnGo());
			mainViewController.playSounds(MusicDAO.enteredMusic, false);
			frame.repaint();
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == playerPanel.getLblBtnBack()) {
			setAttributeOfLabel(ImageDAO.backIcon, playerPanel.getLblBtnBack());
			frame.repaint();
		} else if (e.getSource() == playerPanel.getLblBtnGo()) {
			setAttributeOfLabel(ImageDAO.letgoIconIcon, playerPanel.getLblBtnGo());
			frame.repaint();

		}

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

}