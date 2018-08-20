package training.java6.ocp.io.bin.thread;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

import training.patterns.producer_consumer.ConsumerThread;

public class ObjectInputThread extends ConsumerThread<ObjectInputStream> implements Runnable {

	public ObjectInputThread(InputStream in) throws IOException {
		super(new ObjectInputStream(in));
	}

	@Override
	public void run() {
		try {
			while (!Thread.currentThread().isInterrupted()) {
				if (in.available() > 0) {
					Object o = in.readObject();
					print(o);
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
