package Music;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Music {
	
	private Clip clip;

	public Music(String music) {
	    File f = new File("./sounds/tracks/" + music + ".wav");
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
	    clip.start();
	}
	
	public void loop(int l) {
	    this.clip.loop(l);
	}
	
	public void stop() {
		this.clip.stop();
	}
}
