package training.java6.ocp.io.chars.thread;

import java.io.IOException;
import java.io.Writer;

import training.patterns.producer_consumer.ProducerThread;

public class CountWriterThread extends ProducerThread<Writer> implements Runnable {

	protected static int count = 0;

	public CountWriterThread(Writer out) throws IOException {
		super(out);
	}

	@Override
	public void run() {
		try {
			while (!Thread.currentThread().isInterrupted()) {
				int count = count();
				out.write(count);
				out.flush();
				print(count);
				try {
					Thread.sleep(500);
				} catch (InterruptedException ex) {
					Thread.currentThread().interrupt();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			printTerminated();
		}
	}

	protected static synchronized int count() {
		return ++count;
	}
}
