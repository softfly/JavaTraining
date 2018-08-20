package training.java6.ocp.io.bin.decorator.stream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import training.patterns.producer_consumer.AbstractThreadComunicationDecorator;
import training.patterns.producer_consumer.AbstractThreadManagerDecorator;

public class PrintStreamDecorator extends AbstractThreadComunicationDecorator<OutputStream, InputStream> {

	public PrintStreamDecorator(AbstractThreadManagerDecorator<OutputStream, InputStream> threadDecorator) {
		super(threadDecorator);
	}

	@Override
	public void main() throws IOException, InterruptedException {
		threadDecorator.write(new PrintStream(System.out));
	}

}
