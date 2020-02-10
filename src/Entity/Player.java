package Entity;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Main.Main;
import Music.SoundEffect;

public class Player {
	
	private JLabel playerLabel = new JLabel();
	
	Icon player_01 = new ImageIcon("./ressources/player/player_01.png");
	Icon player_02 = new ImageIcon("./ressources/player/player_02.png");
	Icon player_03 = new ImageIcon("./ressources/player/player_03.png");
	Icon player_04 = new ImageIcon("./ressources/player/player_04.png");
	Icon player_05 = new ImageIcon("./ressources/player/player_05.png");
	Icon player_06 = new ImageIcon("./ressources/player/player_06.png");
	Icon player_07 = new ImageIcon("./ressources/player/player_07.png");
	Icon player_08 = new ImageIcon("./ressources/player/player_08.png");
	Icon player_09 = new ImageIcon("./ressources/player/player_09.png");
	Icon player_10 = new ImageIcon("./ressources/player/player_10.png");
	Icon player_11 = new ImageIcon("./ressources/player/player_11.png");
	Icon player_12 = new ImageIcon("./ressources/player/player_12.png");
	Icon player_13 = new ImageIcon("./ressources/player/player_13.png");
	Icon player_14 = new ImageIcon("./ressources/player/player_14.png");
	Icon player_15 = new ImageIcon("./ressources/player/player_15.png");
	Icon player_16 = new ImageIcon("./ressources/player/player_16.png");

	private int x = 200;
	private int y = 200; 
	private int velocity = 1;
	private String posPlayer = "";
	private Icon prevImg = player_01;

	public Player() {
		playerLabel.setBounds(100, 100, 100, 100);
		playerLabel.setVisible(true);
		playerLabel.setIcon(player_01);
	}
	
	
	public JLabel getPlayerLabel() {
		return this.playerLabel;
	}
	
	public Point getPlayerPosition() {
		return this.playerLabel.getLocation();
	}


	// Anim haut
	private void frameUP(Icon prev) {
		switch(prev.toString().substring(20, 29)) {
		case "player_13":
			playerLabel.setIcon(player_14);
			prevImg = player_14;
			break;
		case "player_14":
			playerLabel.setIcon(player_15);
			prevImg = player_15;
			break;
		case "player_15": 
			playerLabel.setIcon(player_16);
			prevImg = player_16;
			break;
		case "player_16": 
			playerLabel.setIcon(player_13);
			prevImg = player_13;
			break;
		default:
			playerLabel.setIcon(player_13);
			prevImg = player_13;
			break;
		} 
	}
		
	// Anim gauche
	private void frameLEFT(Icon prev) {
		switch(prev.toString().substring(20, 29)) {
		case "player_05":
			playerLabel.setIcon(player_06);
			prevImg = player_06;
			break;
		case "player_06":
			playerLabel.setIcon(player_07);
			prevImg = player_07;
			break;
		case "player_07": 
			playerLabel.setIcon(player_08);
			prevImg = player_08;
			break;
		case "player_08": 
			playerLabel.setIcon(player_05);
			prevImg = player_05;
			break;
		default:
			playerLabel.setIcon(player_05);
			prevImg = player_05;
			break;
		} 
	}

	// Anim droit
	private void frameRIGHT(Icon prev) {
		switch(prev.toString().substring(20, 29)) {
		case "player_09":
			playerLabel.setIcon(player_10);
			prevImg = player_10;
			break;
		case "player_10":
			playerLabel.setIcon(player_11);
			prevImg = player_11;
			break;
		case "player_11": 
			playerLabel.setIcon(player_12);
			prevImg = player_12;
			break;
		case "player_12": 
			playerLabel.setIcon(player_09);
			prevImg = player_09;
			break;
		default:
			playerLabel.setIcon(player_09);
			prevImg = player_09;
			break;
		} 
	}
		
	// Anim gauche
	private void frameDOWN(Icon prev) {
		switch(prev.toString().substring(20, 29)) {
		case "player_01":
			playerLabel.setIcon(player_02);
			prevImg = player_02;
			break;
		case "player_02":
			playerLabel.setIcon(player_03);
			prevImg = player_03;
			break;
		case "player_03": 
			playerLabel.setIcon(player_04);
			prevImg = player_04;
			break;
		case "player_04": 
			playerLabel.setIcon(player_01);
			prevImg = player_01;
			break;
		default:
			playerLabel.setIcon(player_01);
			prevImg = player_01;
			break;
		} 
	}

	public void setAnim(char key) {
		switch(key) {
		case 'z':
			frameUP(prevImg);
			posPlayer = "up";
			y -= velocity * 5;
			playerLabel.setLocation(x, y);
			if(y == -60) { // Quand le joueur sors du haut de l'écran
				borderManagement(posPlayer);
			}
			break;
		case 'q':
			frameLEFT(prevImg);
			posPlayer = "left";
			x -= velocity * 5;
			playerLabel.setLocation(x, y);
			if(x == -35) { // Quand le joueur touche sors de la gauche de l'écran
				borderManagement(posPlayer);
			}
			break;
		case 's': 
			frameDOWN(prevImg);
			posPlayer = "down";
			y += velocity * 5;
			playerLabel.setLocation(x, y);
			if(y == Main.ySize - 100) { // Quand le joueur sors du bas de l'écran
				borderManagement(posPlayer);
			}
			break;
		case 'd': 
			frameRIGHT(prevImg);
			posPlayer = "right";
			x += velocity * 5;
			playerLabel.setLocation(x, y);
			if(x == Main.xSize - 35) { // Quand le joueur sors de la droite de l'écran
				borderManagement(posPlayer); 
			}
			break;
		default: 
			break;
		}
	}

	public void originalAnim() {
		switch(posPlayer) {
		case "up":
			playerLabel.setIcon(player_13);
			prevImg = player_13;
			break;
		case "left":
			playerLabel.setIcon(player_05);
			prevImg = player_05;
			break;
		case "down": 
			playerLabel.setIcon(player_01);
			prevImg = player_01;
			break;
		case "right": 
			playerLabel.setIcon(player_09);
			prevImg = player_09;
			break;
		default:
			break;
		}
	}
	
	// Changement de lieu de la map
	public void borderManagement(String pos) {
		switch (pos) {
		case "up":
			y = (Main.ySize - 110); // Espace entre le bord et la réapartion du joueur en px
			playerLabel.setLocation(x, y);
			new SoundEffect("click(firered_0005)").play();
			break;
		case "left":
			x = (Main.xSize - 60); // Espace entre le bord et la réapartion du joueur en px
			playerLabel.setLocation(x, y);
			break;
		case "down":
			y = -20; // Espace entre le bord et la réapartion du joueur en px
			playerLabel.setLocation(x, y);
			break;
		case "right":
			x = -10; // Espace entre le bord et la réapartion du joueur en px
			playerLabel.setLocation(x, y);
			break;
		default :
			break;
		}
	}
}