package Main;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import Entity.Player;
import Map.Map;
import Menu.MenuManager;

@SuppressWarnings("serial")
public class Fenetre extends JFrame implements KeyListener {
	private Player p = new Player();
	//private JPanel panel = new JPanel();
	
	@SuppressWarnings("unused")
	private MenuManager m = new MenuManager();
	
	public Fenetre(int xSize, int ySize) {		
		this.addKeyListener(this);
		this.setTitle("Pokemon");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setEnabled(true);
		this.setSize(xSize, ySize);
		this.setResizable(false);
		//this.setAlwaysOnTop(true); // 
		
		/*this.add(panel);

		panel.setVisible(true);
		panel.setLayout(null);
		panel.setEnabled(true);
		
        panel.add(p.getPlayerLabel());*/

        Map map = new Map();
        map.add(p.getPlayerLabel());
        map.setVisible(true);
		map.setEnabled(true);
		map.setLayout(null);
        this.add(map);
		

	}

	@Override
	public void keyPressed(KeyEvent e) {
		p.setAnim(Character.toLowerCase(e.getKeyChar()));
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		p.originalAnim();
		
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
}