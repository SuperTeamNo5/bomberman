package com.game.bomberman.Iterator;

import java.util.ArrayList;

import com.game.bomberman.model.Score;

public class HighScoreIterator implements Iterators {
	private ArrayList<Score> listScore;
	private int position;

	public HighScoreIterator(ArrayList<Score> listScore) {
		this.listScore = listScore;
	}

	@Override
	public boolean hasNext() {
		if (position >= listScore.size())
			return false;
		return true;
	}

	@Override
	public Object next() {
		return listScore.get(position++);
	}

	@Override
	public boolean remove(Score score) {
		return listScore.remove(score);
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
	

}
