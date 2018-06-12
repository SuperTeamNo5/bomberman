package com.game.bomberman.singleton;

import java.util.ArrayList;

import com.game.bomberman.model.Music;

public class MusicSingletonDAO {
	private static final String BACKGROUND_MUSIC = "/musics/start.wav";
	private static final String MAP1_MUSIC = "/musics/funnysummer.wav";

	private static final String ENTERED_MUSIC = "/musics/entered.wav";
	private static final String CLICK_MUSIC = "/musics/press.wav";
	private static final String OUT_GAME = "/musics/outgame.wav";

	private static final String BOMG_BANG = "/musics/boombang.wav";
	private static final String DEAD_BY_BOOM = "/musics/deadboom.wav";
	private static final String DETROY_MONSTER = "/musics/detroymonster.wav";
	private static final String DROP_BOOM = "/musics/dropboom.wav";
	private static final String PICK_UP_LOOT = "/musics/pickuploot.wav";
	private static volatile MusicSingletonDAO musicSingleton;

	private ArrayList<Music> listMusic;
	private ArrayList<Music> listSound;

	private MusicSingletonDAO() {
		listMusic = new ArrayList<Music>();
		listSound = new ArrayList<Music>();
		addListMusicSound();
	}

	public static MusicSingletonDAO getInstance() {
		if (musicSingleton == null) {
			synchronized (MusicSingletonDAO.class) {
				if (musicSingleton == null) {
					musicSingleton = new MusicSingletonDAO();
					return musicSingleton;
				}
			}
		}
		return musicSingleton;
	}

	// add a music
	public void addMusic(Music music) {
		listMusic.add(music);
	}

	public void addSound(Music music) {
		listSound.add(music);
	}

	// remove a music
	public void removeMusic(Music music) {
		listMusic.remove(music);
	}

	public void removeSound(Music music) {
		listMusic.remove(music);
	}

	// check for exist from a parameter's music, and return a value
	// if the value return a number equal -1, the music is not exist
	public int hasMusic(String nameMusic) {
		for (int i = 0; i < listMusic.size(); i++) {
			if (nameMusic.equals(listMusic.get(i).getName())) {
				return i;
			}
		}
		return -1;
	}

	public int hasSound(String nameMusic) {
		for (int i = 0; i < listSound.size(); i++) {
			if (nameMusic.equals(listSound.get(i).getName())) {
				return i;
			}
		}
		return -1;
	}

	// create the list musics
	private void addListMusicSound() {
		// addSound
		addSound(new Music("Music Entered", MusicSingletonDAO.ENTERED_MUSIC));// 0
		addSound(new Music("Music Click", MusicSingletonDAO.CLICK_MUSIC));// 1
		addSound(new Music("Music Boom Bang", MusicSingletonDAO.BOMG_BANG));// 2
		addSound(new Music("Music Dead by boom", MusicSingletonDAO.DEAD_BY_BOOM));// 3
		addSound(new Music("Music Detroy monster", MusicSingletonDAO.DETROY_MONSTER));// 4
		addSound(new Music("Music Drop Boom", MusicSingletonDAO.DROP_BOOM));// 5
		addSound(new Music("Music Pick up loot", MusicSingletonDAO.PICK_UP_LOOT));// 6
		listSound.get(0).setVolume(-12f);
		listSound.get(1).setVolume(-12f);
		// add Music
		addMusic(new Music("Music Background", MusicSingletonDAO.BACKGROUND_MUSIC));// 0
		addMusic(new Music("Music Map1", MusicSingletonDAO.MAP1_MUSIC));// 1
		addMusic(new Music("Music Out Game", MusicSingletonDAO.OUT_GAME));// 2
		listMusic.get(0).setVolume(-12f);
		listMusic.get(1).setVolume(-12f);
	}

	public ArrayList<Music> getListMusic() {
		return listMusic;
	}

	public ArrayList<Music> getListSound() {
		return listSound;
	}

}
