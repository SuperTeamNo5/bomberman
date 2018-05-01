package com.game.bomberman.observer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfomationLabelItem {

	public InfomationLabelItem() {
		
	}

	public JPanel paints(String itemName, String pathImageItem, JLabel lblQuantityItem, JLabel lblImageItem) {
		JPanel pnl = new JPanel();

		// declare two lables, the one display image item, and the other display it's
		// quantity
		setImage(lblImageItem, pathImageItem);

		// set property
		lblQuantityItem.setForeground(Color.decode("#1d66da"));
		lblQuantityItem.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblQuantityItem.setBackground(new Color(117, 117, 117, 100));
		// lblImageItem.setBounds(0, 0, 50, 50);
		// lblQuantityItem.setBounds(0, 0, 10, 10);

		pnl.add(lblQuantityItem);
		pnl.add(lblImageItem);
		pnl.setToolTipText("Your " + itemName);
		// setBounds(0, 0, 50, 50);
		pnl.setOpaque(false);
		// revalidate();

		return pnl;
	}

	public void setImage(JLabel lblImageItem, String pathImageItem) {
		try {
			BufferedImage myImage = ImageIO.read(getClass().getResource(pathImageItem));
			Image newLoaderImage = myImage.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
			lblImageItem.setIcon(new ImageIcon(newLoaderImage));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
