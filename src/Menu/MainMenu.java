package Menu;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MainMenu {
	
	private JLabel menuLabel = new JLabel();

	Icon background = new ImageIcon("./ressources/menu/main-menu.jpg");

	public MainMenu() {
		menuLabel.setBounds(0, 0, 700, 750);
		menuLabel.setVisible(true);
		menuLabel.setIcon(background);
	}
	
	public String getMenuName() {
		return "MainMenu";
	}
	
	public JLabel getMainMenuLabel() {
		return this.menuLabel;
	}
}