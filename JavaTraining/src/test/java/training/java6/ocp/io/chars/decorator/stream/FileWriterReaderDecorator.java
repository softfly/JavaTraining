package training.java6.ocp.io.chars.decorator.stream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import training.patterns.producer_consumer.AbstractThreadComunicationDecorator;
import training.patterns.producer_consumer.AbstractThreadManagerDecorator;

public class FileWriterReaderDecorator extends AbstractThreadComunicationDecorator<Writer, Reader> {

	protected final static String FILE_PATH = "t.tmp";

	public FileWriterReaderDecorator(AbstractThreadManagerDecorator<Writer, Reader> threadDecorator) {
		super(threadDecorator);
	}

	@Override
	public void main() throws IOException, InterruptedException {
		FileWriter OUT = new FileWriter(FILE_PATH);
		FileReader IN = new FileReader(FILE_PATH);
		threadDecorator.writeRead(IN, OUT);
	}

}
