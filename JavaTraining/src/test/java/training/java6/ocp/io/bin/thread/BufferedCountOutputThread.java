package training.java6.ocp.io.bin.thread;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class BufferedCountOutputThread extends CountOutputThread {

	public BufferedCountOutputThread(OutputStream os) throws IOException {
		super(new BufferedOutputStream(os, 2));
	}

}
