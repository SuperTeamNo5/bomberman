package com.game.bomberman.model;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Music {
	private String name;
	private String path;
	private AudioInputStream audioIn;
	public Clip clip;
	private boolean openation = true;
	private float volume = 0f;
	private FloatControl control;

	public Music(String name, String path) {
		super();
		this.name = name;
		this.path = path;
	}

	// This method play the sound
	public void playSound(boolean loop) {
		if (openation == true) {
			try {
				audioIn = AudioSystem.getAudioInputStream(getClass().getResource(path));
				clip = AudioSystem.getClip();
				clip.open(audioIn);
				control = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

			} catch (Exception e) {
				e.printStackTrace();
			}

			if (volume != 0f) {
				control.setValue(volume);
			}

			clip.start();
			if (loop) {// if loop is true, the sound will be loop
				clip.loop(Clip.LOOP_CONTINUOUSLY);
			}
		}

	}

	// This method check sound on
	public boolean checkPlaySound() {
		return clip.isOpen();
	}

	// This method stop the sound
	public void stopSound() {
		clip.stop();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setOpenation(boolean openation) {
		this.openation = openation;
	}

	public void setVolume(float volume) {
		this.volume = volume;
	}

}
