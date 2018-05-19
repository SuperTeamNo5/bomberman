package com.game.bomberman.view;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import DAO.ImageDAO;

@SuppressWarnings("serial")
public class FrameHelp extends JFrame {
	private BufferedImage bfImage;
	private Image newImage;
	private Image imgAvatar1;

	public FrameHelp() {

		setDisplay();
		createGUI();
	}

	private void setDisplay() {
		// icon of application
		try {
			imgAvatar1 = ImageIO.read(getClass().getResource(ImageDAO.boomIcon));
			setIconImage(imgAvatar1);
			setSize(new Dimension(780, 515));
			setTitle("Help");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setLocationRelativeTo(null);
			setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void createGUI() {
		add(createTabbedPane());
	}

	private JTabbedPane createTabbedPane() {

		JTabbedPane tabbedPane = new JTabbedPane();
		JPanel pnlContentGame = new JPanel();
		JPanel pnlContentItem = new JPanel();
		JPanel pnlContentCharacter = new JPanel();
		JPanel pnlContentMonster = new JPanel();

		tabbedPane.addTab("Game", makeIcon(ImageDAO.GAME_ICON), content(pnlContentGame, ImageDAO.BACKGROUND_HELP),
				"Introduce Bomberman game");
		tabbedPane.addTab("Items", makeIcon(ImageDAO.ITEM_ICON), content(pnlContentItem, ImageDAO.BACKGROUND_ITEM),
				"Introduce Bomberman Items");
		tabbedPane.addTab("Charaters", makeIcon(ImageDAO.CHARACTER_ICON),
				content(pnlContentCharacter, ImageDAO.BACKGROUND_CHARACTER), "Introduce Bomberman Charaters");
		tabbedPane.addTab("Monsters", makeIcon(ImageDAO.MONSTER_ICON),
				content(pnlContentMonster, ImageDAO.BACKGROUND_MONSTER), "Introduce Bomberman Monsters");

		return tabbedPane;
	}

	public ImageIcon makeIcon(String icon) {
		BufferedImage bfImageIcon = null;
		try {
			bfImageIcon = ImageIO.read(getClass().getResource(icon));
			// newImage = bfImage.getScaledInstance(780, 620, java.awt.Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ImageIcon(bfImageIcon);
	}

	// This method is use to create content to tabbed parts
	public JPanel content(JPanel pnlContent, String image) {
		JLabel lblImage = new JLabel();
		try {
			bfImage = ImageIO.read(getClass().getResource(image));
			newImage = bfImage.getScaledInstance(780, 439, java.awt.Image.SCALE_SMOOTH);
			lblImage.setIcon(new ImageIcon(newImage));
		} catch (IOException e) {
			e.printStackTrace();
		}

		pnlContent.add(lblImage);// label nội dung nằm giữa
		return pnlContent;
	}

	public static void main(String[] args) {
		new FrameHelp();
	}

}