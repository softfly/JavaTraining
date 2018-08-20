package training.java6.ocp.io.chars.decorator.stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import training.patterns.producer_consumer.AbstractThreadComunicationDecorator;
import training.patterns.producer_consumer.AbstractThreadManagerDecorator;

public class BufferedFileWriterReaderDecorator extends AbstractThreadComunicationDecorator<Writer, Reader> {

	protected final static String FILE_PATH = "t.tmp";

	public BufferedFileWriterReaderDecorator(AbstractThreadManagerDecorator<Writer, Reader> threadDecorator) {
		super(threadDecorator);
	}

	@Override
	public void main() throws IOException, InterruptedException {
		FileWriter fw = new FileWriter(FILE_PATH);
		FileReader fr = new FileReader(FILE_PATH);
		BufferedWriter bw = new BufferedWriter(fw);
		BufferedReader br = new BufferedReader(fr);
		threadDecorator.writeRead(br, bw);
	}

}
