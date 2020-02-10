package Map;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Map extends JPanel {

	//private JLabel  mapLabel = new JLabel();
	
	private ImageIcon imgFond1 = new ImageIcon("./ressources/map/1.png");
	
	public Map() {
		//mapLabel.setIcon(map1);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics g2 = (Graphics2D)g;
		g2.drawImage(imgFond1.getImage(), 0, 0, null);
	}
	
	
	
}