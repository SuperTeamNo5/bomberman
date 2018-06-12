package com.game.bomberman.controller;

import java.awt.Rectangle;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.game.bomberman.model.Barrier;
import com.game.bomberman.model.Boom;
import com.game.bomberman.model.Characters;
import com.game.bomberman.model.Loot;
import com.game.bomberman.model.Map;
import com.game.bomberman.model.Monster;
import com.game.bomberman.model.Player;
import com.game.bomberman.model.Position;
import com.game.bomberman.singleton.MusicSingletonDAO;
import com.game.bomberman.view.MainViewOfGame;

import DAO.ImageDAO;

// including methods action for game
public class Action {
	private Player player;
	private List<Barrier> bar;
	private List<Loot> loot;
	private List<Monster> mons;
	private Map map;
	private MusicSingletonDAO musicDAO;
	MainViewOfGame mainViewOfGame;

	public MusicSingletonDAO getMusicDAO() {
		return musicDAO;
	}

	public void setMusicDAO(MusicSingletonDAO musicDAO) {
		this.musicDAO = musicDAO;
	}

<<<<<<< HEAD
	public Action(Map map, MainViewOfGame mainViewOfGame) {
=======
	public Action(Map map, Player player) {
>>>>>>> 5cc0dd67bbf0af59816c426aa654996b8b3b126d
		this.map = map;
		this.player = player;
		this.bar = map.getBar();
		this.loot = map.getLoot();
		this.mons = map.getMons();
		this.mainViewOfGame = mainViewOfGame;
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
	@SuppressWarnings("static-access")
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
		Rectangle rec2;
		for (int i = 0; i < bar.size(); i++) {
			rec2 = new Rectangle(bar.get(i).getPosition().getxCoordinate(), bar.get(i).getPosition().getyCoordinate(),
					bar.get(i).getWidth(), bar.get(i).getHeight() - 20);
			if (player.getCharacter().collision(rec1, rec2)) {
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
		if (chara.getBag().search("bombItem").getQuatity() > 0) {
			// drop bomb
			musicDAO.getListSound().get(5).playSound(false);
			Loot bomb = new Boom(new Position((x / 50) * 50, (y / 50) * 50), player.getName());
			loot.add(bomb);
			setSizeBomb((Boom) bomb);
			chara.getBag().search("bombItem").setQuatity(chara.getBag().search("bombItem").getQuatity() - 1);

		}
//		 map.setLoot(loot);

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
					bombangvsMonsVsBomberVsBar(bomb);

				}
			} else {
				rec2 = new Rectangle(loot.get(i).getPosition().getxCoordinate() + 10,
						loot.get(i).getPosition().getyCoordinate() + 10, 15, 15);
				if (player.getCharacter().collision(rec1, rec2)) {
					// loot item
					player.getCharacter().getBag().add(loot.get(i));
					loot.remove(i);
					// pick up items sound
					musicDAO.getListSound().get(6).playSound(false);
					// update quantity loot
					RunGame.updateQuantityOfLoot();
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
			if (player.getCharacter().collision(rec1, rec2)) {// player dies
				player.getCharacter().dead();
				musicDAO.getListSound().get(3).playSound(false);
				player.getCharacter().setHeart(player.getCharacter().getHeart() - 1);
				RunGame.updateQuantityOfLoot();
				if (player.getCharacter().getHeart() == 0) {
					warning("Lose!", "Don't give up, Your mom believe you!", ImageDAO.avatarImage);
				}
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
					// bomb bangs
					musicDAO.getListSound().get(2).playSound(false);
				}
			} else {
				if (loot.get(i).getName().equalsIgnoreCase("bombang")) {
					lo = (Boom) loot.get(i);
					String name = lo.getBombOf();
					if (boomBang(lo) == true) {
						if (name.equalsIgnoreCase(player.getName())) {
							chara.getBag().search("bombItem")
									.setQuatity(chara.getBag().search("bombItem").getQuatity() + 1);
							loot.remove(i);
						}
					}
					RunGame.updateQuantityOfLoot();
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

	public void setSizebombangvsBox(Boom bomb) {
<<<<<<< HEAD

		Rectangle rec_right = new Rectangle(bomb.getPosition().getxCoordinate(), bomb.getPosition().getyCoordinate(),
				45 + 45 * bomb.getBombang_right(), 45);
		Rectangle rec_left = new Rectangle(bomb.getPosition().getxCoordinate() - (45 * bomb.getBombang_left()),
				bomb.getPosition().getyCoordinate(), 45 + 45 * bomb.getBombang_left(), 45);
		Rectangle rec_down = new Rectangle(bomb.getPosition().getxCoordinate(), bomb.getPosition().getyCoordinate(), 45,
				45 + 45 * bomb.getBombang_down());
		Rectangle rec_up = new Rectangle(bomb.getPosition().getxCoordinate(),
				bomb.getPosition().getyCoordinate() - (45 * bomb.getBombang_up()), 45, 45 + 45 * bomb.getBombang_up());
=======
		Rectangle rec_right = new Rectangle(bomb.getPositon().getxCoordinate(), bomb.getPositon().getyCoordinate(),
				45 + (45 * bomb.getBombang_right()), 45);
		Rectangle rec_left = new Rectangle(bomb.getPositon().getxCoordinate() - (45 * bomb.getBombang_left()),
				bomb.getPositon().getyCoordinate(), 45 + (45 * bomb.getBombang_left()), 45);
		Rectangle rec_down = new Rectangle(bomb.getPositon().getxCoordinate(), bomb.getPositon().getyCoordinate(), 45,
				45 + (45 * bomb.getBombang_down()));
		Rectangle rec_up = new Rectangle(bomb.getPositon().getxCoordinate(),
				bomb.getPositon().getyCoordinate() - (45 * bomb.getBombang_up()), 45, 45 + (45 * bomb.getBombang_up()));
>>>>>>> 5cc0dd67bbf0af59816c426aa654996b8b3b126d
		for (int i = 0; i < bar.size(); i++) {
			Barrier barrier = bar.get(i);
			Rectangle rec_Box = new Rectangle(barrier.getPosition().getxCoordinate(),
					barrier.getPosition().getyCoordinate(), 50, 50);
			// if (rec_Box.intersects(rec_up) || rec_Box.intersects(rec_down) ||
			// rec_Box.intersects(rec_left)
			// || rec_Box.intersects(rec_right)) {
			// if (bar.get(i).isCanDestroy()) {
			// bar.remove(i);
			// }
			// }
			// setLeft
			if (rec_Box.intersects(rec_left)) {
				int size = (rec_left.width - (rec_Box.x - rec_left.x)) / 50;
				if (bomb.getBombang_left() > size) {
					bomb.setBombang_left(size);
				}
			}
			if (rec_Box.intersects(rec_right)) {
				int size = ((rec_Box.x - rec_right.x)) / 50;
				if (bomb.getBombang_right() > size) {
					bomb.setBombang_right(size);
				}
			}
			if (rec_Box.intersects(rec_up)) {
				int size = (rec_up.height - (rec_Box.y - rec_up.y)) / 50;
				if (bomb.getBombang_up() > size) {
					bomb.setBombang_up(size);
				}
			}
			if (rec_Box.intersects(rec_down)) {
				int size = (rec_Box.y - rec_down.y) / 50;
				if (bomb.getBombang_down() > size) {
					bomb.setBombang_down(size);
				}
			}
		}
	}

	int playerDead = 0;

	public void bombangvsMonsVsBomberVsBar(Boom bomb) {
<<<<<<< HEAD

		Rectangle rec_right = new Rectangle(bomb.getPosition().getxCoordinate(), bomb.getPosition().getyCoordinate(),
				45 + 45 * bomb.getBombang_right(), 45);
		Rectangle rec_left = new Rectangle(bomb.getPosition().getxCoordinate() - 45,
				bomb.getPosition().getyCoordinate(), 45 + 45 * bomb.getBombang_left(), 45);
		Rectangle rec_down = new Rectangle(bomb.getPosition().getxCoordinate(), bomb.getPosition().getyCoordinate(), 45,
				45 + 45 * bomb.getBombang_down());
		Rectangle rec_up = new Rectangle(bomb.getPosition().getxCoordinate(), bomb.getPosition().getyCoordinate() - 45,
				45, 45 + 45 * bomb.getBombang_up());
=======
		// System.out.println("//////////////////////" + bomb.getBombang_left()
		// + bomb.getBombang_right()
		// + bomb.getBombang_up() + bomb.getBombang_down());
		Rectangle rec_right = new Rectangle(bomb.getPositon().getxCoordinate(), bomb.getPositon().getyCoordinate(),
				45 + (45 * bomb.getBombang_right()), 45);
		Rectangle rec_left = new Rectangle(bomb.getPositon().getxCoordinate() - (45 * bomb.getBombang_left()),
				bomb.getPositon().getyCoordinate(), 45 + (45 * bomb.getBombang_left()), 45);
		Rectangle rec_down = new Rectangle(bomb.getPositon().getxCoordinate(), bomb.getPositon().getyCoordinate(), 45,
				45 + (45 * bomb.getBombang_down()));
		Rectangle rec_up = new Rectangle(bomb.getPositon().getxCoordinate(),
				bomb.getPositon().getyCoordinate() - (45 * bomb.getBombang_up()), 45, 45 + (45 * bomb.getBombang_up()));
>>>>>>> 5cc0dd67bbf0af59816c426aa654996b8b3b126d
		for (int i = 0; i < mons.size(); i++) {
			Monster mon = mons.get(i);
			Rectangle rec_Mons = new Rectangle(mon.getPosition().getxCoordinate(), mon.getPosition().getyCoordinate(),
					45, 55);
			if (rec_Mons.intersects(rec_up) || rec_Mons.intersects(rec_down) || rec_Mons.intersects(rec_left)
					|| rec_Mons.intersects(rec_right)) {
<<<<<<< HEAD
				mons.remove(i);
				// monster dies
				musicDAO.getListSound().get(4).playSound(false);
				player.setScore(player.getScore() + 100);
				// update player's score
				RunGame.updateQuantityOfLoot();
=======
				if (player.getName().equalsIgnoreCase(bomb.getBombOf())) {
					mons.remove(i);
					player.setScore(player.getScore() + 10);
					System.out.println("Diem cua " + player.getName() + " ne:...." + player.getScore());
				}
			}
		}
		Boom lo;
		for (int i = 0; i < loot.size(); i++) {
			if (loot.get(i).getName().equalsIgnoreCase("bomb")) {
				// lo = loot.get(i);
				Rectangle rec_bomb = new Rectangle(loot.get(i).getPositon().getxCoordinate(),
						loot.get(i).getPositon().getyCoordinate(), 45, 55);
				if (rec_bomb.intersects(rec_up) || rec_bomb.intersects(rec_down) || rec_bomb.intersects(rec_left)
						|| rec_bomb.intersects(rec_right)) {
					lo = (Boom) loot.get(i);
					lo.setDeadLine(15);
				}
>>>>>>> 5cc0dd67bbf0af59816c426aa654996b8b3b126d
			}
		}
		for (int i = 0; i < bar.size(); i++) {
			Barrier barrier = bar.get(i);
			Rectangle rec_Box = new Rectangle(barrier.getPosition().getxCoordinate(),
					barrier.getPosition().getyCoordinate(), 50, 50);
			if (rec_Box.intersects(rec_up) || rec_Box.intersects(rec_down) || rec_Box.intersects(rec_left)
					|| rec_Box.intersects(rec_right)) {
				System.out.println("va cham");
				if (barrier.isCanDestroy()) {
					bar.remove(i);
				}
			}
		}
		Characters characters = player.getCharacter();
		Rectangle rec_Char = new Rectangle(characters.getPosition().getxCoordinate() + 5,
				characters.getPosition().getyCoordinate() + 15, 30, 20);
		if (rec_Char.intersects(rec_up) || rec_Char.intersects(rec_down) || rec_Char.intersects(rec_left)
				|| rec_Char.intersects(rec_right)) {
			characters.setCollisionVsBomb(true);
			if (playerDead == 0) {// player died
				// if player's heart equal zero
				if (player.getCharacter().getHeart() == 0) {
					warning("Lose!", "Don't give up, your mom believe you!", ImageDAO.avatarImage);
				} else {
					//heart
					characters.setHeart(characters.getHeart() - 1);
					musicDAO.getListSound().get(3).playSound(false);
					playerDead++;
//					RunGame.updateQuantityOfLoot();

				}
			}
		}
	}

	public void warning(String title, String content, String image) {
		String[] buttons = { "Okay" };
		ImageIcon icon = new ImageIcon((getClass().getResource(image)));

		JOptionPane.showOptionDialog(null, content, title, JOptionPane.INFORMATION_MESSAGE, 0, icon, buttons, null);
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
		// setSizeBomb(bomb);
		setSizebombangvsBox(bomb);
		// return bomb;
	}

}
