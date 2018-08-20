package training.java6.ocp.io.bin.decorator.stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import training.patterns.producer_consumer.AbstractThreadComunicationDecorator;
import training.patterns.producer_consumer.AbstractThreadManagerDecorator;

public class FileDescriptorStreamDecorator extends AbstractThreadComunicationDecorator<OutputStream, InputStream> {

	protected final static String FILE_PATH = "t.tmp";

	public FileDescriptorStreamDecorator(
			AbstractThreadManagerDecorator<OutputStream, InputStream> threadDecorator) {
		super(threadDecorator);
	}

	@Override
	public void main() throws IOException, InterruptedException {
		FileOutputStream OUT = new FileOutputStream(FILE_PATH);
		FileOutputStream OUT2 = new FileOutputStream(OUT.getFD());
		FileInputStream IN = new FileInputStream(FILE_PATH);
		FileInputStream IN2 = new FileInputStream(IN.getFD());
		threadDecorator.writeRead(IN2, OUT2);

		OUT.close();
		OUT2.close();
		IN.close();
		IN2.close();
	}

}
