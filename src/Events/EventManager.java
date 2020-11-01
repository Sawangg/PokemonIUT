package Events;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import Main.Fenetre;
import Main.Main;
import Map.TileMap;
import Menu.MenuManager;
import Music.SoundEffect;

public class EventManager implements KeyListener {
	
	private TileMap tm = new TileMap(Main.tableau);
	private ArrayList<String> currentEvent = new ArrayList<String>();

	private boolean PlayerControlStatus = true;
	
	private MenuManager m;
	
	public int getTileEventType() {
		return tm.getTile(tm.getXtile(), tm.getYtile());
	}
	
	public ArrayList<String> removeEvents() {
		this.currentEvent.removeAll(this.currentEvent); // Enl�ve les �venements quand nous sommes dans uen case d'air
		return currentEvent;
	}
	
	public ArrayList<String> getEventType() {
		switch(this.getTileEventType()) {
		case 0: // Aucun �v�nements dans la case air
			this.removeEvents();
			break;
		case 1: // Objet infranchissable
			this.currentEvent.add("collision");
			break;
		case 2: // 
			this.currentEvent.add("collision");
			this.currentEvent.add("interaction collision");
			break;
		case 3: // Hautes herbes
			this.currentEvent.add("hautes herbes");
			break;
		default:
			this.removeEvents();
			break;
		}
		return this.currentEvent;
	}

	public void checkInteraction(final ArrayList<String> eventType) {
		if (eventType.contains("interaction collision")) {
			new SoundEffect("click(firered_0005)").play();

		} else { // d'autre type d'interaction avec la touche a

		}
	}

	public boolean lockPlayerControl() {
		return this.PlayerControlStatus = false;
	}

	public boolean unlockPlayerControl() {
		return this.PlayerControlStatus = true;
	}

	@Override
	public void keyPressed(final KeyEvent e) {
		this.tm = new TileMap(Main.tableau); // Actualise la tile map <- MEGA IMPORTANT
		this.m = new MenuManager();

		if (this.PlayerControlStatus == true) {

			if (e.getKeyCode() == 27) { // Echap
				if (m.getCurrentMenu() != null) {
					// m.getCurrentMenu().close();
				} else {

				}
			}

			this.currentEvent = this.removeEvents(); // Enl�ve l'�venement pr�c�dent
			this.currentEvent = this.getEventType(); // R�cupere le nouvel �venement
			if (currentEvent.contains("hautes herbes")) {
				if (Math.random() <= 0.20) {
					this.lockPlayerControl();
					new Fight().launch();
				} else {
					Fenetre.p.setAnim(Character.toLowerCase(e.getKeyChar()), false);
				}
			} else if (this.currentEvent.contains("collision")) {
				// Fenetre.p.setAnim(Character.toLowerCase(e.getKeyChar()), false); // Debug
				// Noclip
				Fenetre.p.setAnim(Character.toLowerCase(e.getKeyChar()), true);
			} else {
				Fenetre.p.setAnim(Character.toLowerCase(e.getKeyChar()), false);
			}

			// System.out.println(this.currentEvent); // Debug affiche l'�v�nement de la
			// tile

			// System.out.println("X: "+ this.tm.getTile(9, 9)); // Debug obtenir l'int
			// d'une tile
			// System.out.println("X: "+ this.tm.getXtile()); // Debug tile X du joueur
			// System.out.println("Y: "+ this.tm.getYtile()); // Debug tile Y du joueur
		}

	}

	@Override
	public void keyReleased(final KeyEvent e) {
		Fenetre.p.originalAnim();
		if (Character.toLowerCase(e.getKeyChar()) == 'a') {
			this.unlockPlayerControl();
			Fenetre.p.addPlayerLabel();
			if (currentEvent.contains("interaction collision")) {
				System.out.println("yo");
				// this.checkInteraction();
			}
		}
	}

	@Override
	public void keyTyped(final KeyEvent e) {
		
	}

	
}