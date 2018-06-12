package com.game.bomberman.Iterator;

import com.game.bomberman.model.Score;

public interface Iterators {
	boolean hasNext();

	boolean remove(Score score);

	Object next();

	int getPosition();
	void setPosition(int position);

}
