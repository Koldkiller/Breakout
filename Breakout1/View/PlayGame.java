package View;

import acm.program.GraphicsProgram;

public class PlayGame extends GraphicsProgram {
	public static boolean running = false;

	public PlayGame() {
		running = true;
		update();
	}

	public static void update() {
		long vtime = System.nanoTime(); // nano second to milli second

		while (running) {
			long time = System.nanoTime();
			int delta_time = (int) ((time - vtime) / 1000000);
			vtime = time;
		}
	}

}
