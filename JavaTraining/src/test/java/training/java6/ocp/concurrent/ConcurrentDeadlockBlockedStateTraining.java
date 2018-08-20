package training.java6.ocp.concurrent;

import static org.junit.Assert.assertTrue;

import java.lang.Thread.State;

public class ConcurrentDeadlockBlockedStateTraining {

	static class BankAccount {

		private double balance;

		public BankAccount(double balance) {
			this.balance = balance;
		}

		public synchronized void withdraw(double amount) {
			System.out.println(getStringBuilder().append("Making a withdrawal: ").append(amount).toString());
			this.balance -= amount;
		}

		public synchronized void deposit(double amount) {
			System.out.println(getStringBuilder().append("Making a deposit: ").append(amount).toString());
			this.balance += amount;
		}

		public double getBalance() {
			return balance;
		}

		protected StringBuilder getStringBuilder() {
			return new StringBuilder(Thread.currentThread().getName()).append(": ");
		}
	}

	static class ExchangeThread implements Runnable {

		private BankAccount src;

		private BankAccount dest;

		private double amount;

		public ExchangeThread(BankAccount src, BankAccount dest, double amount) {
			this.src = src;
			this.dest = dest;
			this.amount = amount;
		}

		@Override
		public void run() {
			try {
				synchronized (src) {
					Thread.yield();
					Thread.sleep(1);
					synchronized (dest) {
						src.withdraw(amount);
						dest.deposit(amount);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(new StringBuilder(Thread.currentThread().getName()).append(": TERMINATED").toString());
		}
	}

	public static void main(String[] args) throws InterruptedException {
		BankAccount a1 = new BankAccount(1000);
		BankAccount a2 = new BankAccount(1000);

		ExchangeThread r1 = new ExchangeThread(a1, a2, 500);
		Thread t1 = new Thread(r1);
		ExchangeThread r2 = new ExchangeThread(a2, a1, 450);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();

		Thread.sleep(2);
		printState(t1, State.BLOCKED);
		printState(t2, State.BLOCKED);

		t1.join();
		t2.join();
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
