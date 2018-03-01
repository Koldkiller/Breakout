package Control;

import java.awt.event.KeyEvent;
import Model.start;

public class askforkey {

	public askforkey() {
		// TODO Auto-generated constructor stub
	}

	public static void keyTyped(KeyEvent e) {
		// move paddle left and right here

		if (e.getKeyChar() == 'a' || e.getKeyChar() == 'A') {
			if (!(start.paddle.getX() <= 0)) {
				paddleMove(-5);

			}
		}

		if (e.getKeyChar() == 'd' || e.getKeyChar() == 'D') {
			if (!(start.paddle.getX() > (start.WINDOW_WIDTH - start.PADDLE_WIDTH))) {
				paddleMove(5);
			}
		}

	}

	private static void paddleMove(int i) {
		// TODO Auto-generated method stub
		start.paddle.move(i, 0);
	}

}
