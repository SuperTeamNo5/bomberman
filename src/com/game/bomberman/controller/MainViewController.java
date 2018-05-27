package com.game.bomberman.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.game.bomberman.view.MainView;

import DAO.ImageDAO;
import DAO.MusicDAO;

public class MainViewController implements MouseListener, WindowListener {

	FrameWaitController waitController;
	MusicDAO musicDAO;
	MainView mainView;
	MenuViewController menuViewController;
	PanelHighScoreController highScoreController;
	OnePlayerController onePlayerController;
	OptionsController twoPlayersController;

	public MainViewController() {
		waitController = new FrameWaitController();
		musicDAO = new MusicDAO();
		//run main song
		mainView = new MainView();
		musicDAO.getListMusic().get(0).playSound(true);
		highScoreController = new PanelHighScoreController(mainView, this,musicDAO);
		onePlayerController = new OnePlayerController(mainView, this,musicDAO);
		twoPlayersController = new OptionsController(mainView, this,musicDAO);
		setEventProcessing();
		menuViewController = new MenuViewController(mainView.getMenubar(), this,musicDAO);

	}
	

	// Method is use to close the game's window
	public void closing() {
		String[] buttons = { "Do it", "Never" };
		ImageIcon icon = new ImageIcon(getClass().getResource(ImageDAO.outGameImage));

		int quit = JOptionPane.showOptionDialog(null, "Close, because lose right?", "Close Bomberman ",
				JOptionPane.INFORMATION_MESSAGE, 0, icon, buttons, null);

		if (quit == 0) {
			System.exit(0);
		}
	}

	private void setEventProcessing() {
		mainView.addWindowListener(this);
		mainView.getPnlView().getLblPlayer1().addMouseListener(this);
		mainView.getPnlView().getLblPlayer2().addMouseListener(this);
		mainView.getPnlView().getLblHighScore().addMouseListener(this);
		mainView.getPnlView().getLblOption().addMouseListener(this);
		mainView.getPnlView().getLblQuit().addMouseListener(this);
	}

	public void setMainView(boolean visible) {
		if (!visible) {
			mainView.getPnlView().setVisible(false);

		} else {
			mainView.setContentPane(new JLabel(
					new ImageIcon(mainView.getMyImage().getScaledInstance(780, 620, java.awt.Image.SCALE_SMOOTH))));
			mainView.getPnlView().setVisible(true);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		musicDAO.getListSound().get(1).playSound(false);
		if (e.getSource() == mainView.getPnlView().getLblPlayer1()) {
			setMainView(false);
			onePlayerController.setUpView();

		} else if (e.getSource() == mainView.getPnlView().getLblPlayer2()) {

		} else if (e.getSource() == mainView.getPnlView().getLblHighScore()) {
			setMainView(false);
			highScoreController.setUpView();

		} else if (e.getSource() == mainView.getPnlView().getLblOption()) {
			setMainView(false);
			twoPlayersController.setUpView();

		} else if (e.getSource() == mainView.getPnlView().getLblQuit()) {
			closing();

		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		musicDAO.getListSound().get(0).playSound(false);
		if (e.getSource() == mainView.getPnlView().getLblPlayer1()) {
			mainView.getPnlView().setAttributeOfLabel(ImageDAO.splayer1Icon, mainView.getPnlView().getLblPlayer1());

		} else if (e.getSource() == mainView.getPnlView().getLblPlayer2()) {
			mainView.getPnlView().setAttributeOfLabel(ImageDAO.splayer2Icon, mainView.getPnlView().getLblPlayer2());

		} else if (e.getSource() == mainView.getPnlView().getLblHighScore()) {
			mainView.getPnlView().setAttributeOfLabel(ImageDAO.shighScoreIcon, mainView.getPnlView().getLblHighScore());

		} else if (e.getSource() == mainView.getPnlView().getLblOption()) {
			mainView.getPnlView().setAttributeOfLabel(ImageDAO.soptionIcon, mainView.getPnlView().getLblOption());

		} else if (e.getSource() == mainView.getPnlView().getLblQuit()) {
			mainView.getPnlView().setAttributeOfLabel(ImageDAO.squitIcon, mainView.getPnlView().getLblQuit());

		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == mainView.getPnlView().getLblPlayer1()) {
			mainView.getPnlView().setAttributeOfLabel(ImageDAO.player1Icon, mainView.getPnlView().getLblPlayer1());

		} else if (e.getSource() == mainView.getPnlView().getLblPlayer2()) {
			mainView.getPnlView().setAttributeOfLabel(ImageDAO.player2Icon, mainView.getPnlView().getLblPlayer2());

		} else if (e.getSource() == mainView.getPnlView().getLblHighScore()) {
			mainView.getPnlView().setAttributeOfLabel(ImageDAO.highScoreIcon, mainView.getPnlView().getLblHighScore());

		} else if (e.getSource() == mainView.getPnlView().getLblOption()) {
			mainView.getPnlView().setAttributeOfLabel(ImageDAO.optionIcon, mainView.getPnlView().getLblOption());

		} else if (e.getSource() == mainView.getPnlView().getLblQuit()) {
			mainView.getPnlView().setAttributeOfLabel(ImageDAO.quitIcon, mainView.getPnlView().getLblQuit());

		}
	}

	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}

	@Override
	public void windowActivated(WindowEvent e) {

	}

	@Override
	public void windowClosed(WindowEvent e) {

	}

	@Override
	public void windowClosing(WindowEvent e) {
		closing();

	}

	@Override
	public void windowDeactivated(WindowEvent e) {

	}

	@Override
	public void windowDeiconified(WindowEvent e) {

	}

	@Override
	public void windowIconified(WindowEvent e) {

	}

	@Override
	public void windowOpened(WindowEvent e) {

	}

	public static void main(String[] args) {
		new MainViewController();
	}

}
