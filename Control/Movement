package Control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Model.C;
import View.PlayGame;

public class Movement implements KeyListener, Runnable {
	public static int vPaddel = 0;

	public void movementBall() {
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
			PlayGame.ball.move(vx, vy);
			if ((PlayGame.ball.getX() - vx <= 0 && vx < 0)
					|| (PlayGame.ball.getX() + vx >= (C.WINDOW_WIDTH) - C.BALL_RAD * 2) && vx > 0) {
				vx = vx * -1;
			} // Collision wall

			if (e.getCollider(PlayGame.ball) == PlayGame.paddle) {
				vy = vy * -1;
			} // Collision paddle

			if (e.getCollider(PlayGame.ball) != null) {
				vy = vy * -1;
				PlayGame.brick_counter--;
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
	public void keyTyped(KeyEvent e) {
		// move paddle left and right here blablabla

		if (e.getKeyChar() == 'a' || e.getKeyChar() == 'A') {
			if (!(PlayGame.paddle.getX() <= 0)) {
				paddleMove(-5);

			}
		}

		if (e.getKeyChar() == 'd' || e.getKeyChar() == 'D') {
			if (!(PlayGame.paddle.getX() > (C.WINDOW_WIDTH - C.PADDLE_WIDTH))) {
				paddleMove(5);
			}
		}

	}

	private void paddleMove(int i) {
		// TODO Auto-generated method stub
		PlayGame.paddle.move(i, 0);
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
	public void run() {
		// TODO Auto-generated method stub

	}

}
