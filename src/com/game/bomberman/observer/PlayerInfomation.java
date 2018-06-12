package com.game.bomberman.observer;

import java.util.Observable;

public class PlayerInfomation extends Observable {
	private String name;
	private int score;
	private int heart;
	private int numOfSbobm;
	private int soda;
	private int numOfShoes;

	public PlayerInfomation(String name, int score, int heart, int numOfSbobm, int quantityBobm, int numOfShoes) {
		super();
		this.name = name;
		this.score = score;
		this.heart = heart;
		this.numOfSbobm = numOfSbobm;
		this.soda = quantityBobm;
		this.numOfShoes = numOfShoes;
	}

	public void meansureChanged() {
		setChanged();
		notifyObservers();
	}

	public void setMeansurement(String name, int score, int heart, int numOfSbobm, int quantityBobm, int numOfShoes) {
		this.name = name;
		this.score = score;
		this.heart = heart;
		this.numOfSbobm = numOfSbobm;
		this.soda = quantityBobm;
		this.numOfShoes = numOfShoes;
		meansureChanged();
	}

	public int getScore() {
		return score;
	}

	public int getHeart() {
		return heart;
	}

	public int getNumOfSbobm() {
		return numOfSbobm;
	}

	public int getSoda() {
		return soda;
	}

	public String getName() {
		return name;
	}

	public int getNumOfShoes() {
		return numOfShoes;
	}

}
