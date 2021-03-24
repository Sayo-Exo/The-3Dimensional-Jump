package com.exotik.t3dj.graphics;

public class Render {
	
	public int width;
	public int height;
	public int[] pixels;
	
	public Render(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width*height];
	}
	
}
