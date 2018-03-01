package Model;

import java.awt.Color;

import Control.Collision;
import Control.askforkey;
import View.PlayGame;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.io.IODialog;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class start extends GraphicsProgram {
	RandomGenerator rgen = new RandomGenerator();
	public static GRect paddle = null;
	public static GOval ball = null;
	public static int brick_counter = 0;
	public static int level = 0;// rgen.nextInt(0, 2);
	private static PlayGame game = new PlayGame();
	public static final int WINDOW_WIDTH = 400;
	public static final int WINDOW_HEIGHT = 800;
	public static final int PADDLE_WIDTH = 40;
	public static final int PADDLE_HEIGHT = 10;
	public static final int BALL_RAD = 20;
	public static final int BRICK_WIDTH = 30;
	public static final int BRICK_HEIGHT = 40;

	public start() {
		run();
	}

	public void run() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		drawtheGame();
		addKeyListeners();
		play();
	}

	public void drawtheGame() {
		// Both still wrong size
		paddle = Graphics.drawPaddle((WINDOW_WIDTH / 2) - (PADDLE_WIDTH / 2), WINDOW_HEIGHT - (WINDOW_HEIGHT / 5));
		add(paddle);
		ball = Graphics.drawBall((WINDOW_WIDTH / 2), WINDOW_HEIGHT - (WINDOW_HEIGHT / 5) - BALL_RAD);
		ball.setColor(new Color(250, 0, 0));
		add(ball);

	}

	public void play() {
		waitForClick();
		while (true) {
			game.update();
			askforkey.keyTyped(null);
			Movement e = new Movement();
			e.movementBall();
			if (ball.getY() >= WINDOW_HEIGHT) {
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

	public static void drawBricks() {
		// TODO Auto-generated method stub
		switch (level) {
		case (0):
			// First Level
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 11; j++) {
					if (j % 3 == 0) {
					} else {

						int y = 20 + j * BRICK_HEIGHT;
						int x = i * BRICK_WIDTH;
						GRect ziegel = Graphics.drawBrick(x, y);

						ziegel.setFillColor(new Color(0, 255 / (j + 1), 0));
						game.addToScreen(ziegel);
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

				int x = BRICK_WIDTH * (i + 2);
				int y = BRICK_HEIGHT * j;
				int x1 = BRICK_WIDTH * (6 - i);
				GRect ziegel1 = Graphics.drawBrick(x, y);
				GRect ziegel11 = Graphics.drawBrick(x1, y);
				++j;
				y = BRICK_HEIGHT * j;
				GRect ziegel2 = Graphics.drawBrick(x, y);
				GRect ziegel21 = Graphics.drawBrick(x1, y);
				game.addToScreen(ziegel1);
				game.addToScreen(ziegel2);
				game.addToScreen(ziegel11);
				game.addToScreen(ziegel21);
				brick_counter = brick_counter + 4;
				j++;
			}
			int k = 10;
			for (int l = 0; l < 5; l++) {
				int x = BRICK_WIDTH * (l + 2);
				int y = BRICK_HEIGHT * k;
				int x1 = BRICK_WIDTH * (6 - l);
				GRect ziegel4 = Graphics.drawBrick(x, y);
				GRect ziegel41 = Graphics.drawBrick(x1, y);
				++k;
				y = BRICK_HEIGHT * k;
				GRect ziegel5 = Graphics.drawBrick(x, y);
				GRect ziegel51 = Graphics.drawBrick(x1, y);
				game.addToScreen(ziegel4);
				game.addToScreen(ziegel41);
				game.addToScreen(ziegel5);
				game.addToScreen(ziegel51);
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

}
