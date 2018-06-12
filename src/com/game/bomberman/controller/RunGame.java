package com.game.bomberman.controller;

<<<<<<< HEAD
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
=======
import java.util.ArrayList;
import java.util.List;
>>>>>>> 5cc0dd67bbf0af59816c426aa654996b8b3b126d

import com.game.bomberman.model.Bag;
import com.game.bomberman.model.Barrier;
import com.game.bomberman.model.Boom;
import com.game.bomberman.model.Characters;
import com.game.bomberman.model.FactoryBarrier;
import com.game.bomberman.model.FactoryLoot;
import com.game.bomberman.model.FactoryMonster;
import com.game.bomberman.model.Loot;
import com.game.bomberman.model.Map;
import com.game.bomberman.model.MapLv1;
import com.game.bomberman.model.Monster;
import com.game.bomberman.model.Player;
import com.game.bomberman.model.Position;
import com.game.bomberman.model.Shoes;
import com.game.bomberman.model.Soda;
import com.game.bomberman.view.MainViewOfGame;
import com.game.bomberman.view.ViewGame;

public class RunGame {
	private static MainViewOfGame viewGame;
	private static Map map;
	private static Player player;
	private static Bag bag;
	private static ViewGame view;
	private static KeyBoard keyboard;
	private static Action act;
	private static MonsAction monsAct;
	static MainViewController mainViewController;
	private static Characters character;

<<<<<<< HEAD
	@SuppressWarnings("static-access")
	public RunGame(MainViewController mainViewController, String namePlayer, String nameCharacter) {
		this.mainViewController = mainViewController;
		newGame(namePlayer, nameCharacter);
	}

	public void newGame(String namePlayer, String nameCharacter) {
		// declare enviroment
		bag = new Bag();
		character = new Characters(nameCharacter, 3, "down", new Position(0, 0), bag, 0, 0);
		player = new Player(namePlayer, 0, character);
		checkNameCharacter(player.getCharacter().getName());
		map = new MapLv1(player);
		// action for payer
		act = new Action(map, viewGame);
		act.setMusicDAO(MainViewController.musicDAO);
		monsAct = new MonsAction(map);
		// set up view
		view = new ViewGame(map, act, monsAct);
		keyboard = new KeyBoard(map.getPlayer().getCharacter(), act);
		viewGame = new MainViewOfGame(view, MainViewController.menuViewController.menuView);
		viewGame.startGame();
		viewGame.setVisible(true);
		viewGame.setLocationRelativeTo(null);
		viewGame.addKeyListener(keyboard);
		// update loot
		updateQuantityOfLoot();
	}
=======
	public RunGame(String name, MusicDAO musicDAO) {
		Player player = new Player(name, 0, new Characters("bongmo", "down", new Position(0, 0), new Bag(), 0, 0));
>>>>>>> 5cc0dd67bbf0af59816c426aa654996b8b3b126d

	static public void closeGame() {
		viewGame.setVisible(false);
		// game.
		MainViewController.mainView.setVisible(true);
	}

	static public void loadGame(File file) {
		// close the current game view
		readFile(file);
		MainViewController.menuViewController.menuView.getMniSave().setEnabled(true);
		MainViewController.mainView.setVisible(false);
		if (viewGame == null) {
			viewGame = new MainViewOfGame(view, MainViewController.menuViewController.menuView);
		} else {
			viewGame.setVisible(false);
			viewGame = new MainViewOfGame(view, MainViewController.menuViewController.menuView);
		}

		viewGame.startGame();
		viewGame.setVisible(true);
		viewGame.setLocationRelativeTo(null);
		viewGame.addKeyListener(keyboard);
		// update loot
		updateQuantityOfLoot();
		// game.dispatchEvent(new WindowEvent(game, WindowEvent.WINDOW_CLOSING));
		// load game from file
	}

<<<<<<< HEAD
	static public void saveGame(File file) {
		try {
			PrintWriter pw = null;
			if (file.getName().endsWith(".bomb")) {
				pw = new PrintWriter(new OutputStreamWriter(
						new BufferedOutputStream(new FileOutputStream(file.getAbsoluteFile())), "UTF-8"), true);
			} else {
				pw = new PrintWriter(new OutputStreamWriter(
						new BufferedOutputStream(new FileOutputStream(file.getAbsoluteFile() + ".bomb")), "UTF-8"),
						true);
			}
			// print mode game
			pw.println(1);
			// print bag
			// print loot size
			pw.println(bag.getLootList().size());
			for (int i = 0; i < 3; i++) {
				pw.println(bag.getLootList().get(i).getName() + " " + bag.getLootList().get(i).getQuatity());
			}
			// print character information
			pw.println(character.getName());
			pw.println(character.getHeart());
			pw.println(character.getPosition().getxCoordinate() + " " + character.getPosition().getyCoordinate());
			pw.println(character.getSpeedRow());
			pw.println(character.getSpeedColumn());

			// print player information
			pw.println(player.getName());
			pw.println(player.getScore());
			// print map information
			// print list monster
			// size monster
			pw.println(map.getMons().size());
			for (int i = 0; i < map.getMons().size(); i++) {
				pw.println(map.getMons().get(i).getName() + " " + map.getMons().get(i).getPosition().getxCoordinate()
						+ " " + map.getMons().get(i).getPosition().getyCoordinate());
			}
			// print list barrier
			// size barrier
			pw.println(map.getBar().size());
			for (int i = 0; i < map.getBar().size(); i++) {
				pw.println(map.getBar().get(i).getName() + " " + map.getBar().get(i).getPosition().getxCoordinate()
						+ " " + map.getBar().get(i).getPosition().getyCoordinate());
			}
			// print list loot
			// size loot
			pw.println(map.getLoot().size());
			for (int i = 0; i < map.getLoot().size(); i++) {
				pw.println(map.getLoot().get(i).getName() + " " + map.getLoot().get(i).getPosition().getxCoordinate()
						+ " " + map.getLoot().get(i).getPosition().getyCoordinate());
			}
			pw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	static public void readFile(File file) {
		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(new BufferedInputStream(new FileInputStream(file)), "UTF-8"));
			// read information
			// read mode game
			int mode = Integer.parseInt(br.readLine());
			// read bag
			// read loot size
			int sizeLoot = Integer.parseInt(br.readLine());
			// new Bag
			bag = new Bag();
			final List<Loot> listLoot = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			// bomb
			Loot bomb = new Boom(st.nextToken(), Integer.parseInt(st.nextToken()));
			listLoot.add(bomb);
			// shoes
			st = new StringTokenizer(br.readLine(), " ");
			bomb = new Shoes(st.nextToken(), Integer.parseInt(st.nextToken()));
			listLoot.add(bomb);
			// soda
			st = new StringTokenizer(br.readLine(), " ");
			bomb = new Soda(st.nextToken(), Integer.parseInt(st.nextToken()));
			listLoot.add(bomb);
			bag.setLootList(listLoot);
			// read character information
			String characterName = br.readLine();
			int heart = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			int coordinateX = Integer.parseInt(st.nextToken());
			int coordinateY = Integer.parseInt(st.nextToken());
			int speedRow = Integer.parseInt(br.readLine());
			int speedColumn = Integer.parseInt(br.readLine());
			// new Characters
			character = new Characters(characterName, heart, "down", new Position(coordinateX, coordinateY), bag,
					speedRow, speedColumn);
			// print player information
			String playerName = br.readLine();
			int score = Integer.parseInt(br.readLine());
			// new Player
			player = new Player(playerName, score, character);
			// checkNameCharacter(player.getCharacter().getName());
			// new Map
			// load map information
			// load list monster
			// load size monster
			int sizeMonters = Integer.parseInt(br.readLine());
			final List<Monster> listMonster = new ArrayList<>();
			for (int i = 0; i < sizeMonters; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				listMonster.add(new FactoryMonster().create(st.nextToken(),
						new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))));
			}
			// load list barrier
			// load size barrier
			int sizeBarrier = Integer.parseInt(br.readLine());
			final List<Barrier> listBarrier = new ArrayList<>();
			for (int i = 0; i < sizeBarrier; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				listBarrier.add(new FactoryBarrier().createBarrier(st.nextToken(),
						new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))));
			}
			// load list loot
			// load size loot
			int sizeLootDisplay = Integer.parseInt(br.readLine());
			final List<Loot> lootDisplay = new ArrayList<>();
			for (int i = 0; i < sizeLootDisplay; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				lootDisplay.add(new FactoryLoot().create(st.nextToken(),
						new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))));
			}
			br.close();
			// set up map
			map = new Map(player) {
				@Override
				public void createMap() {
					map.setMons(listMonster);
					map.setLoot(lootDisplay);
					map.setBar(listBarrier);
				}
			};
			map.createMap();

			act = new Action(map, viewGame);
			act.setMusicDAO(MainViewController.musicDAO);
			monsAct = new MonsAction(map);
			// set up view
			view = new ViewGame(map, act, monsAct);
			keyboard = new KeyBoard(map.getPlayer().getCharacter(), act);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// this method is set up a value of quantity of character's bag
	private static void checkNameCharacter(String characterName) {
		if (characterName.equals("Kho Kho")) {

		} else if (characterName.equals("LittBoy")) {
			player.getCharacter().getBag().getLootList().get(1).setQuatity(2);
			player.getCharacter().getBag().getLootList().get(0).setQuatity(1);
			player.getCharacter().getBag().getLootList().get(2).setQuatity(1);
		} else if (characterName.equals("MushDrawf")) {
			player.getCharacter().getBag().getLootList().get(0).setQuatity(2);
			player.getCharacter().getBag().getLootList().get(1).setQuatity(1);
			player.getCharacter().getBag().getLootList().get(2).setQuatity(1);
		}
	}
=======
		// map.getBar().remove(1);
		// map.getBar().remove(1);
		// map.getBar().remove(1);
		// map.getBar().remove(1);
		// map.getBar().remove(1);
		// map.getBar().remove(1);

		Action act = new Action(map,map.getPlayer1());
		act.setMusicDAO(musicDAO);
		MonsAction monsAct = new MonsAction(map);

		List<Action> actList = new ArrayList<>();
		actList.add(act);
		ViewGame view = new ViewGame(map, actList, monsAct);

		KeyBoard key = new KeyBoard(map.getPlayer1().getCharacter(), actList);

		MainViewOfGame game = new MainViewOfGame(view);
		game.startGame();
		game.setVisible(true);
		game.setLocationRelativeTo(null);
		game.addKeyListener(key);
	}

	public RunGame(String name1, String name2, MusicDAO musicDAO) {
		Player player1 = new Player(name1, 0, new Characters("bongmo", "down", new Position(0, 0), new Bag(), 0, 0));
		Player player2 = new Player(name2, 0, new Characters("bongmo", "down", new Position(0, 0), new Bag(), 0, 0));

		Map map = new MapLv1(player1, player2);

		// map.getBar().remove(1);
		// map.getBar().remove(1);
		// map.getBar().remove(1);
		// map.getBar().remove(1);
		// map.getBar().remove(1);
		// map.getBar().remove(1);
		List<Action> actList = new ArrayList<>();
		Action act = new Action(map, map.getPlayer1());
		Action act1 = new Action(map, map.getPlayer2());
		act.setMusicDAO(musicDAO);
		act1.setMusicDAO(musicDAO);
		actList.add(act);
		actList.add(act1);
		MonsAction monsAct = new MonsAction(map);

		ViewGame view = new ViewGame(map, actList, monsAct);

		KeyBoard key = new KeyBoard(map.getPlayer1().getCharacter(),map.getPlayer2().getCharacter(), actList);
>>>>>>> 5cc0dd67bbf0af59816c426aa654996b8b3b126d

	// update quantity of loot, even include player' life
	public static void updateQuantityOfLoot() {
		viewGame.getInformation().setMeansurement(player.getName(), player.getScore(), player.getCharacter().getHeart(),
				bag.getLootList().get(0).getQuatity(), bag.getLootList().get(2).getQuatity(),
				bag.getLootList().get(1).getQuatity());
	}
<<<<<<< HEAD

=======
>>>>>>> 4465e707a0556d4b1851ce3ec7d39a8084bd77b6
}