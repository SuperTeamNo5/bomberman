package com.game.bomberman.observer;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class InformationView extends JPanel {
	JLabel name, score;
	JPanel information;

	public InformationView() {
		setLayout(new FlowLayout());
		setBackground(Color.decode("#1d66da"));
		setOpaque(false);
		paints();
	}

	// @Override
	// public void paint(Graphics g) {
	// BufferedImage img;
	// try {
	// img = ImageIO.read(getClass().getResource(ImageDAO.backround_game));
	// g.drawImage(img, 0, 0, 950, 650, null);
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }

	public void paints() {
		information = new JPanel(new GridLayout(2, 1));
		name = new JLabel("1P: Hallo", SwingConstants.CENTER);
		score = new JLabel("Score: 15000");

		name.setForeground(Color.decode("#d41339"));
		name.setFont(new Font("Times New Roman", Font.BOLD, 17));
		name.setBackground(new Color(117, 117, 117, 100));

		score.setForeground(Color.decode("#e21b7f"));
		score.setFont(new Font("Times New Roman", Font.BOLD, 15));
		score.setBackground(new Color(117, 117, 117, 100));

		information.add(name);
		information.add(score);
		information.setOpaque(false);

		add(information);
	}

}
