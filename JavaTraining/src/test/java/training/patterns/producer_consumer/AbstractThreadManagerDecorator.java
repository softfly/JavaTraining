package training.patterns.producer_consumer;

import java.io.IOException;

public abstract class AbstractThreadManagerDecorator<OUT, IN> {

	protected final static int THREAD_WRITE_NUM = 1;

	protected final static int THREAD_READ_NUM = 1;

	public void write(OUT OUT) throws IOException, InterruptedException {
		Thread[] wt = new Thread[getThreadWriteNum()];
		for (int i = 0; i < wt.length; i++) {
			wt[i] = new Thread(newWriteThread(OUT));
		}
		start(wt);
		Thread.sleep(5000);
		interrupt(wt);
		join(wt);
	}

	public void read(IN IN) throws IOException, InterruptedException {
		Thread[] rt = new Thread[getThreadReadNum()];
		for (int i = 0; i < rt.length; i++) {
			rt[i] = new Thread(newReadThread(IN));
		}
		start(rt);
		Thread.sleep(1000);
		interrupt(rt);
		join(rt);
	}

	public void writeRead(IN IN, OUT OUT) throws IOException, InterruptedException {
		Thread[] wt = new Thread[getThreadWriteNum()];
		for (int i = 0; i < wt.length; i++) {
			wt[i] = new Thread(newWriteThread(OUT));
		}
		Thread[] rt = new Thread[getThreadReadNum()];
		for (int i = 0; i < rt.length; i++) {
			rt[i] = new Thread(newReadThread(IN));
		}
		start(wt);
		start(rt);
		Thread.sleep(5000);

		interrupt(wt);
		join(wt);

		Thread.sleep(2000);
		interrupt(rt);
		join(rt);
	}

	protected static void start(Thread... threads) throws InterruptedException {
		for (Thread t : threads) {
			t.start();
		}
	}

	protected static void interrupt(Thread... threads) throws InterruptedException {
		for (Thread t : threads) {
			t.interrupt();
		}
	}

	protected static void join(Thread... threads) throws InterruptedException {
		for (Thread t : threads) {
			t.join();
		}
	}

	protected int getThreadWriteNum() {
		return THREAD_WRITE_NUM;
	}

	protected int getThreadReadNum() {
		return THREAD_READ_NUM;
	}

	protected abstract Runnable newWriteThread(OUT OUT) throws IOException;

	protected abstract Runnable newReadThread(IN IN) throws IOException;


}
