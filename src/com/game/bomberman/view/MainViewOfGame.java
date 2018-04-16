package com.game.bomberman.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

@SuppressWarnings("serial")
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

	public void display() {
		add(view);
	}

	public void startGame() {
		view.startGame();
	}
}
