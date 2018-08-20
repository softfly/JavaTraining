package training.java6.ocp.io.bin.thread;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import training.java6.ocp.io.bin.Contact;
import training.patterns.producer_consumer.ProducerThread;

public class ObjectOutputThread extends ProducerThread<ObjectOutputStream> implements Runnable {

	public ObjectOutputThread(OutputStream out) throws IOException {
		super(new ObjectOutputStream(out));
	}

	@Override
	public void run() {
		try {
			while (!Thread.currentThread().isInterrupted()) {
				Object o = new Contact("John Smith");
				print(o);
				out.writeObject(o);
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
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			printTerminated();
		}
	}
}
