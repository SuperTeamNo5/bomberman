package com.game.bomberman.controller;

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
	
	

	public OnePlayerController(JFrame frame, MainViewController mainViewController) {
		this.frame = frame;
		this.mainViewController = mainViewController;
		pnlView = new OnePlayerPanel();
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
		pnlView.setVisible(false);
		mainViewController.playSounds(MusicDAO.pressMusic, false);
		mainViewController.setMainView(true);
		frame.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		setAttributeOfLabel(ImageDAO.sbackIcon, playerPanel.getLblBtnBack());
		mainViewController.playSounds(MusicDAO.enteredMusic, false);
		frame.repaint();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setAttributeOfLabel(ImageDAO.backIcon, playerPanel.getLblBtnBack());
		frame.repaint();

	}
	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

}
