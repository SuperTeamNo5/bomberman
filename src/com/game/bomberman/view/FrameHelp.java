package com.game.bomberman.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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

public class FrameHelp extends JFrame {
	private JLabel lblImage;
	private JPanel pnlView;
	private JTextPane txtPane= new JTextPane();;
	JScrollPane scrollReceipt = new JScrollPane();

	public FrameHelp() {
		setLayout(new GridLayout(15, 15));
		add(view());
		setVisible(true);
		// setResizable(false);
		setLocationRelativeTo(null);
		setSize(new Dimension(450, 450));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public JScrollPane view() {
		pnlView = new JPanel();
		BufferedImage myImage;
		for (int i = 0; i <20; i++) {
			try {
				lblImage = new JLabel("sdfsdfdsf\n");
				myImage = ImageIO.read(getClass().getResource(ImageDAO.avatarImage));
				lblImage.setIcon(new ImageIcon(myImage));
				pnlView.add(lblImage);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		scrollReceipt = new JScrollPane(pnlView);
		scrollReceipt.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		return scrollReceipt;
	}

	public static void main(String[] args) {
		new FrameHelp();
	}

}
