package com.game.bomberman.controller;

import java.awt.Rectangle;
import java.util.List;

import com.game.bomberman.model.Barrier;
import com.game.bomberman.model.Loot;
import com.game.bomberman.model.Map;
import com.game.bomberman.model.Monster;
import com.game.bomberman.model.NomalMonster;

public class MonsAction {
	private List<Barrier> bar;
	private List<Loot> loot;
	private List<Monster> mons;

	public MonsAction(Map map) {
		this.bar = map.getBar();
		this.loot = map.getLoot();
		this.mons = map.getMons();
	}

	public void monsMove() {
		NomalMonster mon;
		for (int i = 0; i < mons.size(); i++) {
			if (mons.get(i).checkNomalMons(mons.get(i))) {
				mon = (NomalMonster) mons.get(i);
				Rectangle rec1 = mon.recMons();
				Rectangle rec2 = collisionPlayerAndBar(rec1);
				if (rec2 != null) {
					updateCharAfterCollision(rec1, rec2, mon);
					continue;
				}
				mon.moveARow();
				mon.moveAColumn();
			}
		}
	}

	public void updateMons() {
		monsMove();
	}

	// update char after collision
	public void updateCharAfterCollision(Rectangle rec1, Rectangle rec2, NomalMonster mon) {
		Rectangle rec3 = new Rectangle();
		rec1.intersect(rec1, rec2, rec3);
		String dir = mon.getDirectional();
		if (dir.equalsIgnoreCase("down")) {
			mon.getPosition().setyCoordinate(mon.getPosition().getyCoordinate() - rec3.height - 1);
			mon.changeDirec();
			mon.getDirec().add("down");
		}
		if (dir.equalsIgnoreCase("up")) {
			mon.getPosition().setyCoordinate(mon.getPosition().getyCoordinate() + rec3.height + 1);
			mon.changeDirec();
			mon.getDirec().add("up");
		}
		if (dir.equalsIgnoreCase("left")) {
			mon.getPosition().setxCoordinate(mon.getPosition().getxCoordinate() + rec3.width + 1);
			mon.changeDirec();
			mon.getDirec().add("left");
		}
		if (dir.equalsIgnoreCase("right")) {
			mon.getPosition().setxCoordinate(mon.getPosition().getxCoordinate() - rec3.width - 1);
			mon.changeDirec();
			mon.getDirec().add("right");
		}
		// }
	}

	// test collision with bar
	public Rectangle collisionPlayerAndBar(Rectangle rec1) {
		Rectangle rec2, rec3;
		for (int i = 0; i < bar.size(); i++) {
			rec2 = new Rectangle(bar.get(i).getPosition().getxCoordinate(), bar.get(i).getPosition().getyCoordinate(),
					bar.get(i).getWidth(), bar.get(i).getHeight() - 30);
			if (i < loot.size() && loot.get(i).getName().equalsIgnoreCase("bomb")) {
				rec3 = new Rectangle(loot.get(i).getPositon().getxCoordinate() + 10,
						loot.get(i).getPositon().getyCoordinate() + 10, 30, 30);
				if (rec1.intersects(rec3)) {
					return rec3;
				}
			}
			if (rec1.intersects(rec2)) {
				return rec2;
			}

		}
		return null;
	}
}
