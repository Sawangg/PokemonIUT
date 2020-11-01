package Music;

import java.io.File;

import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundEffect {
	private Clip clip;

	public SoundEffect(String sound) {
	    File f = new File("./sounds/soundeffects/" + sound + ".wav");
		try {
			clip = AudioSystem.getClip();
		} catch (LineUnavailableException e1) {
	        System.err.println(e1.getMessage());			
	        e1.printStackTrace();
		}
	    try {
			clip.open(AudioSystem.getAudioInputStream(f.toURI().toURL()));
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
	        System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public String getClip() {
		return this.clip.toString();
	}
	
	public void play() {
	    this.clip.start();
	}
	
	public void loop(int l) {
	    this.clip.loop(l);
	}
	
	public void stop() {
		this.clip.stop();
	}
}