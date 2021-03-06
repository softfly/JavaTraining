package training.java6.ocp.io.chars.decorator.thread;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import training.java6.ocp.io.chars.thread.CountWriterThread;
import training.java6.ocp.io.chars.thread.ReaderThread;
import training.patterns.producer_consumer.AbstractThreadManagerDecorator;

public class CountThreadDecorator extends AbstractThreadManagerDecorator<Writer, Reader> {

	@Override
	protected Runnable newWriteThread(Writer OUT) throws IOException {
		return new CountWriterThread(OUT);
	}

	@Override
	protected Runnable newReadThread(Reader IN) throws IOException {
		return new ReaderThread(IN);
	}

}
