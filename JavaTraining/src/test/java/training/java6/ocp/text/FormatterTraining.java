package training.java6.ocp.text;

import org.junit.Test;

import training.AbstractTest;

public class FormatterTraining extends AbstractTest {

	@Test
	public void test1() {
		System.out.format("%b\n", Integer.valueOf(15));// true
		// System.out.format("%1.0f\n", Integer.MAX_VALUE); //
		// java.util.IllegalFormatConversionException
		System.out.format("%1.0f\n", 200.0);
		System.out.format("%1f\n", 200.0);
		System.out.format("%1.0f\n", 200.0);
		System.out.format("%s\n", 200.00);
	}

}
