package assignment9;

import java.util.LinkedList;

public class Snake {

	private static final double SEGMENT_SIZE = 0.02;
	private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.5;
	private LinkedList<BodySegment> segments;
	private double deltaX;
	private double deltaY;
	
	public Snake() {
		segments = new LinkedList<>();
		deltaX = 0;
		deltaY = 0;
		
		double startX = 0.5;
		double startY = 0.5;
		
		for(int i=0; i<3; i++) {
			double x = startX - i * MOVEMENT_SIZE;
			double y = startY;
			segments.add(new BodySegment(x, y, SEGMENT_SIZE));
		}
	}
	
	public void changeDirection(int direction) {
		if(direction == 1) { //up
			deltaY = MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 2) { //down
			deltaY = -MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 3) { //left
			deltaY = 0;
			deltaX = -MOVEMENT_SIZE;
		} else if (direction == 4) { //right
			deltaY = 0;
			deltaX = MOVEMENT_SIZE;
		}
	}
	
	/**
	 * Moves the snake by updating the position of each of the segments
	 * based on the current direction of travel
	 */
	public void move() {
		BodySegment head = segments.getFirst();
	    double newHeadX = head.getX() + deltaX;
	    double newHeadY = head.getY() + deltaY;

	    BodySegment newHead = new BodySegment(newHeadX, newHeadY, SEGMENT_SIZE);
	    segments.addFirst(newHead);

	    if (segments.size() > segments.size() - 1) {
	    	segments.removeLast();
	    }

	}
	
	/**
	 * Draws the snake by drawing each segment
	 */
	public void draw() {
		for (BodySegment segment : segments) {
			segment.draw();
		}

	}
	
	/**
	 * The snake attempts to eat the given food, growing if it does so successfully
	 * @param f the food to be eaten
	 * @return true if the snake successfully ate the food
	 */
	public boolean eatFood(Food f) {

		BodySegment head = segments.getFirst(); //growth
	    double headX = head.getX();
	    double headY = head.getY();
	    
	    double foodX = f.getX(); 
	    double foodY = f.getY();

	    if (Math.abs(headX - foodX) < Food.FOOD_SIZE && Math.abs(headY - foodY) < Food.FOOD_SIZE) {
	        
	        double dx = segments.get(1).getX() - headX;
	        double dy = segments.get(1).getY() - headY;
	        BodySegment newSegment = new BodySegment(
	            segments.getLast().getX() - dx, 
	            segments.getLast().getY() - dy, 
	            SEGMENT_SIZE
	        );
	        segments.addLast(newSegment);
	        
	        java.util.Random random = new java.util.Random();
	        int red = random.nextInt(256);
	        int green = random.nextInt(256);
	        int blue = random.nextInt(256);
	        java.awt.Color randomColor = new java.awt.Color(red, green, blue);

	        for (BodySegment segment : segments) {
	            segment.setColor(randomColor);
	        }

	        return true;
	    }

		return false;
	}
	
	/**
	 * Returns true if the head of the snake is in bounds
	 * @return whether or not the head is in the bounds of the window
	 */
	public boolean isInbounds() {
		BodySegment head = segments.getFirst();
	    double headX = head.getX();
	    double headY = head.getY();

	    return headX >= 0 && headX <= 1 && headY >= 0 && headY <= 1;

	}
}
