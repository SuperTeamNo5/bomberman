package com.game.bomberman.view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.game.bomberman.controller.Action;
import com.game.bomberman.model.Map;

import DAO.ImageDAO;

@SuppressWarnings("serial")
public class ViewGame extends JPanel implements Runnable {
	private CharactersView viewMan;

	private Action act;

	private List<BarrierView> barView;

	private Map map;

	private Thread thread;

	private boolean isRunning = false;

	public ViewGame(Map map, Action act) {
		this.map = map;
		this.viewMan = createViewMan();
		this.barView = createBarrierView();
		this.act = act;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		dislayBackroundGame(g);
		// dislayBarrierViewDown(g);
		dislayViewMan(g);
		dislayBarrierViewUp(g);
		System.out.println("lap");
	}

	// display backround
	public void dislayBackroundGame(Graphics g) {
		BufferedImage img;
		try {
			img = ImageIO.read(getClass().getResource(ImageDAO.backround_game));
			g.drawImage(img, 0, 0, 950, 650, null);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	// display chacracter
	public void dislayViewMan(Graphics g) {
		viewMan.paint(g);
	}

	public CharactersView createViewMan() {
		return new CharactersView(map.getPlayer().getCharacter());
	}

	// display barrier
	public void dislayBarrierViewDown(Graphics g) {
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		for (int i = 0; i < barView.size(); i++) {
			barView.get(i).imgDown(g);
		}
		System.out.println(barView.size());
	}

	public void dislayBarrierViewUp(Graphics g) {
		for (int i = 0; i < barView.size(); i++) {
			barView.get(i).imgUp(g);
		}
	}

	public List<BarrierView> createBarrierView() {
		List<BarrierView> arr = new ArrayList<>();
		BarrierView barrView;
		for (int i = 0; i < map.getBar().size(); i++) {
			barrView = new BarrierView(map.getBar().get(i));
			arr.add(barrView);
		}
		return arr;
	}

	public void startGame() {
		if (thread == null) {
			isRunning = true;
			thread = new Thread(this);
			thread.start();
		}
	}

	@Override
	public void run() {
		long FPS = 80;// frame/s
		long period = 1000 * 1000000 / FPS;// use nanotime
		long beginTime;
		long sleepTime;

		beginTime = System.nanoTime();
		while (isRunning) {
			repaint();
			act.updateChar();
			long deltaTime = System.nanoTime() - beginTime;
			sleepTime = period - deltaTime;

			try {
				// if (sleepTime > 0) {
				// Thread.sleep(sleepTime / 1000000);
				// } else {
				// Thread.sleep(period / 2000000);
				// }
				Thread.sleep(1);
			} catch (InterruptedException e) {
				beginTime = System.nanoTime();
			}

			System.out.println("xxx");

		}

	}
}
