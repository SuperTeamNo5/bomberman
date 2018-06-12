package com.game.bomberman.observer;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class DisplayView extends JFrame implements Observer {
	private JLabel lbl;

	public DisplayView(Observable osb) {
		osb.addObserver(this);
		setSize(250,250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		lbl = new JLabel("fdf");
		add(lbl);
		setVisible(true);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof PlayerInfomation) {
			PlayerInfomation information = (PlayerInfomation) o;
			lbl.setText(information.getName() + ", " + information.getHeart()+ ", " + information.getScore());
		}
	}
}
