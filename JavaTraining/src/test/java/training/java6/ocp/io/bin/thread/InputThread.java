package training.java6.ocp.io.bin.thread;

import java.io.IOException;
import java.io.InputStream;

import training.patterns.producer_consumer.ConsumerThread;

public class InputThread extends ConsumerThread<InputStream> implements Runnable {

	public InputThread(InputStream in) throws IOException {
		super(in);
	}

	@Override
	public void run() {
		try {
			while (!Thread.currentThread().isInterrupted()) {
				if (in.available() > 0) {
					int i = in.read();
					if (i > 0) {
						print(i);
					}
				}
				Thread.yield();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			printTerminated();
		}
	}
}
