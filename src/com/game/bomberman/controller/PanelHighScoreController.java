package com.game.bomberman.controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.game.bomberman.Iterator.HighScore;
import com.game.bomberman.Iterator.Iterators;
import com.game.bomberman.model.Score;
import com.game.bomberman.singleton.MusicSingletonDAO;
import com.game.bomberman.view.HighScorePanel;

import DAO.ImageDAO;

public class PanelHighScoreController implements MouseListener {
	private BufferedImage bufferImage;
	private PrintWriter printWriter;
	HighScorePanel guiHighScore;
	JFrame frame;
	JPanel pnlView;
	MainViewController mainViewController;
	Iterators iterator;
	MusicSingletonDAO musicDAO;
	HighScore highScore;

	public PanelHighScoreController(JFrame frame, MainViewController mainViewController, MusicSingletonDAO musicDAO) {
		this.frame = frame;
		this.mainViewController = mainViewController;
		this.musicDAO = musicDAO;
		highScore = new HighScore();
		iterator = highScore.createIterator();
		guiHighScore = new HighScorePanel();
//		high.addHighScore(new Score("Nguyễn Tâm", 15000));
//		writeScore();
//		high.loadDataScore();
	}

	public void setEventProcessing() {
		guiHighScore.getLblBtnBack().addMouseListener(this);
	}

	/*
	 * This method will set up View high score, change about abstract frame's
	 * background
	 */
	public void setUpView() {
		try {
			bufferImage = ImageIO.read(getClass().getResource(ImageDAO.BACKGROUND_HIGHSCORE));
			Image newLoaderImage = bufferImage.getScaledInstance(780, 620, java.awt.Image.SCALE_SMOOTH);
			frame.setContentPane(new JLabel(new ImageIcon(newLoaderImage)));
			pnlView = guiHighScore.pnlView();
			frame.add(pnlView, BorderLayout.CENTER);
			printHighScore();
			setEventProcessing();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	// write highscore in file score
	public void writeScore() {
		try {
			// open file
			printWriter = new PrintWriter(
					new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream("highscore.score"))), true);
			// write content
			while (iterator.hasNext()) {
				Score score = (Score) iterator.next();
				printWriter.println(score.getName() + "\t" + score.getScore());
			}
			// close file
			printWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * This method will print 10 high score, and display them in the screen
	 */
	public void printHighScore() {
		int i = 0;
		highScore.loadDataScore();
		while (iterator.getPosition() < 10 && iterator.hasNext()) {
			Score score = (Score) iterator.next();
			guiHighScore.setLblNumber(new JLabel("", SwingConstants.CENTER));
			guiHighScore.getLblNumber().setFont(new Font("Times New Roman", Font.BOLD, 23));
			guiHighScore.getLblNumber().setForeground(new Color(255, 255, 255));
			guiHighScore.getLblNumber().setText("" + (i + 1));
			guiHighScore.getPnlHighScore().add(guiHighScore.getLblNumber());

			guiHighScore.setLblName((new JLabel()));
			guiHighScore.getLblName().setFont(new Font("Times New Roman", Font.BOLD, 23));
			guiHighScore.getLblName().setForeground(new Color(255, 255, 255));
			guiHighScore.getLblName().setText(score.getName());
			guiHighScore.getPnlHighScore().add(guiHighScore.getLblName());

			guiHighScore.setLblScore((new JLabel("", SwingConstants.CENTER)));
			guiHighScore.getLblScore().setFont(new Font("Times New Roman", Font.BOLD, 23));
			guiHighScore.getLblScore().setForeground(new Color(255, 255, 255));
			guiHighScore.getLblScore().setText(score.getScore() + "");
			guiHighScore.getPnlHighScore().add(guiHighScore.getLblScore());
			i++;
		}
		iterator.setPosition(0);
	}

	public void setAttributeOfLabel(String imgIcon, JLabel lblItem) {
		try {
			BufferedImage myImage = ImageIO.read(getClass().getResource(imgIcon));
			lblItem.setIcon(new ImageIcon(myImage));
			lblItem.setBackground(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		pnlView.setVisible(false);
		musicDAO.getListSound().get(1).playSound(false);
		mainViewController.setMainView(true);
		frame.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		setAttributeOfLabel(ImageDAO.sbackIcon, guiHighScore.getLblBtnBack());
		musicDAO.getListSound().get(0).playSound(false);
		frame.repaint();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setAttributeOfLabel(ImageDAO.backIcon, guiHighScore.getLblBtnBack());
		frame.repaint();

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

}
