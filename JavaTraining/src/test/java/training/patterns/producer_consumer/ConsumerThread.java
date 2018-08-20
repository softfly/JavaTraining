package training.patterns.producer_consumer;

import java.io.IOException;

public abstract class ConsumerThread<T> implements Runnable {

	protected final int id = ++NUM;

	protected static int NUM = 0;

	protected T in;

	public ConsumerThread(T in) throws IOException {
		this.in = in;
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
		return new StringBuilder("READER").append(id).append("  ");
	}
}
