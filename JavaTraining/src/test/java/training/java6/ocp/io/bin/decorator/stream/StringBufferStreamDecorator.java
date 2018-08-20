package training.java6.ocp.io.bin.decorator.stream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringBufferInputStream;

import training.patterns.producer_consumer.AbstractThreadComunicationDecorator;
import training.patterns.producer_consumer.AbstractThreadManagerDecorator;

/**
 * @deprecated
 */
@Deprecated
public class StringBufferStreamDecorator extends AbstractThreadComunicationDecorator<OutputStream, InputStream> {

	public StringBufferStreamDecorator(AbstractThreadManagerDecorator<OutputStream, InputStream> threadDecorator) {
		super(threadDecorator);
	}

	@Override
	public void main() throws IOException, InterruptedException {
		ByteArrayOutputStream OUT = new ByteArrayOutputStream();
		threadDecorator.write(OUT);
		StringBufferInputStream IN = new StringBufferInputStream(OUT.toString());
		threadDecorator.read(IN);
	}

}
