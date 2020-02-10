package Main;
import javax.swing.SwingUtilities;

import Music.Music;

public class Main {
	public static int xSize = 800;
	public static int ySize = 800;

	public static void main(String[] args) {
				
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
		          new Fenetre(xSize, ySize);
		          new Music("main-theme").loop(100);
			}
		});
	}
}