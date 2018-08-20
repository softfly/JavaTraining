package training.java6.ocp.io.bin.decorator.thread;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import training.java6.ocp.io.bin.thread.CountOutputThread;
import training.java6.ocp.io.bin.thread.InputThread;
import training.patterns.producer_consumer.AbstractThreadManagerDecorator;

public class CountThreadDecorator extends AbstractThreadManagerDecorator<OutputStream, InputStream> {

	@Override
	protected Runnable newWriteThread(OutputStream OUT) throws IOException {
		return new CountOutputThread(OUT);
	}

	@Override
	protected Runnable newReadThread(InputStream IN) throws IOException {
		return new InputThread(IN);
	}
}
