package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class Food {

	public static final double FOOD_SIZE = 0.02;
	private double x, y;
	
	/**
	 * Creates a new Food at a random location
	 */
	public Food() {
		this.x = Math.random();    //new food
		this.y = Math.random();

	}
	
	/**
	 * Draws the Food
	 */
	public void draw() {
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.filledSquare(this.x, this.y, FOOD_SIZE);
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}

	
}
