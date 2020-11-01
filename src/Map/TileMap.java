package Map;

import java.io.BufferedReader;
import java.io.FileReader;

import Main.Main;

public class TileMap {

	private int tileX = 31;
	private int tileY = 31;
	private int[][] tileMap;
	
	public TileMap(String nom) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("./ressources/map/" + nom + ".txt"));
			
			this.tileMap = new int[tileX][tileY];
			
			for(int row = 0; row < tileX; row++) {
				String[] tokens = br.readLine().split(" ");
				for(int col = 0; col < tileY; col++) {
					this.tileMap[row][col] = Integer.parseInt(tokens[col]);
				}
			}
			br.close();
		} catch(Exception e) {
			e.getMessage();
		}
	}
	
	public int getXtile() {
		return Main.xPlayer / 25; // La position du joueur diviser par la taille d'une tile
	}
	
	public int getYtile() {
		return Main.yPlayer / 25;
	}
	
	public int getTile(int row, int col) {
		if((row < 0) || (col < 0)) { // Le joueur peut aller dans des positions n�gatives ou sup�rieur a la taille de la fen�tre pour l'animation de changement de tableau
			return this.tileMap[0][0];
		} else if((row >= 31) || (col >= 31)) { 
			return this.tileMap[30][30];
		}
		return this.tileMap[row][col];
	}
	
	// En gros tourner �a t�te � 90� vers la gauche pour le vrai sens
	// Chiffre � droite = case en bas
	// Chiffre en haut = case � gauche
	// Chiffre � gauche = case en haut
	// Chiffre en bas = case � droite

}
