package com.game.bomberman.Iterator;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

import com.game.bomberman.model.Score;

public class HighScore implements Scores {
	private ArrayList<Score> listScore;
	private BufferedReader buffReader;
	private StringTokenizer sToken;

	// constructor
	public HighScore() {
		listScore = new ArrayList<>();
		loadDataScore();
		sortHighScore();
	}

	// get listScore
	public ArrayList<Score> getDataScore() {
		return listScore;
	}

	// set listScore
	public void setDataScore(ArrayList<Score> listScore) {
		this.listScore = listScore;
	}

	// load high score
	public void loadDataScore() {
		try {
			// read file
			buffReader = new BufferedReader(
					new InputStreamReader(new BufferedInputStream(new FileInputStream("highscore.score")), "UTF-8"));
			String line;
			while ((line = buffReader.readLine()) != null) {
				// content separated by tab
				sToken = new StringTokenizer(line, "\t");
				listScore.add(new Score(sToken.nextToken(), Integer.parseInt(sToken.nextToken())));
			}
			// close file
			buffReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// add score fromt player
	public void addHighScore(Score score) {
		listScore.add(score);
		sortHighScore();
	}

	// sort score become high score
	public void sortHighScore() {
		// Sorting
		Collections.sort(listScore, new Comparator<Score>() {
			@Override
			public int compare(Score score1, Score score2) {
				return score2.getScore() - score1.getScore();
			}
		});

	}

	// create iterator
	@Override
	public Iterators createIterator() {
		return new HighScoreIterator(listScore);
	}

}
