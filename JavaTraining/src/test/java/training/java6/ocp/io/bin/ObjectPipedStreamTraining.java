package training.java6.ocp.io.bin;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import training.java6.ocp.io.bin.decorator.stream.PipedStreamDecorator;
import training.java6.ocp.io.bin.decorator.thread.ObjectThreadDecorator;
import training.patterns.producer_consumer.AbstractThreadComunicationDecorator;
import training.patterns.producer_consumer.AbstractThreadManagerDecorator;

public class ObjectPipedStreamTraining {

	protected static AbstractThreadManagerDecorator<OutputStream, InputStream> threadManagerD = new ObjectThreadDecorator();

	protected static AbstractThreadComunicationDecorator<OutputStream, InputStream> threadComunicationD = new PipedStreamDecorator(
			threadManagerD);

	public static void main(String[] args) throws IOException, InterruptedException {
		threadComunicationD.main();
		System.out.println("PROGRAM TERMINATED");
	}

}
