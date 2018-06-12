package com.game.bomberman.observer;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DisplayInfomation extends JPanel implements Observer {
	Observable osb;
	PlayerInformationPanel informationPanel;

	public DisplayInfomation(Observable osb) {
		osb.addObserver(this);
		this.osb = osb;
		informationPanel = new PlayerInformationPanel();
		add(informationPanel);
	}

	@Override
	public void update(Observable osb, Object o) {
		if (osb instanceof PlayerInfomation) {
			PlayerInfomation infomation = (PlayerInfomation) osb;
			informationPanel.getLblName().setText(infomation.getName());
			informationPanel.getLblScore().setText("Score: "+infomation.getScore());
			informationPanel.getLblQuantityHeart().setText(infomation.getHeart() + "");
			informationPanel.getLblQuantityBomb().setText(infomation.getNumOfSbobm() + "");
			informationPanel.getLblQuantitySoda().setText(infomation.getSoda() + "");
			informationPanel.getLblQuantityShoes().setText(infomation.getNumOfShoes() + "");
		}
	}

}
