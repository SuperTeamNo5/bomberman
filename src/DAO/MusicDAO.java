package DAO;

import java.util.ArrayList;

import com.game.bomberman.model.Music;

public class MusicDAO {
	public static final String backgroundMusic = "/musics/start.wav";
	public static final String enteredMusic = "/musics/entered.wav";
	public static final String pressMusic = "/musics/press.wav";
	public static final String outGame = "/musics/outgame.wav";
	public static final String MAP1_MUSIC = "/musics/funnysummer.wav";

	ArrayList<Music> listMusic;

	public MusicDAO() {
		listMusic = new ArrayList<Music>();
	}

	// add a music
	public void add(Music music) {
		listMusic.add(music);
	}

	// remove a music
	public void remove(Music music) {
		listMusic.remove(music);
	}

	// check for exist from a parameter's music, and return a value
	// if the value return a number equal -1, the music is not exist
	public int has(String nameMusic) {
		for (int i = 0; i < listMusic.size(); i++) {
			if (listMusic.get(i).equals(nameMusic)) {
				return i;
			}
		}
		return -1;
	}

	public ArrayList<Music> getListMusic() {
		return listMusic;
	}

}
