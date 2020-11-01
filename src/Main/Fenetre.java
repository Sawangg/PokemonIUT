package Main;

import javax.swing.JFrame;

import Entity.Player;
import Events.EventManager;
import Map.Map;

public class Fenetre {
	public static final JFrame frame = new JFrame();
	public static Player p = new Player();
    public static Map map = new Map();
	
	
	public Fenetre() {
		EventManager em = new EventManager();
		frame.addKeyListener(em);
		frame.setTitle("PokemonIUT");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setEnabled(true);
		frame.setSize(Main.xSize, Main.ySize);
		//frame.setIconImage(new ImageIcon("./ressources/menu/icon.png").getImage());
		frame.setResizable(false);
		//frame.setAlwaysOnTop(true); // A voir si on rajoute mais desac pour le debug

        map.add(p.getPlayerLabel());
        map.setVisible(true);
		map.setEnabled(true);
		map.setLayout(null);
		frame.add(map);
	}
}