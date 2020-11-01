package Map;

import java.awt.Graphics;

import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Main.Main;

@SuppressWarnings("serial")
public class Map extends JPanel {
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		this.repaint();
		Graphics g2 = (Graphics2D)g;
		try {
			ImageIcon background = new ImageIcon("./ressources/map/" + Main.tableau + ".png");
			g2.drawImage(background.getImage(), 0, 0, null);	
		} catch(Exception e) {
			e.getMessage();
		}
	}
	
	public void noMapPabel() {
		this.setVisible(false);
	}
	
	public void addMapPabel() {
		this.setVisible(true);
	}

}