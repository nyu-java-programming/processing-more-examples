package edu.nyu.cs.basics;

import processing.core.*;

/**
 * Pops open an applet window displaying an oscillating circle that bounces back and forth.
 * To run this, you must have imported and added the Processing core.jar file to your build path.
 * @author Foo Barstein
 * @version 2
 */
public class CircleOscillator extends PApplet {

	//instance properties
	
	//constants that hold the width and height of the window
	final private int w = 600;
	final private int h = 400;

	// the width and height of the ellipse we will draw
	final private int ellipseWidth = 100;
	final private int ellipseHeight = 100;
	
	//properties to hold the current position of the circle
	private int ellipseX = 50; //hard-coded starting value for the x position
	final private int ellipseY = 300; //hard-coded value for the y position that never changes
	
	//speed with which the circle is moving
	private int speed = 15; //this will be set to -1 to make the circle move the opposite direction when the circle reaches the edge
	
	/**
	 * This method is automatically called by Java when the program first starts.
	 * @param args any command line arguments (not used)
	 */
	public static void main(String[] args) {
		//must call PApplet's static main method, and supply the full package and class name of this class as an argument
		PApplet.main("edu.nyu.cs.basics.CircleOscillator");
	}
	
	/**
	 * Method to draft general settings of the app
	 */
	public void settings() {
		//set the site of the window in pixels to the values of the instance properties w and h
		this.size(this.w, this.h); 		
	}
	
	/**
	 * Method to compose the first 'frame' of the app
	 */
	public void setup() {

		//set the fill color (the color which solid shapes will be filled with)
		this.fill(120,50,240); 
		this.stroke(12, 100, 100);

	}
	
	/**
	 * This method is called repeatedly many times per second (usually 60 times per second by default) for the lifetime of the app.
	 */
	public void draw() {
		
		//fill the background with this color (specified in 8-bit R, G, B values)
		this.background(255, 255, 255); //white

		//generate pseudo-random R,G,B values 
		float r = 255 * (PApplet.second() * 1.0F/60); //int between 0 - 255 based on current number of seconds
		float g = 100F; //hard-coded amount of green
		float b = 92F; //hard-coded amount of blue
		
		//set the fill color to these random values
		this.fill(r, g, b);
		
		//draw an ellipse of width and height 100, and position its center at the current value of the x and y instance properties
		this.ellipseMode(PApplet.CENTER);
		this.ellipse(this.ellipseX, this.ellipseY, this.ellipseWidth, this.ellipseHeight);
		
		//update the x position for next time we draw it
		this.moveX();
	}
	
	/**
	 * This method updates the x position value, and changes the direction of movement, if the circle has gone out of bounds.
	 */
	public void moveX() {
		//if the circle has gone out of bounds in either direction
		if (this.ellipseX + this.ellipseWidth/2 > this.w || this.ellipseX - this.ellipseWidth/2 < 0) {
			//reverse direction of movement
			this.speed = this.speed * -1; 
		}
		
		//move the circle in the direction of movement.
		this.ellipseX = this.ellipseX + this.speed;
	}
	
}
