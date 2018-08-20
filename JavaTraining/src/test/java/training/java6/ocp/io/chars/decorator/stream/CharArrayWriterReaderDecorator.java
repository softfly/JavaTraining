package training.java6.ocp.io.chars.decorator.stream;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import training.patterns.producer_consumer.AbstractThreadComunicationDecorator;
import training.patterns.producer_consumer.AbstractThreadManagerDecorator;

public class CharArrayWriterReaderDecorator extends AbstractThreadComunicationDecorator<Writer, Reader> {

	public CharArrayWriterReaderDecorator(AbstractThreadManagerDecorator<Writer, Reader> threadDecorator) {
		super(threadDecorator);
	}

	@Override
	public void main() throws IOException, InterruptedException {
		CharArrayWriter OUT = new CharArrayWriter();
		threadDecorator.write(OUT);
		CharArrayReader IN = new CharArrayReader(OUT.toCharArray());
		threadDecorator.read(IN);
	}

}
