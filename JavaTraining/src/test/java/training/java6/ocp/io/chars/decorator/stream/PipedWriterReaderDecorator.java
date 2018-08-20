package training.java6.ocp.io.chars.decorator.stream;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.Reader;
import java.io.Writer;

import training.patterns.producer_consumer.AbstractThreadComunicationDecorator;
import training.patterns.producer_consumer.AbstractThreadManagerDecorator;

public class PipedWriterReaderDecorator extends AbstractThreadComunicationDecorator<Writer, Reader> {

	public PipedWriterReaderDecorator(AbstractThreadManagerDecorator<Writer, Reader> threadDecorator) {
		super(threadDecorator);
	}

	@Override
	public void main() throws IOException, InterruptedException {
		PipedWriter w = new PipedWriter();
		PipedReader r = new PipedReader();
		r.connect(w);
		threadDecorator.writeRead(r, w);

	}

}
