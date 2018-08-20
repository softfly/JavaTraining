package training.java6.oca;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import training.AbstractTest;

public class ArrayTraining extends AbstractTest {

	protected static String FORMAT_OUT = "%-25s %-25s\n";

	protected int[] a = { 1, 2, 3, 4 };

	protected Integer[] aW = { 1, 2, 3, 4 };

	protected List<?> l = Arrays.asList(aW);
	
	public void test(int[] a) {
	    
	}

	@Test
	public void toStringTest() {
		print("a.toString()", a.toString());
		print("Arrays.toString(a)", Arrays.toString(a));
		print("l.toString()", l);
		
		test(new int[] {4,4});
	}

	@Test
	public void lengthSizeTest() {
		System.out.println(a.length);
		System.out.println(l.size());
	}

	@Test
	public void equalsTest() {
		Integer[][] a1 = { { 1, 2 } };
		Integer[][] a2 = { { 1, 2 } };
		print("equals", Arrays.equals(a1, a2));
		print("deepEquals", Arrays.deepEquals(a1, a2));
	}

	private int[] b;// null

	private int[] c = new int[3];

	@Test
	public void arrayDefaultFieldTest() {
		print("array default class", Arrays.toString(b));
		print("array default class", Arrays.toString(c));
	}

	protected static void print(Object v1, Object v2) {
		System.out.format(FORMAT_OUT, v1, v2);
	}

}
