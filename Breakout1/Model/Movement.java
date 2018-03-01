package Model;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Control.Collision;
import View.PlayGame;

public class Movement implements KeyListener, Runnable {
	public static int vPaddel = 0;

	public static void movementBall() {
		Collision e = new Collision();
		double vx = 0;
		double vy = 0;
		boolean firstmovement = true;

		if (firstmovement != false) {
			vx = Math.random();
			vy = -1 * Math.random();
			firstmovement = false;
		}

		while (true) {
			start.ball.move(vx, vy);
			if ((start.ball.getX() - vx <= 0 && vx < 0)
					|| (start.ball.getX() + vx >= (start.WINDOW_WIDTH) - start.BALL_RAD * 2) && vx > 0) {
				vx = vx * -1;
			} // Collision wall

			if (e.getCollider(start.ball) == start.paddle) {
				vy = vy * -1;
			} // Collision paddle

			if (e.getCollider(start.ball) != null) {
				vy = vy * -1;
				start.brick_counter--;
			} // Collision Brick
			try {
				Thread.sleep(10);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		// ball.move(vx, vy)
		// if he collides with one of the side walls then vx = -vx
		// if he collides with the top wall then vy = -vy
		// also maybe call collision here and find out what the colliding object is and
		// do what needs to be done
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
