package training.java6.ocp.io.bin.decorator.thread;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import training.java6.ocp.io.bin.thread.BufferedCountOutputThread;
import training.java6.ocp.io.bin.thread.BufferedTwiceInputThread;
import training.patterns.producer_consumer.AbstractThreadManagerDecorator;

public class BufferedTwiceThreadDecorator extends AbstractThreadManagerDecorator<OutputStream, InputStream> {

	@Override
	protected Runnable newWriteThread(OutputStream OUT) throws IOException {
		return new BufferedCountOutputThread(OUT);
	}

	@Override
	protected Runnable newReadThread(InputStream IN) throws IOException {
		return new BufferedTwiceInputThread(IN);
	}
}
