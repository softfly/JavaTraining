package training.java6.ocp.io.chars.decorator.stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.Reader;
import java.io.Writer;

import training.patterns.producer_consumer.AbstractThreadComunicationDecorator;
import training.patterns.producer_consumer.AbstractThreadManagerDecorator;

public class StreamWriterReaderDecorator extends AbstractThreadComunicationDecorator<Writer, Reader> {

	public StreamWriterReaderDecorator(AbstractThreadManagerDecorator<Writer, Reader> threadDecorator) {
		super(threadDecorator);
	}

	@Override
	public void main() throws IOException, InterruptedException {
		PipedOutputStream pos = new PipedOutputStream();
		PipedInputStream pis = new PipedInputStream(pos);

		Reader r = new InputStreamReader(pis);
		Writer w = new OutputStreamWriter(pos);

		new BufferedReader(new InputStreamReader(System.in));
		new BufferedWriter(new OutputStreamWriter(System.out));

		threadDecorator.writeRead(r, w);

	}

}
