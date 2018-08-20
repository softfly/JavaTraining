package training.java6.ocp.io.bin;

import java.io.IOException;

import training.java6.ocp.io.bin.decorator.stream.SequenceStreamDecorator;
import training.java6.ocp.io.bin.decorator.thread.CountThreadDecorator;
import training.java6.ocp.io.bin.decorator.thread.SequenceCountThreadDecorator;
import training.patterns.producer_consumer.AbstractThreadComunicationDecorator;

public class SequenceCountStreamTraining {

	protected static CountThreadDecorator threadDecorator = new SequenceCountThreadDecorator();

	protected static AbstractThreadComunicationDecorator streamDecorator = new SequenceStreamDecorator(threadDecorator);

	public static void main(String[] args) throws IOException, InterruptedException {
		streamDecorator.main();
		System.out.println("PROGRAM TERMINATED");
	}

}
