package training.java6.ocp.io.bin.thread;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import training.patterns.producer_consumer.ConsumerThread;

public class BufferedTwiceInputThread extends ConsumerThread<BufferedInputStream> implements Runnable {


	public BufferedTwiceInputThread(InputStream in) throws IOException {
		super(new BufferedInputStream(in));
	}

	@Override
	public void run() {
		try {
			while (!Thread.currentThread().isInterrupted()) {
				in.mark(1);
				if (in.available() > 0) {
					int i = in.read();
					if (i > 0) {
						print(i);
					}
				}
				in.reset();
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
