package training.java6.ocp.io.bin.decorator.thread;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.lang3.NotImplementedException;

import training.java6.ocp.io.bin.thread.CountOutputThread;

public class SequenceCountThreadDecorator extends CountThreadDecorator {

	public void writeRead(InputStream IN, OutputStream... OUTs) throws IOException, InterruptedException {
		Thread[] wt = new Thread[3 * getThreadWriteNum()];
		for (int i = 0; i < wt.length; i++) {
			for (OutputStream OUT : OUTs) {
				wt[i] = new Thread(new CountOutputThread(OUT));
				i++;
			}
		}
		Thread[] rt = new Thread[getThreadReadNum()];
		for (int i = 0; i < rt.length; i++) {
			rt[i] = new Thread(newReadThread(IN));
		}
		start(wt);
		start(rt);
		Thread.sleep(5000);

		interrupt(wt);
		join(wt);

		Thread.sleep(1000);
		interrupt(rt);
		join(rt);
	}

	@Override
	public void write(OutputStream OUT) throws IOException, InterruptedException {
		throw new NotImplementedException("");
	}

	@Override
	public void read(InputStream IN) throws IOException, InterruptedException {
		throw new NotImplementedException("");
	}

	@Override
	public void writeRead(InputStream IN, OutputStream OUT) throws IOException, InterruptedException {
		throw new NotImplementedException("");
	}
}
