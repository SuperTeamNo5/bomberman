package com.game.bomberman.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.game.bomberman.view.FrameHelp;
import com.game.bomberman.view.MenuView;

import DAO.MusicDAO;

public class MenuViewController implements ActionListener {
	MenuView menuView;
	MainViewController mainViewController;
	MusicDAO musicDAO;
	FrameHelp frameHelp;
	JFrame jframe;

	public MenuViewController(MenuView menuView, MainViewController mainViewController, MusicDAO musicDAO) {
		this.mainViewController = mainViewController;
		this.menuView = menuView;
		this.musicDAO = musicDAO;
		setEventProcessing();
		frameHelp = new FrameHelp();
		jframe = new JFrame("Choose file load game");
	}

	private void setEventProcessing() {

		menuView.getMniExit().addActionListener(this);
		menuView.getMniLoad().addActionListener(this);
		menuView.getmniInforAuhor().addActionListener(this);
		menuView.getMniHelp().addActionListener(this);

		menuView.getMniExit().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		menuView.getMniLoad().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
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

	@Override
	public void actionPerformed(ActionEvent e) {
		musicDAO.getListSound().get(1).playSound(false);
		if (e.getSource() == menuView.getMniExit()) {
			mainViewController.closing();

		} else if (e.getSource() == menuView.getMniLoad()) {
			File fileChoosen = chooseFile();
			if (fileChoosen != null) {
				System.out.println(fileChoosen.getAbsolutePath());
			} else {
				System.out.println("no choose");
			}

		} else if (e.getSource() == menuView.getmniInforAuhor()) {
			if (!frameHelp.isVisible()) {
				frameHelp.setVisible(true);
			}
		} else if (e.getSource() == menuView.getMniHelp()) {
			if (!frameHelp.isVisible()) {
				frameHelp.setVisible(true);
			}
		}

	}

}
