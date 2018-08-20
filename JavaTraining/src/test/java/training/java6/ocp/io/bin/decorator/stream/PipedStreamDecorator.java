package training.java6.ocp.io.bin.decorator.stream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import training.patterns.producer_consumer.AbstractThreadComunicationDecorator;
import training.patterns.producer_consumer.AbstractThreadManagerDecorator;

public class PipedStreamDecorator extends AbstractThreadComunicationDecorator<OutputStream, InputStream> {

	public PipedStreamDecorator(AbstractThreadManagerDecorator<OutputStream, InputStream> threadDecorator) {
		super(threadDecorator);
	}

	@Override
	public void main() throws IOException, InterruptedException {
		PipedOutputStream OUT = new PipedOutputStream();
		PipedInputStream IN = new PipedInputStream();
		OUT.connect(IN);
		threadDecorator.writeRead(IN, OUT);
	}

}
