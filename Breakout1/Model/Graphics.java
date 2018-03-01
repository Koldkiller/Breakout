package Model;

import java.awt.Color;

import acm.graphics.*;

public class Graphics {

	public static GRect drawPaddle(int x, int y) {
		GRect paddle = new GRect(x, y, start.PADDLE_WIDTH,start.PADDLE_HEIGHT);
		paddle.setColor(new Color(0, 0, 0));
		paddle.setFilled(true);
		return paddle;
	}

	public static GOval drawBall(int x, int y) {
		GOval ball = new GOval(x, y, start.BALL_RAD, start.BALL_RAD);
		ball.setColor(new Color(0, 0, 0));
		ball.setFilled(true);
		return ball;
	}

	public static GRect drawBrick(int x, int y) {

		GRect brick = new GRect(x, y, start.BRICK_WIDTH, start.BRICK_HEIGHT);
		// Change colors for bricks somehow
		brick.setColor(new Color(0, 0, 0));
		brick.setFilled(true);
		return brick;
	}

}
