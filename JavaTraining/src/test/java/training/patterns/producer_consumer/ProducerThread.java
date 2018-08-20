package training.patterns.producer_consumer;

import java.io.IOException;

public abstract class ProducerThread<T> implements Runnable {

	protected final int id = ++NUM;

	protected static int NUM = 0;

	protected T out;


	public ProducerThread(T out) throws IOException {
		this.out = out;
		printCreate();
	}

	protected void printCreate() {
		System.out.println(printBuilder().append(" CREATE"));
	}

	protected void print(Object o) {
		System.out.println(printBuilder().append(": ").append(o));
	}

	protected void printTerminated() {
		System.out.println(printBuilder().append(" TERMINATED"));
	}

	protected StringBuilder printBuilder() {
		return new StringBuilder("PRODUCER").append(id);
	}
}
