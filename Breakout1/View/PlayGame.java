package View;

import java.awt.List;

import Model.Movement;
import acm.graphics.GObject;
import acm.program.GraphicsProgram;

public class PlayGame extends GraphicsProgram {
	long last_time = System.nanoTime();
	public boolean running = false;
	private GObject oldball = null;
	private GObject oldpaddle = null;
	public List bricksToDelete = new List();

	public PlayGame() {
		
	}
	public void update() {
		

		while(running) {
		    long time = System.nanoTime();
		    int delta_time = (int) ((time - last_time) / 1000000);
		    
		    //Moving the ball
		    GObject newball = start.ball;
		    addToScreen(newball);
		    remove(oldball);
		    oldball = newball;
		    //Moving the paddle
		    GObject newPaddle = start.paddle;
		    addToScreen(newPaddle);
		    remove(oldpaddle);
		    oldball = newball;
		    
		    start.drawBricks()
		    
		    
		    last_time = time;
		}
			 
			 
		 
	}
	public void addToScreen(GObject object) {
		add(object);
	}
}
