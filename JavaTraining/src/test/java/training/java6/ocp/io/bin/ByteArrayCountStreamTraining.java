package training.java6.ocp.io.bin;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import training.java6.ocp.io.bin.decorator.stream.ByteArrayStreamDecorator;
import training.java6.ocp.io.bin.decorator.thread.CountThreadDecorator;
import training.patterns.producer_consumer.AbstractThreadComunicationDecorator;
import training.patterns.producer_consumer.AbstractThreadManagerDecorator;

public class ByteArrayCountStreamTraining {

	protected static AbstractThreadManagerDecorator<OutputStream, InputStream> threadManagerD = new CountThreadDecorator();

	protected static AbstractThreadComunicationDecorator<OutputStream, InputStream> threadComunicationD = new ByteArrayStreamDecorator(
			threadManagerD);

	public static void main(String[] args) throws IOException, InterruptedException {
		threadComunicationD.main();
		System.out.println("PROGRAM TERMINATED");
	}
}
