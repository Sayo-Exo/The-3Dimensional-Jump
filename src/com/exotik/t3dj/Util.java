package com.exotik.t3dj;

import java.awt.Dimension;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

public class Util {
	
	public static final Dimension gameDimension = new Dimension(Config.width, Config.height); // Game dimensions (change in Config)
	
	public static void log(String log) {
		System.out.println(log);
	}
	public static void logFrom(String log, String method, String theClass) {
		System.out.println("From method " + method + ", " + theClass + ": " + log);
	}
	
	public static void frameInit(JFrame frame, Display game) {
		frame.add(game); // Adding the game to the window
		frame.pack(); // Packs the window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Actually closes the game's thread when you close the window
		frame.setSize(gameDimension); // Sets the windows's size
		frame.setTitle(Config.gameName); // Sets the window's title
		frame.setLocationRelativeTo(null); // Sets location to the center of the screen
		frame.setResizable(false); // Makes the window not resizable
		frame.setVisible(true); // Makes the frame visible
		frame.requestFocus(); // Gets the focus on the window

	}
	
	public void playSound(String sound) {
	      try {
	          // Open an audio input stream.
	    	  String folder = "./audio/sounds/test1.wav";
	    	  if (Config.debug) System.out.println("From void 'playSound', Util: " + folder);
	          URL url = this.getClass().getClassLoader().getResource(folder);
	          AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
	          // Get a sound clip resource.
	          Clip clip = AudioSystem.getClip();
	          // Open audio clip and load samples from the audio input stream.
	          clip.open(audioIn);
	          clip.start();
	       } catch (UnsupportedAudioFileException e) {
	          e.printStackTrace();
	       } catch (IOException e) {
	          e.printStackTrace();
	       } catch (LineUnavailableException e) {
	          e.printStackTrace();
	       }
	}
	
	public void playMusic(String music, String overrideFolder) {
	      try {
	    	  String folder = Config.musicFolder + "/" + music + ".wav";
	    	  if (overrideFolder != null)
	    		  folder = Config.audioFolder + "/" + overrideFolder + "/" + music + ".wav";
	          // Open an audio input stream.
	          URL url = this.getClass().getClassLoader().getResource(folder);
	          AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
	          // Get a sound clip resource.
	          Clip clip = AudioSystem.getClip();
	          // Open audio clip and load samples from the audio input stream.
	          clip.open(audioIn);
	          clip.start();
	       } catch (UnsupportedAudioFileException e) {
	          e.printStackTrace();
	       } catch (IOException e) {
	          e.printStackTrace();
	       } catch (LineUnavailableException e) {
	          e.printStackTrace();
	       }
	}
}
