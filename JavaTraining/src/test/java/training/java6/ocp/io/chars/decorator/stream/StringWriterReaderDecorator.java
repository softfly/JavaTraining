package training.java6.ocp.io.chars.decorator.stream;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import training.patterns.producer_consumer.AbstractThreadComunicationDecorator;
import training.patterns.producer_consumer.AbstractThreadManagerDecorator;

public class StringWriterReaderDecorator extends AbstractThreadComunicationDecorator<Writer, Reader> {

	public StringWriterReaderDecorator(AbstractThreadManagerDecorator<Writer, Reader> threadDecorator) {
		super(threadDecorator);
	}

	@Override
	public void main() throws IOException, InterruptedException {
		StringWriter OUT = new StringWriter();
		threadDecorator.write(OUT);
		StringReader IN = new StringReader(OUT.toString());
		threadDecorator.read(IN);
	}

}
