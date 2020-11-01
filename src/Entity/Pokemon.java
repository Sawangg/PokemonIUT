package Entity;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Main.Main;


public class Pokemon {

	private String name;
	private int id;
	private ArrayList<String> type = new ArrayList<String>();
	private String gender;
	
	private int hp;
	private int speed;
	private int attack;
	private int specialAttack;
	private int defense;
	private int specialDefense;
	
	
	private int xp;
	private int evy;
	private int lvl;
	private int evolveLvl;
	private int evolveTo;
	
	private boolean isOwned;
	private String givenName;
	
	private Icon spriteBack;
	private Icon spriteFront;
	private boolean shiny;
	
	private ArrayList<String> moves = new ArrayList<String>();

	public Pokemon()  { // Wild pokemon
		//this.getPokemonByID(150);
		this.getPokemonByID((int)(Math.random() * 150 + 1));
	}
	
	public void getPokemonByID(int id) { // On appelle l'API pour donner tous les donn�es au pokemon
		try {
			JSONObject pokemonObj = Main.readJsonFromUrl("https://pokeapi.co/api/v2/pokemon/" + id);
			this.id = id;
		    this.name = pokemonObj.getString("name").substring(0, 1).toUpperCase() + pokemonObj.getString("name").substring(1);
		    
		    JSONArray pokemonStatsArr = new JSONArray(pokemonObj.getJSONArray("stats").toString());
		    this.speed = pokemonStatsArr.getJSONObject(0).getInt("base_stat");
		    this.specialDefense = pokemonStatsArr.getJSONObject(1).getInt("base_stat");
		    this.specialAttack = pokemonStatsArr.getJSONObject(2).getInt("base_stat");
		    this.defense = pokemonStatsArr.getJSONObject(3).getInt("base_stat");
		    this.attack = pokemonStatsArr.getJSONObject(4).getInt("base_stat");
		    this.hp = pokemonStatsArr.getJSONObject(5).getInt("base_stat");
		    
		    JSONArray pokemonTypesArr = new JSONArray(pokemonObj.getJSONArray("types").toString());
		    String pokemonTypes1 = pokemonTypesArr.getJSONObject(0).getJSONObject("type").getString("name");
		    
		    if(pokemonTypesArr.length() == 1) {
				this.type.add(pokemonTypes1);
		    } else {
			    String pokemonTypes2 = pokemonTypesArr.getJSONObject(1).getJSONObject("type").getString("name");
			    if(pokemonTypesArr.getJSONObject(0).getInt("slot") > 1) {
					this.type.add(pokemonTypes2.toString());
					this.type.add(pokemonTypes1.toString());
			    } else {
					this.type.add(pokemonTypes1.toString());
					this.type.add(pokemonTypes2.toString());
			    }
		    }

		    this.evy = pokemonObj.getInt("base_experience");

		    this.shiny = this.isShiny();
		    if(this.shiny == false) {
			    this.spriteBack = new ImageIcon(ImageIO.read(new URL(pokemonObj.getJSONObject("sprites").getString("back_default"))));
			    this.spriteFront = new ImageIcon(ImageIO.read(new URL(pokemonObj.getJSONObject("sprites").getString("front_default"))));
		    } else {
			    this.spriteBack = new ImageIcon(ImageIO.read(new URL(pokemonObj.getJSONObject("sprites").getString("back_shiny"))));
			    this.spriteFront = new ImageIcon(ImageIO.read(new URL(pokemonObj.getJSONObject("sprites").getString("front_shiny"))));
		    }

	
		} catch (IOException | JSONException e) {
			e.printStackTrace();
		}
	}

	
	public String toString() {
		return "Id : " + this.id + "\nName : " + this.name + "\nTypes : " + this.type + "\nHP : " + this.hp +"\nAttack : " + this.attack + "\nDefense : " + this.defense  + "\nSpeed : " + this.speed + "\nSpecial-Attack : " + this.specialAttack + "\nSpecial-Defense : " + this.specialDefense + "\nShiny : " + this.shiny;
	}
	
	public void getPokemonbyZone() {
		
	}
	
	public boolean isShiny() {
		if(Math.random() <= (2.44140625 * (10^-4))) { // 1 / 4096
			return true;
		} else {
			return false;
		}
	}
	

	/*public void gainXP(Pokemon poke) {
		double a = 1.5;
		this.evy;
		if(poke.getOwner() == null) {
			a = 1;
		}
		
		
		this.xp = (int) ()
	}*/

	public int getXp() {
		return this.xp;
	}

	public void setXp(int lvl) {
		this.xp = (int) (1.25 *(lvl ^3));
	}
	
	public int getXpfromLvl(int lvl) {
		return (lvl^3);
	}

	public Icon getSpriteBack() {
		return this.spriteBack;
	}

	public Icon getSpriteFront() {
		return this.spriteFront;
	}
}
