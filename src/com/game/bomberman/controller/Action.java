package com.game.bomberman.controller;

import java.awt.Rectangle;
import java.util.List;

import com.game.bomberman.model.Barrier;
import com.game.bomberman.model.Boom;
import com.game.bomberman.model.Characters;
import com.game.bomberman.model.Loot;
import com.game.bomberman.model.Map;
import com.game.bomberman.model.Monster;
import com.game.bomberman.model.Player;
import com.game.bomberman.model.Position;
import com.game.bomberman.view.ViewGame;

import DAO.MusicDAO;

// including methods action for game
public class Action {
	private Player player;
	private List<Barrier> bar;
	private List<Loot> loot;
	private List<Monster> mons;
	private Map map;
	private ViewGame view;
	MusicDAO musicDAO;
	
	public MusicDAO getMusicDAO() {
		return musicDAO;
	}

	public void setMusicDAO(MusicDAO musicDAO) {
		this.musicDAO = musicDAO;
	}

	public Action(Map map) {
		this.map = map;
		this.player = map.getPlayer();
		this.bar = map.getBar();
		this.loot = map.getLoot();
		this.mons = map.getMons();
	}

	// test man dead
	public boolean charDead() {
		return player.getCharacter().isDead();
	}

	// update character
	public void updateChar() {
		if (collisionPlayerAndBar() != null) {
			player.getCharacter().setSpeedColumn(0);
			player.getCharacter().setSpeedRow(0);
			System.out.println("vao");
			updateCharAfterCollision();
			return;
		}
		if (player.getCharacter().isCollisionVsBomb()) {
			return;
		}
		player.getCharacter().moveARow();
		player.getCharacter().moveAColumn();
		// System.out.println(player.getCharacter().getSpeedColumn());
	}

	// update char after collision
	public void updateCharAfterCollision() {
		Rectangle rec1 = player.getCharacter().recPlayer();
		Rectangle rec2 = collisionPlayerAndBar();
		Rectangle rec3 = new Rectangle();
		// if (rec2 != null) {
		rec1.intersect(rec1, rec2, rec3);
		String dir = player.getCharacter().getDirectional();
		if (dir.equalsIgnoreCase("down")) {
			player.getCharacter().getPosition()
					.setyCoordinate(player.getCharacter().getPosition().getyCoordinate() - rec3.height - 1);
		}
		if (dir.equalsIgnoreCase("up")) {
			player.getCharacter().getPosition()
					.setyCoordinate(player.getCharacter().getPosition().getyCoordinate() + rec3.height + 1);
		}
		if (dir.equalsIgnoreCase("left")) {
			player.getCharacter().getPosition()
					.setxCoordinate(player.getCharacter().getPosition().getxCoordinate() + rec3.width + 1);
		}
		if (dir.equalsIgnoreCase("right")) {
			player.getCharacter().getPosition()
					.setxCoordinate(player.getCharacter().getPosition().getxCoordinate() - rec3.width - 1);
		}
		// }
	}

	// test collision with bar
	public Rectangle collisionPlayerAndBar() {
		Rectangle rec1 = player.getCharacter().recPlayer();
		Rectangle rec2, rec3;
		for (int i = 0; i < bar.size(); i++) {
			rec2 = new Rectangle(bar.get(i).getPosition().getxCoordinate(), bar.get(i).getPosition().getyCoordinate(),
					bar.get(i).getWidth(), bar.get(i).getHeight() - 20);
			if (player.getCharacter().collision(rec1, rec2)) {
				// System.out.println("va cham");
				return rec2;
			}
		}
		return null;
	}

	// dat bomb
	public void dropBomb() {
		Characters chara = player.getCharacter();
		int x = chara.getPosition().getxCoordinate() + chara.getWidth() / 2;
		int y = chara.getPosition().getyCoordinate() + chara.getHeight() / 2;
		// int x = chara.getPosition().getxCoordinate();
		// int y = chara.getPosition().getyCoordinate();
		if (chara.getBag().search("bombItem").getQuatity() > 0) {
			musicDAO.getListSound().get(5).playSound(false);
			Loot bomb = new Boom("bomb", new Position((x / 50) * 50, (y / 50) * 50), 500);
			loot.add(bomb);
			chara.getBag().search("bombItem").setQuatity(chara.getBag().search("bombItem").getQuatity() - 1);
		}
		// map.setLoot(loot);

	}

	// collision with loot and pick up items
	public List<Loot> collisionPlayerVsLoot() {
		Rectangle rec1 = player.getCharacter().recPlayer();
		Rectangle rec2;
		// dropBomb();
		for (int i = 0; i < loot.size(); i++) {
			if (loot.get(i).getName().equalsIgnoreCase("bomb") || loot.get(i).getName().equalsIgnoreCase("bombang")) {
				if (loot.get(i).getName().equalsIgnoreCase("bombang")) {
					Boom bomb = (Boom) loot.get(i);
					setSizeBomb(bomb);
					bombangvsBox(bomb);
					bombangvsMonsVsBomber(bomb);
				}
			} else {
				rec2 = new Rectangle(loot.get(i).getPositon().getxCoordinate() + 10,
						loot.get(i).getPositon().getyCoordinate() + 10, 15, 15);
				// System.out.println(player.getCharacter().collision(rec1,
				// rec2));
				if (player.getCharacter().collision(rec1, rec2)) {
					// System.out.println("va cham vs loot");
					musicDAO.getListSound().get(6).playSound(false);
					player.getCharacter().getBag().add(loot.get(i));
					loot.remove(i);
					map.setLoot(loot);
					return loot;
				}
			}
		}
		return loot;
	}

	// collision with monster
	public void collisionPlayerVsMons() {
		Rectangle rec1 = player.getCharacter().recPlayer();
		Rectangle rec2;
		for (int i = 0; i < mons.size(); i++) {
			Monster mon = mons.get(i);
			rec2 = new Rectangle(mon.getPosition().getxCoordinate(), mon.getPosition().getyCoordinate(), 45, 55);
			if (player.getCharacter().collision(rec1, rec2)) {
				musicDAO.getListSound().get(3).playSound(false);
				player.getCharacter().dead();
				// System.out.println("xxxxxxxxxxxx: " +
				// player.getCharacter().isDead());

			}
		}
	}

	public void updateMap() {
		Boom lo;
		Characters chara = player.getCharacter();
		for (int i = 0; i < loot.size(); i++) {
			if (loot.get(i).getName().equalsIgnoreCase("bomb")) {
				lo = (Boom) loot.get(i);
				lo.setDeadLine(lo.getDeadLine() - 1);
				if (lo.getDeadLine() <= 15) {
					lo.setName("bombang");
				}
			} else {
				if (loot.get(i).getName().equalsIgnoreCase("bombang")) {
					lo = (Boom) loot.get(i);
					if (boomBang(lo) == true) {
						loot.remove(i);
						chara.getBag().search("bombItem")
								.setQuatity(chara.getBag().search("bombItem").getQuatity() + 1);
					}
				}
			}
		}
	}

	public boolean boomBang(Boom bomb) {
		if (bomb.getDeadLine() == 0) {
			return true;
		}
		bomb.setDeadLine(bomb.getDeadLine() - 1);
		return false;
	}

	public void bombangvsBox(Boom bomb) {
		// setSizeBomb(bomb);
		Rectangle rec_right = new Rectangle(bomb.getPositon().getxCoordinate(), bomb.getPositon().getyCoordinate(),
				45 + 45 * bomb.getBombang_right(), 45);
		Rectangle rec_left = new Rectangle(bomb.getPositon().getxCoordinate() - (45 * bomb.getBombang_left()),
				bomb.getPositon().getyCoordinate(), 45 + 45 * bomb.getBombang_left(), 45);
		Rectangle rec_down = new Rectangle(bomb.getPositon().getxCoordinate(), bomb.getPositon().getyCoordinate(), 45,
				45 + 45 * bomb.getBombang_down());
		Rectangle rec_up = new Rectangle(bomb.getPositon().getxCoordinate(),
				bomb.getPositon().getyCoordinate() - (45 * bomb.getBombang_up()), 45, 45 + 45 * bomb.getBombang_up());
		for (int i = 0; i < bar.size(); i++) {
			Barrier barrier = bar.get(i);
			Rectangle rec_Box = new Rectangle(barrier.getPosition().getxCoordinate(),
					barrier.getPosition().getyCoordinate(), 50, 50);
			if (rec_Box.intersects(rec_up) || rec_Box.intersects(rec_down) || rec_Box.intersects(rec_left)
					|| rec_Box.intersects(rec_right)) {
				if (bar.get(i).isCanDestroy()) {
					bar.remove(i);
				}
			}
			// if (rec_Box.intersects(rec_up)) {
			// if (bar.get(i).isCanDestroy()) {
			// int size = (rec_up.height - (rec_Box.y - rec_up.y)) / 50;
			// bomb.setBombang_up(size);
			// bar.remove(i);
			// }
			// }
			// if (rec_Box.intersects(rec_down)) {
			// if (bar.get(i).isCanDestroy()) {
			// int size = (rec_Box.y - rec_down.y) / 50;
			// bomb.setBombang_down(size);
			// bar.remove(i);
			// }
			// }
			// if (rec_Box.intersects(rec_right)) {
			// if (bar.get(i).isCanDestroy()) {
			// int size = ((rec_Box.x - rec_right.x)) / 50;
			// bomb.setBombang_right(size);
			//// rec_right.
			// bar.remove(i);
			// }
			// }
			// if (rec_Box.intersects(rec_left)) {
			// if (bar.get(i).isCanDestroy()) {
			// int size = (rec_left.width - (rec_Box.x - rec_left.x)) / 50;
			// bomb.setBombang_left(size);
			// bar.remove(i);
			// }
			// }
		}
	}

	public void bombangvsMonsVsBomber(Boom bomb) {
		Rectangle rec_right = new Rectangle(bomb.getPositon().getxCoordinate(), bomb.getPositon().getyCoordinate(),
				45 + 45 * bomb.getBombang_right(), 45);
		Rectangle rec_left = new Rectangle(bomb.getPositon().getxCoordinate() - 45, bomb.getPositon().getyCoordinate(),
				45 + 45 * bomb.getBombang_left(), 45);
		Rectangle rec_down = new Rectangle(bomb.getPositon().getxCoordinate(), bomb.getPositon().getyCoordinate(), 45,
				45 + 45 * bomb.getBombang_down());
		Rectangle rec_up = new Rectangle(bomb.getPositon().getxCoordinate(), bomb.getPositon().getyCoordinate() - 45,
				45, 45 + 45 * bomb.getBombang_up());
		for (int i = 0; i < mons.size(); i++) {
			Monster mon = mons.get(i);
			Rectangle rec_Mons = new Rectangle(mon.getPosition().getxCoordinate(), mon.getPosition().getyCoordinate(),
					45, 55);
			if (rec_Mons.intersects(rec_up) || rec_Mons.intersects(rec_down) || rec_Mons.intersects(rec_left)
					|| rec_Mons.intersects(rec_right)) {
				mons.remove(i);
				player.setScore(player.getScore() + 10);
			}
		}
		Characters characters = player.getCharacter();
		Rectangle rec_Char = new Rectangle(characters.getPosition().getxCoordinate(),
				characters.getPosition().getyCoordinate(), characters.getWidth(), characters.getHeight());
		if (rec_Char.intersects(rec_up) || rec_Char.intersects(rec_down) || rec_Char.intersects(rec_left)
				|| rec_Char.intersects(rec_right)) {
			characters.setCollisionVsBomb(true);
		}
	}

	public List<Barrier> getBar() {
		return bar;
	}

	public List<Monster> getMons() {
		return mons;
	}

	public Player getPlayer() {
		return player;
	}

	public void setSizeBomb(Boom bomb) {
		bomb.setBombang_down(player.getCharacter().getBag().search("soda").getQuatity());
		bomb.setBombang_left(player.getCharacter().getBag().search("soda").getQuatity());
		bomb.setBombang_right(player.getCharacter().getBag().search("soda").getQuatity());
		bomb.setBombang_up(player.getCharacter().getBag().search("soda").getQuatity());
//		return bomb;
	}

}
