package com.game.bomberman.controller;

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

	public RunGame(MusicDAO musicDAO) {
		Player player = new Player("Han", 0, new Characters("bongmo", "down", new Position(0, 0), new Bag(), 0, 0));

		Map map = new MapLv1(player);

//		map.getBar().remove(1);
//		map.getBar().remove(1);
//		map.getBar().remove(1);
//		map.getBar().remove(1);
//		map.getBar().remove(1);
//		map.getBar().remove(1);

		Action act = new Action(map);
		act.setMusicDAO(musicDAO);
		MonsAction monsAct = new MonsAction(map);

		ViewGame view = new ViewGame(map, act, monsAct);

		KeyBoard key = new KeyBoard(map.getPlayer().getCharacter(), act);

		MainViewOfGame game = new MainViewOfGame(view);
		game.startGame();
		game.setVisible(true);
		game.setLocationRelativeTo(null);
		game.addKeyListener(key);
	}
//
//	public static void main(String[] args) {
//		new RunGame();
//	}
}