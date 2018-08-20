package training.java6.ocp.concurrent;

import static org.junit.Assert.assertTrue;

import java.lang.Thread.State;

public class ConcurrentWaitingStateTraining {

	static class ExampleThread implements Runnable {

		@Override
		public void run() {
			try {
				synchronized (ConcurrentWaitingStateTraining.class) {
					ConcurrentWaitingStateTraining.class.wait();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ExampleThread r1 = new ExampleThread();
		ExampleThread r2 = new ExampleThread();
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		printState(t1, State.NEW);
		printState(t2, State.NEW);

		t1.start();
		t2.start();
		Thread.sleep(100);
		printState(t1, State.WAITING);
		printState(t2, State.WAITING);

		synchronized (ConcurrentWaitingStateTraining.class) {
			// ConcurrentWaitingStateTraining.class.notify();
			// ConcurrentWaitingStateTraining.class.notify();
			ConcurrentWaitingStateTraining.class.notifyAll();
		}

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
