package com.exotik.t3dj;

import java.awt.Canvas;

import javax.swing.JFrame;

import com.exotik.t3dj.graphics.Render;

public class Display extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 1L; // Serial Version ID (don't touch this)

	private Thread thread;
	private boolean running = false;
	private Render render;
	
	public Display() {
		render = new Render(Config.width, Config.height);
	}
	
	private void start() {
		if (running) return;
		running = true;
		thread = new Thread(this);
		
		if (Config.debug) {
			/* Util util = new Util();
			util.playSound("test1"); */
			Util.logFrom("Working!", "start", "Display");
		}
	}
	
	public static void main(String[] args) {
		Display game = new Display(); // Game
		JFrame frame = new JFrame(); // Window
		
		Util.frameInit(frame, game); // Initializes the frame (to clean up code)
		
		if (Config.debug) Util.logFrom("Attempting to start...", "main", "Display");
		
		game.start(); // Starts the game
	}

	public void run() {
		while (running) {
			tick();
			render();
		}
	}
	
	private void render() {
		
	}

	private void tick() {
		
	}

	public void stop() {
		if (!running) return;
		running = false;
		try {
			thread.join();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
}
