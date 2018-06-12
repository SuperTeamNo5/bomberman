package com.game.bomberman.view;

import com.game.bomberman.controller.FrameWaitController;
import com.game.bomberman.controller.MainViewController;
import com.game.bomberman.singleton.MusicSingletonDAO;

public class Game {
	
	public static void main(String[] args) {
		MusicSingletonDAO music = MusicSingletonDAO.getInstance();
//		FrameWaitController frameWait = new FrameWaitController();
		MainView mainView = new MainView();
		new MainViewController(null, music, mainView);
	}

}
