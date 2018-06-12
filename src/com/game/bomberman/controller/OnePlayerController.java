package com.game.bomberman.controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.game.bomberman.singleton.MusicSingletonDAO;
import com.game.bomberman.view.OnePlayerPanel;

import DAO.ImageDAO;

public class OnePlayerController implements MouseListener {
	OnePlayerPanel playerPanel;
	JFrame frame;
	JPanel pnlView;
	MainViewController mainViewController;
	private BufferedImage bufferImage;
	RunGame gameView;
	MusicSingletonDAO musicDAO;
	private int currentPointer = 0;
	private ArrayList<Character> listPlayer;
	BufferedImage imgAvatar;

	public OnePlayerController(JFrame frame, MainViewController mainViewController, MusicSingletonDAO musicDAO) {
		this.frame = frame;
		this.mainViewController = mainViewController;
		this.musicDAO = musicDAO;
		playerPanel = new OnePlayerPanel();
		listPlayer = new ArrayList<>();
		listCharacter();
	}

	class Character {
		String name, pathImage;

		public Character(String name, String pathImage) {
			this.name = name;
			this.pathImage = pathImage;
		}

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
		playerPanel.getLblBtnNext().addMouseListener(this);
		playerPanel.getLblBtnPrevious().addMouseListener(this);
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
		if (e.getSource() == playerPanel.getLblBtnBack()) {
			pnlView.setVisible(false);
			mainViewController.setMainView(true);
			frame.repaint();
		} else if (e.getSource() == playerPanel.getLblBtnGo()) {
<<<<<<< HEAD
			if (playerPanel.getTxtName().getText().equals("") || playerPanel.getTxtName().getText().equals(null)) {
				warning("Fill infomation", "Hey, fill your name plz!", ImageDAO.avatarImage);
			} else if (playerPanel.getTxtName().getText().length() > 13) {
				warning("Swear!!!", "Hey, fill your SHORT name plz!", ImageDAO.avatarImage);
			} else {
				musicDAO.getListMusic().get(0).stopSound();
				frame.setVisible(false);
				gameView = new RunGame(mainViewController, playerPanel.getTxtName().getText(),
						playerPanel.getLblTitle().getText());
				musicDAO.getListMusic().get(1).playSound(true);
				MainViewController.menuViewController.menuView.getMniSave().setEnabled(true);
				MainViewController.menuViewController.menuView.getMniBack().setEnabled(true);
			}
=======
			musicDAO.getListMusic().get(0).stopSound();
			musicDAO.getListMusic().get(1).playSound(true);
			frame.setVisible(false);
			String name = playerPanel.getTxtName().getText();
			gameView = new RunGame("han","shika", musicDAO);
			System.out.println("Ten nv: "+name);
>>>>>>> 5cc0dd67bbf0af59816c426aa654996b8b3b126d
			// frame.repaint();
		} else if (e.getSource() == playerPanel.getLblBtnPrevious()) {
			displayPrevious();
		} else if (e.getSource() == playerPanel.getLblBtnNext()) {
			displayNext();
		}
	}

	public void warning(String title, String content, String image) {
		String[] buttons = { "Okay" };
		ImageIcon icon = new ImageIcon((getClass().getResource(image)));

		JOptionPane.showOptionDialog(null, content, title, JOptionPane.INFORMATION_MESSAGE, 0, icon, buttons, null);
	}

	public void listCharacter() {
		listPlayer.add(new Character("Kho Kho", ImageDAO.AVATAR_KHOKHO));
		listPlayer.add(new Character("LittBoy", ImageDAO.AVATAR_LITTOBY));
		listPlayer.add(new Character("MushDrawf", ImageDAO.AVATAR_MUSHDRAWF));
	}

	public void displayNext() {
		if (currentPointer >= listPlayer.size() - 1) {
			currentPointer = 0;
			displayAvatar();
		} else {
			++currentPointer;
			displayAvatar();
		}
	}

	public void displayAvatar() {
		try {
			imgAvatar = ImageIO.read(getClass().getResource(listPlayer.get(currentPointer).pathImage));
			playerPanel.getLblAvatar().setIcon(new ImageIcon(imgAvatar));
			playerPanel.getLblTitle().setText(listPlayer.get(currentPointer).name);
			if (currentPointer == 0) {
				playerPanel.getLblTitle().setForeground(Color.decode("#a71111"));
			} else if (currentPointer == 1) {
				playerPanel.getLblTitle().setForeground(Color.decode("#0f6504"));
			} else {
				playerPanel.getLblTitle().setForeground(Color.decode("#d50d70"));
			}
			frame.repaint();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void displayPrevious() {
		if (currentPointer <= 0) {
			currentPointer = listPlayer.size() - 1;
			displayAvatar();
		} else {
			--currentPointer;
			displayAvatar();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		musicDAO.getListSound().get(0).playSound(false);
		if (e.getSource() == playerPanel.getLblBtnBack()) {
			setAttributeOfLabel(ImageDAO.sbackIcon, playerPanel.getLblBtnBack());
			frame.repaint();
		} else if (e.getSource() == playerPanel.getLblBtnGo()) {
			setAttributeOfLabel(ImageDAO.sletgoIcon, playerPanel.getLblBtnGo());
			frame.repaint();
		} else if (e.getSource() == playerPanel.getLblBtnPrevious()) {
			setAttributeOfLabel(ImageDAO.SHADOW_PREVIOUS, playerPanel.getLblBtnPrevious());
			frame.repaint();
		} else if (e.getSource() == playerPanel.getLblBtnNext()) {
			setAttributeOfLabel(ImageDAO.SHADOW_NEXT, playerPanel.getLblBtnNext());
			frame.repaint();
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == playerPanel.getLblBtnPrevious()) {
			setAttributeOfLabel(ImageDAO.PREVIOUS, playerPanel.getLblBtnPrevious());
			frame.repaint();
		} else if (e.getSource() == playerPanel.getLblBtnNext()) {
			setAttributeOfLabel(ImageDAO.NEXT, playerPanel.getLblBtnNext());
			frame.repaint();

		} else if (e.getSource() == playerPanel.getLblBtnBack()) {
			setAttributeOfLabel(ImageDAO.backIcon, playerPanel.getLblBtnBack());
			frame.repaint();
		} else if (e.getSource() == playerPanel.getLblBtnGo()) {
			setAttributeOfLabel(ImageDAO.letgoIcon, playerPanel.getLblBtnGo());
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
