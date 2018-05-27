package com.game.bomberman.controller;

import java.util.ArrayList;
import java.util.List;

import com.game.bomberman.model.Bag;
import com.game.bomberman.model.Characters;
import com.game.bomberman.model.Map;
import com.game.bomberman.model.MapLv1;
import com.game.bomberman.model.Player;
import com.game.bomberman.model.Position;
import com.game.bomberman.view.MainViewOfGame;
import com.game.bomberman.view.ViewGame;

import DAO.MusicDAO;

public class RunGame {

	public RunGame(String name, MusicDAO musicDAO) {
		Player player = new Player(name, 0, new Characters("bongmo", "down", new Position(0, 0), new Bag(), 0, 0));

		Map map = new MapLv1(player);

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

		MainViewOfGame game = new MainViewOfGame(view);
		game.startGame();
		game.setVisible(true);
		game.setLocationRelativeTo(null);
		game.addKeyListener(key);
	}
<<<<<<< HEAD

=======
>>>>>>> 4465e707a0556d4b1851ce3ec7d39a8084bd77b6
}