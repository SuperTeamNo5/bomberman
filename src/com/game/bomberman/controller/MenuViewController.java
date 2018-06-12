package com.game.bomberman.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.game.bomberman.singleton.MusicSingletonDAO;
import com.game.bomberman.view.FrameAbout;
import com.game.bomberman.view.FrameHelp;
import com.game.bomberman.view.MenuView;

import DAO.ImageDAO;

public class MenuViewController implements ActionListener {
	MenuView menuView;
	MainViewController mainViewController;
	MusicSingletonDAO musicDAO;
	FrameHelp frameHelp;
	JFrame jframe;
	FrameAbout frameAbout;

	public MenuViewController(MenuView menuView, MainViewController mainViewController, MusicSingletonDAO musicDAO) {
		this.mainViewController = mainViewController;
		this.menuView = menuView;
		this.musicDAO = musicDAO;
		setEventProcessing();
		frameHelp = new FrameHelp();
		frameAbout = new FrameAbout();
		jframe = new JFrame("Choose file load game");
	}

	private void setEventProcessing() {
		menuView.getMniExit().addActionListener(this);
		menuView.getMniBack().addActionListener(this);
		menuView.getMniLoad().addActionListener(this);
		menuView.getMniSave().addActionListener(this);
		menuView.getmniInforAuhor().addActionListener(this);
		menuView.getMniHelp().addActionListener(this);

		menuView.getMniExit().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		menuView.getMniBack().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
		menuView.getMniLoad().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
		menuView.getMniSave().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		menuView.getmniInforAuhor().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
	}

	public File chooseFile() {
		JFileChooser chooser = new JFileChooser();
		File transferFile = null;
		FileNameExtensionFilter filter = new FileNameExtensionFilter("bombb", "bomb");
		chooser.setFileFilter(filter);
		chooser.showOpenDialog(jframe);
		transferFile = chooser.getSelectedFile();
		return transferFile;
	}

	public File saveFile() {
		JFileChooser chooser = new JFileChooser();
		File transferFile = null;
		FileNameExtensionFilter filter = new FileNameExtensionFilter("bombb", "bomb");
		chooser.setFileFilter(filter);
		chooser.showSaveDialog(jframe);
		transferFile = chooser.getSelectedFile();
		return transferFile;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		musicDAO.getListSound().get(1).playSound(false);
		if (e.getSource() == menuView.getMniExit()) {
			mainViewController.closing();

		} else if (e.getSource() == menuView.getMniLoad()) {
			File fileChoosen = chooseFile();
			if (fileChoosen != null) {
				musicDAO.getListMusic().get(0).stopSound();
				RunGame.loadGame(fileChoosen);
				if (musicDAO.getListMusic().get(1).clip != null && musicDAO.getListMusic().get(1).checkPlaySound()) {
					musicDAO.getListMusic().get(1).stopSound();
				}
				musicDAO.getListMusic().get(1).playSound(true);
			} else {
				System.out.println("no choose");
			}

		} else if (e.getSource() == menuView.getmniInforAuhor()) {
			if (!frameAbout.isVisible()) {
				frameAbout.setVisible(true);
			}

		} else if (e.getSource() == menuView.getMniHelp()) {
			if (!frameHelp.isVisible()) {
				frameHelp.setVisible(true);
			}
		} else if (e.getSource() == menuView.getMniSave()) {
			File fileChoosen = saveFile();
			if (fileChoosen != null) {
				RunGame.saveGame(fileChoosen);
				System.out.println(fileChoosen.getAbsolutePath());
			} else {
				System.out.println("no choose");
			}

		} else if (e.getSource() == menuView.getMniBack()) {
			if (warning("Do you want to close game?", "Really?") == 0) {
				RunGame.closeGame();
			} else {

			}
		}

	}

	public int warning(String title, String content) {
		String[] buttons = { "Okay", "Never" };
		ImageIcon icon = new ImageIcon((getClass().getResource(ImageDAO.avatarImage)));

		int select = JOptionPane.showOptionDialog(null, content, title, JOptionPane.WARNING_MESSAGE, 0, icon, buttons,
				null);

		return select;
	}

}
