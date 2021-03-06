package View;

import java.awt.Color;
import java.awt.event.KeyEvent;

import Control.Collision;
import Control.Movement;
import Model.C;
import Model.Graphics;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.io.IODialog;
import acm.program.*;
import acm.util.RandomGenerator;

public class PlayGame extends GraphicsProgram {
	RandomGenerator rgen = new RandomGenerator();
	public static GRect paddle = null;
	public static GOval ball = null;
	public static int brick_counter = 0;
	public Thread Move = new Thread(new Movement());
	public Thread askCollision = new Thread(new Collision());

	public void run() {
		setSize(C.WINDOW_WIDTH, C.WINDOW_HEIGHT);
		drawtheGame();
		addKeyListeners();
		play();

	}

	public void keyTyped(KeyEvent e) {
		// move paddle left and right here blablabla

		if (e.getKeyChar() == 'a' || e.getKeyChar() == 'A') {
			if (!(PlayGame.paddle.getX() <= 0)) {
				Movement.paddleMove(-5);

			}
		}

		if (e.getKeyChar() == 'd' || e.getKeyChar() == 'D') {
			if (!(PlayGame.paddle.getX() > (C.WINDOW_WIDTH - C.PADDLE_WIDTH))) {
				Movement.paddleMove(5);
			}
		}

	}

	public void drawtheGame() {
		// Both still wrong size
		paddle = Graphics.drawPaddle((C.WINDOW_WIDTH / 2) - (C.PADDLE_WIDTH / 2),
				C.WINDOW_HEIGHT - (C.WINDOW_HEIGHT / 5));
		add(paddle);
		ball = Graphics.drawBall((C.WINDOW_WIDTH / 2), C.WINDOW_HEIGHT - (C.WINDOW_HEIGHT / 5) - C.BALL_RAD);
		ball.setColor(new Color(250, 0, 0));
		add(ball);
		int level = 0;// rgen.nextInt(0, 2);
		switch (level) {
		case (0):
			// First Level
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 11; j++) {
					if (j % 3 == 0) {
					} else {

						int y = 20 + j * C.BRICK_HEIGHT;
						int x = i * C.BRICK_WIDTH;
						GRect ziegel = Graphics.drawBrick(x, y);

						ziegel.setFillColor(new Color(0, 255 / (j + 1), 0));
						add(ziegel);
						brick_counter++;

					}
				}

			}
			break;

		case (1):
			// Map 2
			// Looks ok, needs Color though
			int j = 0;
			for (int i = 0; i < 5; i++) {

				int x = C.BRICK_WIDTH * (i + 2);
				int y = C.BRICK_HEIGHT * j;
				int x1 = C.BRICK_WIDTH * (6 - i);
				GRect ziegel1 = Graphics.drawBrick(x, y);
				GRect ziegel11 = Graphics.drawBrick(x1, y);
				++j;
				y = C.BRICK_HEIGHT * j;
				GRect ziegel2 = Graphics.drawBrick(x, y);
				GRect ziegel21 = Graphics.drawBrick(x1, y);
				add(ziegel1);
				add(ziegel2);
				add(ziegel11);
				add(ziegel21);
				brick_counter = brick_counter + 4;
				j++;
			}
			int k = 10;
			for (int l = 0; l < 5; l++) {
				int x = C.BRICK_WIDTH * (l + 2);
				int y = C.BRICK_HEIGHT * k;
				int x1 = C.BRICK_WIDTH * (6 - l);
				GRect ziegel4 = Graphics.drawBrick(x, y);
				GRect ziegel41 = Graphics.drawBrick(x1, y);
				++k;
				y = C.BRICK_HEIGHT * k;
				GRect ziegel5 = Graphics.drawBrick(x, y);
				GRect ziegel51 = Graphics.drawBrick(x1, y);
				add(ziegel4);
				add(ziegel41);
				add(ziegel5);
				add(ziegel51);
				brick_counter = brick_counter + 4;
				k++;

			}
			break;

		case (2):
			// Map 3

		default:
			throw new IllegalArgumentException("Something went srsly wrong with the Randomgenerator");
		}

	}

	public void play() {
		waitForClick();
		while (true) {

			Movement e = new Movement();
			e.movementBall();
			if (ball.getY() >= C.WINDOW_HEIGHT) {
				gameOver();
				break;
			}
			if (brick_counter == 0) {
				winner();
				break;
			}
		}
	}

	private void winner() {
		IODialog winner = new IODialog();
		ball.setVisible(false);
		winner.print("You Win!");

	}

	private void gameOver() {
		IODialog gameOver = new IODialog();
		ball.setVisible(false);
		gameOver.print("You Lost!");
	}

}
