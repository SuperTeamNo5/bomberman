package com.game.bomberman.view;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.game.bomberman.observer.DisplayInfomation;
import com.game.bomberman.observer.DisplayView;
import com.game.bomberman.observer.PlayerInfomation;

import DAO.ImageDAO;

@SuppressWarnings("serial")
public class MainViewOfGame extends JFrame {
	private ViewGame view;
	private MenuView menuView;
	private PlayerInfomation information;

	public MainViewOfGame(ViewGame view, MenuView menuView) {
		this.view = view;
		this.menuView = menuView;
		setSize(966, 800);
		setLayout(new BorderLayout());
		setTitle("Bomberman");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		display();

	}

	public JPanel informationOnePlayerMode() {
		// new observerable
		information = new PlayerInfomation("unknow", 0, 0, 0, 0, 0);
		// create jpanel information
		DisplayInfomation displayInfor = new DisplayInfomation(information);
		DisplayView view = new DisplayView(information);
		return displayInfor;
	}

	public void display() {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			BufferedImage myImages = ImageIO.read(getClass().getResource(ImageDAO.cursorBasicIcon));

			Cursor cursor = toolkit.createCustomCursor(myImages, new Point(this.getX(), this.getY()), "img");
			setCursor(cursor);
			Image imgAvatar1 = ImageIO.read(getClass().getResource(ImageDAO.boomIcon));
			setIconImage(imgAvatar1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// change cursor icon

		add(view, BorderLayout.CENTER);
		add(informationOnePlayerMode(), BorderLayout.SOUTH);
		setJMenuBar(menuView);
	}

	public void startGame() {
		view.startGame();
	}

	public PlayerInfomation getInformation() {
		return information;
	}

	public void setInformation(PlayerInfomation information) {
		this.information = information;
	}

	public ViewGame getView() {
		return view;
	}

	public void setView(ViewGame view) {
		this.view = view;
	}

}
