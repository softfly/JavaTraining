package training.java6.ocp.io.bin;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * TODO: Create HTML or Swing table.
 */
public class InfoInputStreamTraining {

	protected static String FORMAT_OUT = "%-25s";

	protected static String IN_TEXT = "ABCDEF";

	protected final static String FILE_PATH = "t.tmp";

	public static void main(String[] args) throws IOException {
		InputStream[] a = { //
				getByteArrayInputStream(), //
				getFileInputStream(), //
				getPipedInputStream(), //
				getBufferedInputStream(),//
				//getObjectInputStream()//
		};

		execute(a, "Name", s -> s.getClass().getSimpleName());
		execute(a, "available", s -> s.available());
		execute(a, "read0", s -> {
			if (s.markSupported()) {
				s.mark(4);
			}
			return (char) s.read();
		});
		execute(a, "read1", s -> (char) s.read());
		execute(a, "read2", s -> (char) s.read());
		execute(a, "read3", s -> (char) s.read());
		execute(a, "markSupported", s -> s.markSupported());
		execute(a, "reset", s -> {
			if (s.markSupported()) {
				s.reset();
				return (char) s.read();
			} else {
				return "";
			}

		});

	}

	protected static byte[] getInData() throws IOException {
		ByteArrayOutputStream o = new ByteArrayOutputStream();
		ObjectOutputStream oo = new ObjectOutputStream(o);
		for (int i=0;i<10;i++) {
			oo.writeInt(i);
		}
		oo.close();
		return o.toByteArray();
	}

	protected static ByteArrayInputStream getByteArrayInputStream() {
		return new ByteArrayInputStream(IN_TEXT.getBytes());
	}

	protected static FileInputStream getFileInputStream() throws IOException {
		FileOutputStream out = new FileOutputStream(FILE_PATH);
		out.write(IN_TEXT.getBytes());
		out.flush();
		//out.close();

		return new FileInputStream(FILE_PATH);
	}

	protected static PipedInputStream getPipedInputStream() throws IOException {
		PipedOutputStream out = new PipedOutputStream();
		PipedInputStream in = new PipedInputStream();
		in.connect(out);
		out.write(IN_TEXT.getBytes());
		out.flush();
		//out.close();

		return in;
	}

	protected static BufferedInputStream getBufferedInputStream() throws IOException {
		return new BufferedInputStream(getPipedInputStream(), 2);
	}

	protected static ObjectInputStream getObjectInputStream() throws IOException {
		return new ObjectInputStream(getByteArrayInputStream());
	}

	interface Command {
		public Object execute(InputStream s) throws IOException;
	}

	protected static void execute(InputStream[] a, String label, Command c) throws IOException {
		System.out.format(FORMAT_OUT, label);
		for (InputStream s : a) {
			System.out.format(FORMAT_OUT, c.execute(s));
		}
		System.out.println();
	}

	protected static void print(Object v1, Object v2) {
		System.out.format(FORMAT_OUT, v1, v2);
	}

}
