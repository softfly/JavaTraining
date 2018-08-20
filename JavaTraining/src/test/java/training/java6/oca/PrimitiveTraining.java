package training.java6.oca;

import org.junit.Test;

import training.AbstractTest;

public class PrimitiveTraining extends AbstractTest {

	@Test
	public void booleanTest() {
		System.out.println(new Boolean("True2"));
		System.out.println(new Boolean("TruE"));
	}

	@Test
	public void intTest() {
		System.out.println(new Integer("True2"));// java.lang.NumberFormatException
	}

}
