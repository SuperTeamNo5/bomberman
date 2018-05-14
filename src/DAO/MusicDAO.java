package DAO;

import java.util.ArrayList;

import com.game.bomberman.model.Music;

public class MusicDAO {
	public static final String BACKGROUND_MUSIC = "/musics/start.wav";
	public static final String MAP1_MUSIC = "/musics/funnysummer.wav";

	public static final String ENTERED_MUSIC = "/musics/entered.wav";
	public static final String CLICK_MUSIC = "/musics/press.wav";
	public static final String OUT_GAME = "/musics/outgame.wav";

	public static final String BOMG_BANG = "/musics/boombang.wav";
	public static final String DEAD_BY_BOOM = "/musics/deadboom.wav";
	public static final String DETROY_MONSTER = "/musics/detroymonster.wav";
	public static final String DROP_BOOM = "/musics/dropboom.wav";
	public static final String PICK_UP_LOOT = "/musics/pickuploot.wav";

	ArrayList<Music> listMusic;
	ArrayList<Music> listSound;

	public MusicDAO() {
		listMusic = new ArrayList<Music>();
		listSound = new ArrayList<>();
		addListMusicSound();
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
			if (nameMusic.equals(listMusic.get(i))) {
				return i;
			}
		}
		return -1;
	}

	public int hasSound(String nameMusic) {
		for (int i = 0; i < listSound.size(); i++) {
			if (nameMusic.equals(listSound.get(i))) {
				return i;
			}
		}
		return -1;
	}

	// create the list musics
	public void addListMusicSound() {
		// addSound
		addSound(new Music("Music Entered", MusicDAO.ENTERED_MUSIC));
		addSound(new Music("Music Click", MusicDAO.CLICK_MUSIC));
		addSound(new Music("Music Boom Bang", MusicDAO.BOMG_BANG));
		addSound(new Music("Music Dead by boom", MusicDAO.DEAD_BY_BOOM));
		addSound(new Music("Music Detroy monster", MusicDAO.DETROY_MONSTER));
		addSound(new Music("Music Drop Boom", MusicDAO.DROP_BOOM));
		addSound(new Music("Music Pick up loot", MusicDAO.PICK_UP_LOOT));
		// add Music
		addMusic(new Music("Music Background", MusicDAO.BACKGROUND_MUSIC));
		addMusic(new Music("Music Map1", MusicDAO.MAP1_MUSIC));
		addMusic(new Music("Music Out Game", MusicDAO.OUT_GAME));
	}

	public ArrayList<Music> getListMusic() {
		return listMusic;
	}

	public ArrayList<Music> getListSound() {
		return listSound;
	}

}
