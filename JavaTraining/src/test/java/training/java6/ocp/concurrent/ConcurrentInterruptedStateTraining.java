package training.java6.ocp.concurrent;

import static org.junit.Assert.assertTrue;

import java.lang.Thread.State;

public class ConcurrentInterruptedStateTraining {

	static class ExampleThread implements Runnable {

		@Override
		public void run() {
			try {
				while (true) {
					if (Thread.interrupted()) {
						return;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ExampleThread r1 = new ExampleThread();
		Thread t1 = new Thread(r1);
		printState(t1, State.NEW);

		t1.start();
		Thread.sleep(100);
		printState(t1, State.RUNNABLE);

		t1.interrupt();

		t1.join();
		printState(t1, State.TERMINATED);
		System.out.println("PROGRAM TERMINATED");
	}

	protected static void printState(Thread t) {
		System.out.println(new StringBuilder(t.getName()).append(": ").append(t.getState()).toString());
	}

	protected static void printState(Thread t, State s) {
		printState(t);
		assertTrue(s.equals(t.getState()));
	}

}
