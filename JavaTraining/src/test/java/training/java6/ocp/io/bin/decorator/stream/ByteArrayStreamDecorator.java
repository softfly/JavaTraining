package training.java6.ocp.io.bin.decorator.stream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import training.patterns.producer_consumer.AbstractThreadComunicationDecorator;
import training.patterns.producer_consumer.AbstractThreadManagerDecorator;

public class ByteArrayStreamDecorator extends AbstractThreadComunicationDecorator<OutputStream, InputStream> {

	public ByteArrayStreamDecorator(AbstractThreadManagerDecorator<OutputStream, InputStream> threadDecorator) {
		super(threadDecorator);
	}

	@Override
	public void main() throws IOException, InterruptedException {
		ByteArrayOutputStream OUT = new ByteArrayOutputStream();
		threadDecorator.write(OUT);
		ByteArrayInputStream IN = new ByteArrayInputStream(OUT.toByteArray());
		threadDecorator.read(IN);
	}

}
