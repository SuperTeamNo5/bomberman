package com.game.bomberman.controller;

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

import com.game.bomberman.view.OptionPanel;

import DAO.ImageDAO;
import DAO.MusicDAO;

public class OptionsController implements MouseListener {
	static int counta, countb;
	private BufferedImage bufferImage;
	private BufferedImage imgBtnOn, imgBtnOff;
	OptionPanel optionPanel;
	JFrame frame;
	JPanel pnlView;
	MainViewController mainViewController;
	MusicDAO musicDAO;

	public OptionsController(JFrame frame, MainViewController mainViewController, MusicDAO musicDAO) {
		this.frame = frame;
		this.mainViewController = mainViewController;
		this.musicDAO = musicDAO;
		optionPanel = new OptionPanel();
	}

	/*
	 * This method will set up View high score, change about abstract frame's
	 * background
	 */
	public void setUpView() {
		try {
			bufferImage = ImageIO.read(getClass().getResource(ImageDAO.BACKGROUND_OPTION));
			Image newLoaderImage = bufferImage.getScaledInstance(780, 620, java.awt.Image.SCALE_SMOOTH);
			frame.setContentPane(new JLabel(new ImageIcon(newLoaderImage)));
			pnlView = optionPanel.pnlView();
			setButtonView();
			frame.add(pnlView);
			setEventProcessing();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	public void setButtonView() {
		try {
			imgBtnOff = ImageIO.read(getClass().getResource(ImageDAO.offIcon));
			imgBtnOn = ImageIO.read(getClass().getResource(ImageDAO.onIcon));
			if (counta % 2 == 0) {
				optionPanel.getLblBtnOn1().setIcon(new ImageIcon(imgBtnOn));
			} else {
				optionPanel.getLblBtnOn1().setIcon(new ImageIcon(imgBtnOff));
			}
			if (countb % 2 == 0) {
				optionPanel.getLblBtnOn2().setIcon(new ImageIcon(imgBtnOn));
			} else {
				optionPanel.getLblBtnOn2().setIcon(new ImageIcon(imgBtnOff));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setEventProcessing() {
		optionPanel.getLblBtnBack().addMouseListener(this);
		optionPanel.getLblBtnOn1().addMouseListener(this);
		optionPanel.getLblBtnOn2().addMouseListener(this);
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
		musicDAO.getListSound().get(1).playSound(false);
		//event for button back
		if (e.getSource() == optionPanel.getLblBtnBack()) {
			pnlView.setVisible(false);
			mainViewController.setMainView(true);
			frame.repaint();
		//event for button ON/OFF sound
		} else if (e.getSource() == optionPanel.getLblBtnOn1()) {
			++counta;
			if (counta % 2 != 0) {
				System.out.println("Sound off");
				setAttributeOfLabel(ImageDAO.offIcon, optionPanel.getLblBtnOn1());
				musicDAO.getListSound().get(0).stopSound();
				musicDAO.getListSound().get(0).setOpenation(false);
				musicDAO.getListSound().get(1).stopSound();
				musicDAO.getListSound().get(1).setOpenation(false);
				for (int i = 2; i < musicDAO.getListSound().size(); i++) {
					musicDAO.getListSound().get(i).setOpenation(false);
				}
				
			} else {
				System.out.println("Sound on");
				setAttributeOfLabel(ImageDAO.onIcon, optionPanel.getLblBtnOn1());
				for (int i = 0; i < musicDAO.getListSound().size(); i++) {
					musicDAO.getListSound().get(i).setOpenation(true);
				}
			}
			frame.repaint();
			//event for button ON/OFF music
		} else if (e.getSource() == optionPanel.getLblBtnOn2()) {
			++countb;
			if (countb % 2 != 0) {
				setAttributeOfLabel(ImageDAO.offIcon, optionPanel.getLblBtnOn2());
				musicDAO.getListMusic().get(0).stopSound();
				for (int i = 1; i < musicDAO.getListMusic().size(); i++) {
					musicDAO.getListMusic().get(i).setOpenation(false);
				}
			} else {
				musicDAO.getListMusic().get(0).playSound(true);
				setAttributeOfLabel(ImageDAO.onIcon, optionPanel.getLblBtnOn2());
				for (int i = 1; i < musicDAO.getListMusic().size(); i++) {
					musicDAO.getListMusic().get(i).setOpenation(true);
				}

			}
			frame.repaint();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		musicDAO.getListSound().get(0).playSound(false);
		if (e.getSource() == optionPanel.getLblBtnBack()) {
			setAttributeOfLabel(ImageDAO.sbackIcon, optionPanel.getLblBtnBack());
			frame.repaint();
		} else if (e.getSource() == optionPanel.getLblBtnOn1()) {
		} else if (e.getSource() == optionPanel.getLblBtnOn2()) {
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == optionPanel.getLblBtnBack()) {
			setAttributeOfLabel(ImageDAO.backIcon, optionPanel.getLblBtnBack());
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
