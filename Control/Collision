package Control;

import Model.C;
import acm.graphics.*;
import acm.program.GraphicsProgram;

public class Collision extends GraphicsProgram {
	// might need a constructor here, to call the function or we do like new
	// Collision = e; e.getCollider()

	public GObject getCollider(GObject ball) {
		// Top left of Ball
		if ((getElementAt(ball.getX(), ball.getY())) != null) {
			return getElementAt(ball.getX(), ball.getY());
		}
		// Top right of Ball
		else if (getElementAt((ball.getX() + C.BALL_RAD * 2), ball.getY()) != null) {
			return getElementAt(ball.getX() + C.BALL_RAD * 2, ball.getY());
		}
		// Bottom left of Ball
		else if (getElementAt(ball.getX(), (ball.getY() + C.BALL_RAD * 2)) != null) {
			return getElementAt(ball.getX(), ball.getY() + C.BALL_RAD * 2);
		}
		// Bottom right of Ball
		else if (getElementAt((ball.getX() + C.BALL_RAD * 2), (ball.getY() + C.BALL_RAD * 2)) != null) {
			return getElementAt(ball.getX() + C.BALL_RAD * 2, ball.getY() + C.BALL_RAD * 2);
		}
		// need to return null if there are no objects present
		else {
			return null;
		}
	}
}
