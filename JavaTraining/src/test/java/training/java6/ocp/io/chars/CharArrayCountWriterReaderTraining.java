package training.java6.ocp.io.chars;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import training.java6.ocp.io.chars.decorator.stream.CharArrayWriterReaderDecorator;
import training.java6.ocp.io.chars.decorator.thread.CountThreadDecorator;
import training.patterns.producer_consumer.AbstractThreadComunicationDecorator;
import training.patterns.producer_consumer.AbstractThreadManagerDecorator;

public class CharArrayCountWriterReaderTraining {

	protected static AbstractThreadManagerDecorator<Writer, Reader> threadManagerD = new CountThreadDecorator();

	protected static AbstractThreadComunicationDecorator<Writer, Reader> threadComunicationD = new CharArrayWriterReaderDecorator(
			threadManagerD);

	public static void main(String[] args) throws IOException, InterruptedException {
		threadComunicationD.main();
		System.out.println("PROGRAM TERMINATED");
	}
}
