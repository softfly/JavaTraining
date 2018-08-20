package training.java6.ocp.concurrent;

import static org.junit.Assert.assertTrue;

import java.lang.Thread.State;

public class ConcurrentTimedWaitingStateTraining {

	static class ExampleSleepThread implements Runnable {
		@Override
		public void run() {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	static class ExampleJoinThread implements Runnable {

		Thread t;

		public ExampleJoinThread(Thread t) {
			this.t = t;
		}

		@Override
		public void run() {
			try {
				t.join();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ExampleSleepThread r1 = new ExampleSleepThread();
		Thread t1 = new Thread(r1);
		ExampleJoinThread r2 = new ExampleJoinThread(t1);
		Thread t2 = new Thread(r2);
		printState(t1, State.NEW);
		printState(t2, State.NEW);

		t1.start();
		t2.start();
		Thread.sleep(100);
		printState(t1, State.TIMED_WAITING);
		printState(t2, State.WAITING);

		t1.join();
		t2.join();
		printState(t1, State.TERMINATED);
		printState(t2, State.TERMINATED);
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
