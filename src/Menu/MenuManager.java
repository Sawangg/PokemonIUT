package Menu;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Entity.Pokemon;
import Main.Main;

public class MenuManager {
	
	private String currentMenu;
	
	public JPanel fightGUI(Pokemon poke) {
		this.currentMenu = "fightGUI";
		JPanel GUI = new JPanel();
		GUI.setLayout(null);
		GUI.setVisible(true);
		
		JLabel pokeback = new JLabel();
		pokeback.setIcon(poke.getSpriteBack());
		pokeback.setBounds(Main.xSize, Main.ySize, 200, 200);
		pokeback.setLocation(400, 400);
		pokeback.setVisible(true);
		GUI.add(pokeback);
		
		JLabel background = new JLabel();
		Icon backgroundIMG = new ImageIcon("./ressources/battle/backgrounds_06.png");
		background.setIcon(backgroundIMG);
		background.setBounds(Main.xSize, Main.ySize, 800, 800);
		background.setLocation(0, 0);
		background.setVisible(true);
		GUI.add(background);
		

		
		return GUI;
	}
	
	public void setFightGUIvisible() {
		
	}
	
	public String getCurrentMenu() {
		return this.currentMenu;
	}
	
	
}