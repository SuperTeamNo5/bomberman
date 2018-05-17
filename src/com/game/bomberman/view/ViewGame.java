package com.game.bomberman.view;

import java.awt.Graphics;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.game.bomberman.controller.Action;
import com.game.bomberman.controller.MonsAction;
import com.game.bomberman.model.Barrier;
import com.game.bomberman.model.Loot;
import com.game.bomberman.model.Map;
import com.game.bomberman.model.Monster;
import com.game.bomberman.model.Player;

import DAO.ImageDAO;

@SuppressWarnings("serial")
public class ViewGame extends JPanel implements Runnable {
	private CharactersView viewMan;

	private Action act;
	private MonsAction monsAct;

	private List<BarrierView> barView;
	private List<MonsterView> monView;
	private List<LootView> lootView;

	private Map map;

	private Thread thread;

	private boolean isRunning = false;

	public ViewGame(Map map, Action act, MonsAction monsAct) {
		this.map = map;
		this.viewMan = createViewMan();
		this.barView = createBarrierView(map.getBar());
		this.monView = createMonsterView(map.getMons());
		this.lootView = createLootView(map.getLoot());
		this.act = act;
		this.monsAct = monsAct;
		// setSize(550, 350);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		long begintime = System.nanoTime();
		dislayBackroundGame(g);
		displayLootView(g);
		displayBarrierViewDown(g);
		displayMonsterView(g);
		dislayViewMan(g);
		displayBarrierViewUp(g);
		System.out.println("Tgian: " + ((System.nanoTime() - begintime) / 1000000));
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
		System.out.println("y: " + map.getPlayer().getCharacter().getPosition().getyCoordinate());
		return new CharactersView(map.getPlayer().getCharacter());
	}

	public void displayBarrierViewUp(Graphics g) {
		for (int i = 0; i < barView.size(); i++) {
			barView.get(i).paint(g);
		}
	}

	public void displayBarrierViewDown(Graphics g) {
		for (int i = 0; i < barView.size(); i++) {
			barView.get(i).imgDown(g);
		}
	}

	public List<BarrierView> createBarrierView(List<Barrier> bar) {
		List<BarrierView> arr = new ArrayList<>();
		BarrierView barrView;
		for (int i = 0; i < bar.size(); i++) {
			barrView = new BarrierView(map.getBar().get(i));
			arr.add(barrView);
		}
		return arr;
	}

	public List<MonsterView> createMonsterView(List<Monster> mon) {
		List<MonsterView> arr = new ArrayList<>();
		MonsterView MonView;
		for (int i = 0; i < mon.size(); i++) {
			MonView = new MonsterView(mon.get(i));
			arr.add(MonView);
		}
		return arr;
	}

	public void displayMonsterView(Graphics g) {
		for (int i = 0; i < monView.size(); i++) {
			monView.get(i).paint(g);
		}
	}

	public List<LootView> createLootView(List<Loot> loot) {
		List<LootView> arr = new ArrayList<>();
		LootView lootView;
		for (int i = 0; i < loot.size(); i++) {
			lootView = new LootView(map.getLoot().get(i));
			arr.add(lootView);
		}
		return arr;
	}

	public void displayLootView(Graphics g) {
		for (int i = 0; i < lootView.size(); i++) {
			lootView.get(i).paint(g);
		}
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
			setBarView(act.getBar());
			setMonView(act.getMons());
			act.collisionPlayerVsMons();
			act.updateMap();
			monsAct.updateMons();
			setLootView(act.collisionPlayerVsLoot());
			// System.out.println("Diem cao: " + act.getPlayer().getScore());

			long deltaTime = System.nanoTime() - beginTime;
			sleepTime = period - deltaTime;
			if (act.charDead()) {
				System.out.println("End game");
				break;
			}

			try {
				// if (sleepTime > 0) {
				// Thread.sleep(sleepTime / 1000000);
				// } else {
				// Thread.sleep(period / 2000000);
				// }
				Thread.sleep(10);
			} catch (InterruptedException e) {
				beginTime = System.nanoTime();
			}

			// System.out.println("xxx");

		}

	}

	public CharactersView getViewMan() {
		return viewMan;
	}

	public void setViewMan(CharactersView viewMan) {
		this.viewMan = viewMan;
	}

	public List<BarrierView> getBarView() {
		return barView;
	}

	public void setBarView(List<Barrier> bar) {
		this.barView = createBarrierView(bar);
	}

	public List<MonsterView> getMonView() {
		return monView;
	}

	public void setMonView(List<Monster> mon) {
		this.monView = createMonsterView(mon);
	}

	public List<LootView> getLootView() {
		return lootView;
	}

	public void setLootView(List<Loot> loot) {
		this.lootView = createLootView(loot);
	}

}
