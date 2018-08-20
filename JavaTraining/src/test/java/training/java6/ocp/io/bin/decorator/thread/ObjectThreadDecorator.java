package training.java6.ocp.io.bin.decorator.thread;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import training.java6.ocp.io.bin.thread.ObjectInputThread;
import training.java6.ocp.io.bin.thread.ObjectOutputThread;
import training.patterns.producer_consumer.AbstractThreadManagerDecorator;

public class ObjectThreadDecorator extends AbstractThreadManagerDecorator<OutputStream, InputStream> {

	@Override
	protected Runnable newWriteThread(OutputStream OUT) throws IOException {
		return new ObjectOutputThread(OUT);
	}

	@Override
	protected Runnable newReadThread(InputStream IN) throws IOException {
		return new ObjectInputThread(IN);
	}

}
