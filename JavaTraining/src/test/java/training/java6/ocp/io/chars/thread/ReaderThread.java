package training.java6.ocp.io.chars.thread;

import java.io.IOException;
import java.io.Reader;

import training.patterns.producer_consumer.ConsumerThread;

public class ReaderThread extends ConsumerThread<Reader> {

	/**
	 * Limit max chars in row line.
	 */
	protected final static int LIMIT_MAX = String.valueOf(Long.MAX_VALUE).length();

	public ReaderThread(Reader in) throws IOException {
		super(in);
	}

	@Override
	public void run() {
		try {
			while (!Thread.currentThread().isInterrupted()) {
				try {
					if (in.ready()) {
						int i;
						if ((i = in.read()) > -1) {
							print(i);
						}
					}
				} catch (IOException e) {
					break;
				}
				Thread.yield();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			printTerminated();
		}
	}

	public void run2() {
		try {
			while (in.ready()) {
				int c = in.read();
				if (c != -1) {
					char[] cb = new char[LIMIT_MAX];
					for (int i = 0; i < LIMIT_MAX; i++) {
						if (c == -1) {
							break;
						} else if ((char) c == '\n') {
							// cb[i] = '\n';
							break;
						} else {
							cb[i] = (char) c;
							c = in.read();
						}
						if (i > LIMIT_MAX) {
							throw new RuntimeException(
									new StringBuilder("overflow max line=").append(LIMIT_MAX).toString());
						}
					}
					System.out.println(new StringBuilder("Reader").append(id).append(": ").append(cb));
				} else {
					return;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			printTerminated();
		}
	}

}
