package assignment9;

import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class Game {
	private Snake snake;
    private Food food;
    private int foodEaten;

	
	public Game() {
		StdDraw.enableDoubleBuffering();
		snake = new Snake();
		food = new Food();
		foodEaten = 0;
	

	}
	
	public void play() {
		while (snake.isInbounds()) {  
		    int dir = getKeypress();
		    System.out.println("Direction: " + dir); 
		    if (dir != -1) {
		        snake.changeDirection(dir);
		    }

		    snake.move();
		    
		    if (snake.eatFood(food)) {    //count
		    	food = new Food();
		    	foodEaten += 1;
		    }
		    updateDrawing(foodEaten);
		}
		System.out.println("Game Over!");
	}
	private void displayCounter(int score) {
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.textLeft(0.1, 0.9, "Food Eaten: " + score);
		

	}
	
	private int getKeypress() {               //moves
		if(StdDraw.isKeyPressed(KeyEvent.VK_W)) {
			return 1;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			return 2;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
			return 3;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
			return 4;
		} else {
			return -1;
		}
	}
	
	/**
	 * Clears the screen, draws the snake and food, pauses, and shows the content
	 * @param foodEaten2 
	 */
	private void updateDrawing(int foodEaten2) {
		StdDraw.clear();
		snake.draw();
		food.draw();
		displayCounter(foodEaten);
		StdDraw.pause(50);
		StdDraw.show();

	}
	
	public static void main(String[] args) {
		Game g = new Game();
		g.play();
	}
}
