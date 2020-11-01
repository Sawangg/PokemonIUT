package Events;

import javax.swing.JPanel;

import Entity.Pokemon;
import Main.Fenetre;
import Menu.MenuManager;
import Music.Music;

public class Fight {
	private Pokemon poke;
	private MenuManager m = new MenuManager();
	
	public Fight() {
		
	}

	public void launch() {
        new Music("Wild-Pokemon-Battle-Theme").loop(100);
        poke = new Pokemon();
		JPanel FightGUI = m.fightGUI(poke);
		Fenetre.frame.add(FightGUI);
		Fenetre.map.noMapPabel();
		Fenetre.p.noPlayerLabel();
		System.out.println(poke.toString());
	}
	
	public void stop() {
		//Fenetre.frame.remove(FightGUI);
	}
}
