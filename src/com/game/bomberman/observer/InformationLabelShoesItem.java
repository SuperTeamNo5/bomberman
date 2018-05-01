package com.game.bomberman.observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import DAO.ImageDAO;

@SuppressWarnings("serial")
public class InformationLabelShoesItem extends JPanel implements MyObserver, DisplayObserverElement {
	private JLabel lblImageItem;
	private JLabel lblQuantityItem;
	InfomationLabelItem infomationLI;
	InformationView informationView;

	public InformationLabelShoesItem(InformationPanelSubject obs, InformationView informationView) {
		infomationLI = new InfomationLabelItem();
		obs.registerObserver(this);
		this.informationView = informationView;
		informationView.add(this);
		display();
	}

	@Override
	public void display() {
		lblImageItem = new JLabel();
		lblQuantityItem = new JLabel("0");
		add(infomationLI.paints("Shoes", ImageDAO.shoes, lblQuantityItem, lblImageItem));
	}

	@Override
	public void updateQuantityItem(int quantity) {
		lblQuantityItem.setText(quantity + "");
		
	}

	@Override
	public void updateImageItem(String pathImage) {
		infomationLI.setImage(lblImageItem, pathImage);
	}

	@Override
	public void updateNameItem(String nameItem) {
		setToolTipText("Your " + nameItem);
	}

}
