package training.java6.ocp.io.chars.decorator.stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import training.patterns.producer_consumer.AbstractThreadComunicationDecorator;
import training.patterns.producer_consumer.AbstractThreadManagerDecorator;

public class FileDescriptorWriterReaderDecorator extends AbstractThreadComunicationDecorator<Writer, Reader> {

	protected final static String FILE_PATH = "t.tmp";

	public FileDescriptorWriterReaderDecorator(AbstractThreadManagerDecorator<Writer, Reader> threadDecorator) {
		super(threadDecorator);
	}

	@Override
	public void main() throws IOException, InterruptedException {
		FileOutputStream OUTs = new FileOutputStream(FILE_PATH);
		FileWriter OUT = new FileWriter(OUTs.getFD());

		FileInputStream INs = new FileInputStream(FILE_PATH);
		FileReader IN = new FileReader(INs.getFD());

		threadDecorator.writeRead(IN, OUT);
	}

}
