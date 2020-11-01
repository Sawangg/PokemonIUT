package Entity;

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

	private int velocity = 1;
	private String posPlayer = "";
	private Icon prevImg = player_01;

	public Player() {
		this.playerLabel.setBounds(Main.xSize, Main.ySize, 75, 75);
		this.playerLabel.setLocation(Main.xPlayer, Main.yPlayer);
		this.playerLabel.setIcon(player_01);
		this.playerLabel.setVisible(true);
	}
	
	public JLabel getPlayerLabel() {
		return this.playerLabel;

	}
	
	public void noPlayerLabel() {
		this.playerLabel.setVisible(false);
	}
	
	public void addPlayerLabel() {
		this.playerLabel.setVisible(true);
	}
	
	// Anim haut
	private void frameUP(Icon prev) {
		switch(prev.toString().substring(20, 29)) {
		case "player_13":
			this.playerLabel.setIcon(this.player_14);
			this.prevImg = this.player_14;
			break;
		case "player_14":
			this.playerLabel.setIcon(this.player_15);
			this.prevImg = this.player_15;
			break;
		case "player_15": 
			this.playerLabel.setIcon(this.player_16);
			this.prevImg = this.player_16;
			break;
		case "player_16": 
			this.playerLabel.setIcon(this.player_13);
			this.prevImg = this.player_13;
			break;
		default:
			this.playerLabel.setIcon(this.player_13);
			this.prevImg = this.player_13;
			break;
		} 
	}
		
	// Anim gauche
	private void frameLEFT(Icon prev) {
		switch(prev.toString().substring(20, 29)) {
		case "player_05":
			this.playerLabel.setIcon(this.player_06);
			this.prevImg = this.player_06;
			break;
		case "player_06":
			this.playerLabel.setIcon(this.player_07);
			this.prevImg = this.player_07;
			break;
		case "player_07": 
			this.playerLabel.setIcon(this.player_08);
			this.prevImg = this.player_08;
			break;
		case "player_08": 
			this.playerLabel.setIcon(this.player_05);
			this.prevImg = this.player_05;
			break;
		default:
			this.playerLabel.setIcon(this.player_05);
			this.prevImg = this.player_05;
			break;
		} 
	}

	// Anim droit
	private void frameRIGHT(Icon prev) {
		switch(prev.toString().substring(20, 29)) {
		case "player_09":
			this.playerLabel.setIcon(this.player_10);
			this.prevImg = this.player_10;
			break;
		case "player_10":
			this.playerLabel.setIcon(this.player_11);
			this.prevImg = this.player_11;
			break;
		case "player_11": 
			this.playerLabel.setIcon(this.player_12);
			this.prevImg = this.player_12;
			break;
		case "player_12": 
			this.playerLabel.setIcon(this.player_09);
			this.prevImg = this.player_09;
			break;
		default:
			this.playerLabel.setIcon(this.player_09);
			this.prevImg = this.player_09;
			break;
		} 
	}
		
	// Anim gauche
	private void frameDOWN(Icon prev) {
		switch(prev.toString().substring(20, 29)) {
		case "player_01":
			this.playerLabel.setIcon(this.player_02);
			this.prevImg = this.player_02;
			break;
		case "player_02":
			this.playerLabel.setIcon(this.player_03);
			this.prevImg = this.player_03;
			break;
		case "player_03": 
			this.playerLabel.setIcon(this.player_04);
			this.prevImg = this.player_04;
			break;
		case "player_04": 
			this.playerLabel.setIcon(this.player_01);
			this.prevImg = this.player_01;
			break;
		default:
			this.playerLabel.setIcon(this.player_01);
			this.prevImg = this.player_01;
			break;
		} 
	}

	public void setAnim(char key, boolean collision) {
		switch(key) {
		case 'z':
			this.frameUP(this.prevImg);
			if(collision) {
				new SoundEffect("collision(firered_0007)").play();
				this.knockback(8);
			} else {
				this.posPlayer = "up";
				Main.yPlayer-= this.velocity * 5;
				this.playerLabel.setLocation(Main.xPlayer, Main.yPlayer);
				if(Main.yPlayer <= -60) { // Quand le joueur sors du haut de l'écran
					this.tableauSuivant();
				}	
			}
			break;
			
		case 'q':
			if(collision) {
				new SoundEffect("collision(firered_0007)").play();
				this.knockback(8);
			} else {
				this.posPlayer = "left";
				this.frameLEFT(this.prevImg);
				Main.xPlayer -= this.velocity * 5;
				this.playerLabel.setLocation(Main.xPlayer, Main.yPlayer);
				if(Main.xPlayer <= -35) { // Quand le joueur touche sors de la gauche de l'écran
					this.tableauSuivant();
				}	
			}
			break;
			
		case 's':
			if(collision) {
				new SoundEffect("collision(firered_0007)").play();
				this.knockback(8);
			} else {
				this.posPlayer = "down";
				this.frameDOWN(this.prevImg);
				Main.yPlayer += this.velocity * 5;
				this.playerLabel.setLocation(Main.xPlayer, Main.yPlayer);
				if(Main.yPlayer >= Main.ySize - 50) { // Quand le joueur sors du bas de l'écran
					this.tableauSuivant();
				}
			}
			break;

		case 'd': 
			if(collision) {
				new SoundEffect("collision(firered_0007)").play();
				this.knockback(8);
			} else {
				this.posPlayer = "right";
				this.frameRIGHT(this.prevImg);
				Main.xPlayer += this.velocity * 5;
				this.playerLabel.setLocation(Main.xPlayer, Main.yPlayer);
				if(Main.xPlayer >= Main.xSize - 35) { // Quand le joueur sors de la droite de l'écran
					this.tableauSuivant(); 
				}
			}
			break;
			
		default: 
			break;
		}
	}

	public void originalAnim() {
		switch(this.posPlayer) {
		case "up":
			this.playerLabel.setIcon(this.player_13);
			this.prevImg = this.player_13;
			break;
		case "left":
			this.playerLabel.setIcon(this.player_05);
			this.prevImg = this.player_05;
			break;
		case "down": 
			this.playerLabel.setIcon(this.player_01);
			this.prevImg = this.player_01;
			break;
		case "right": 
			this.playerLabel.setIcon(this.player_09);
			this.prevImg = this.player_09;
			break;
		default:
			break;
		}
	}
	
	
	// Changement de lieu de la map
	public void tableauSuivant() {
		char car = Main.tableau.charAt(0);
		int entier = Integer.parseInt(Main.tableau.replace(car, ' ').replaceAll("\\s+","")); // Transforme A1 -> " 1" -> 1
		
		switch (this.posPlayer) {
		case "up":
			Main.yPlayer = (Main.ySize - 110); // Espace entre le bord et la réapartion du joueur en px
			this.playerLabel.setLocation(Main.xPlayer, Main.yPlayer);
			entier--;
			break;
		case "left":
			Main.xPlayer = (Main.xSize - 60); // Espace entre le bord et la réapartion du joueur en px
			this.playerLabel.setLocation(Main.xPlayer, Main.yPlayer);
			car--;
			break;
		case "down":
			Main.yPlayer = -20; // Espace entre le bord et la réapartion du joueur en px
			this.playerLabel.setLocation(Main.xPlayer, Main.yPlayer);
			entier++;
			break;
		case "right":
			Main.xPlayer = -10; // Espace entre le bord et la réapartion du joueur en px
			this.playerLabel.setLocation(Main.xPlayer, Main.yPlayer);
			car++;
			break;
		default :
			break;
		}
		//System.out.println(car + Integer.toString(entier)); // Pour le debug (savoir quel tableau on est passé)
		Main.tableau = car + Integer.toString(entier);
	}
	
	public void knockback(int multiplier) {
		switch(this.posPlayer) {
		case "up":
				Main.yPlayer += multiplier;
				this.playerLabel.setLocation(Main.xPlayer, Main.yPlayer);
			break;
		case "left":
				Main.xPlayer += multiplier;
				this.playerLabel.setLocation(Main.xPlayer, Main.yPlayer);
			break;
		case "down":
				Main.yPlayer -= multiplier;
				this.playerLabel.setLocation(Main.xPlayer, Main.yPlayer);
			break;
		case "right":
				Main.xPlayer -= multiplier;
				this.playerLabel.setLocation(Main.xPlayer, Main.yPlayer);
			break;
		default:
			break;
		}
	}
}