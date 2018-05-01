package com.game.bomberman.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.game.bomberman.observer.InformationLabelShoesItem;
import com.game.bomberman.observer.InformationLabelSodaItem;
import com.game.bomberman.observer.InformationPanelSubject;
import com.game.bomberman.observer.InformationView;

import DAO.ImageDAO;

public class MainViewOfGame extends JFrame {
	ViewGame view;

	public MainViewOfGame(ViewGame view) {
		super();
		this.view = view;
		setSize(966, 678);
		setLayout(new BorderLayout());
		setTitle("Demo Bomer man");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		display();

	}

	public JPanel informationOnePlayerMode() {
		InformationView informationView = new InformationView();
		InformationPanelSubject ips = new InformationPanelSubject();
		InformationLabelSodaItem ilsio = new InformationLabelSodaItem(ips, informationView);
		ilsio.updateQuantityItem(2);
		InformationLabelShoesItem ilso = new InformationLabelShoesItem(ips, informationView);
		ilso.updateQuantityItem(5);
		ips.notifyObserver();
		return informationView;
	}

	public void display() {
		add(view, BorderLayout.CENTER);
		add(informationOnePlayerMode(), BorderLayout.SOUTH);
	}

	public void startGame() {
		view.startGame();
	}
}
