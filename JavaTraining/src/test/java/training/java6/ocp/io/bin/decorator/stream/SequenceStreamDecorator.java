package training.java6.ocp.io.bin.decorator.stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.SequenceInputStream;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import training.java6.ocp.io.bin.decorator.thread.SequenceCountThreadDecorator;
import training.patterns.producer_consumer.AbstractThreadComunicationDecorator;
import training.patterns.producer_consumer.AbstractThreadManagerDecorator;

public class SequenceStreamDecorator extends AbstractThreadComunicationDecorator<OutputStream, InputStream> {

	protected final static String FILE_PATH = "t.tmp";

	protected SequenceCountThreadDecorator threadDecorator;

	public SequenceStreamDecorator(AbstractThreadManagerDecorator<OutputStream, InputStream> threadDecorator) {
		super(threadDecorator);
		this.threadDecorator = (SequenceCountThreadDecorator) threadDecorator;
	}

	@Override
	public void main() throws IOException, InterruptedException {
		FileOutputStream OUT1 = new FileOutputStream(FILE_PATH);
		FileInputStream IN1 = new FileInputStream(FILE_PATH);

		PipedOutputStream OUT2 = new PipedOutputStream();
		PipedInputStream IN2 = new PipedInputStream();
		OUT2.connect(IN2);
		PipedOutputStream OUT3 = new PipedOutputStream();
		PipedInputStream IN3 = new PipedInputStream();
		OUT3.connect(IN3);

		List<InputStream> inputStreams = new LinkedList<>();
		inputStreams.add(IN1);
		inputStreams.add(IN2);
		inputStreams.add(IN3);
		SequenceInputStream SIN = new SequenceInputStream(Collections.enumeration(inputStreams));

		threadDecorator.writeRead(SIN, OUT1, OUT2, OUT3);
	}

}
