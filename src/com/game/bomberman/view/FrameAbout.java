package com.game.bomberman.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

import DAO.ImageDAO;

@SuppressWarnings("serial")
public class FrameAbout extends JFrame{
private JLabel labelImage;
private JPanel panelView;
private Image newLoaderImage;
JScrollPane scrollReceipt = new JScrollPane();

public FrameAbout() {
	add(view());
	setTitle("About Us");
	setSize(new Dimension(780, 475));
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
}

public JPanel view() {
	panelView = new JPanel();
	BufferedImage myImage;
		try {
			myImage = ImageIO.read(getClass().getResource(ImageDAO.BACKGROUND_ABOUT));
			newLoaderImage = myImage.getScaledInstance(780, 439, java.awt.Image.SCALE_SMOOTH);
			labelImage = new JLabel();
			labelImage.setIcon(new ImageIcon(newLoaderImage));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	panelView.add(labelImage);
	return panelView;
}

}


