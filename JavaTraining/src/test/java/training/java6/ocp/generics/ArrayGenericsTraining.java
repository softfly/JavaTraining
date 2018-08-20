package training.java6.ocp.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import training.AbstractTest;

public class ArrayGenericsTraining extends AbstractTest {

	@Test
	public void test1() {
		// Cannot create a generic array of ArrayList<Integer>
		ArrayList[] l1 = new ArrayList<Integer>[2];
		ArrayList<Integer>[] l2 = new ArrayList<Integer>[2];
	}
	
	@Test
	public void raw2test() {
		ArrayList[] l = new ArrayList[2];
		l[0] = new ArrayList<Integer>();
		l[1] = new ArrayList<Integer>();
		System.out.println(Arrays.toString(l));
	}
	
	@Test
	public void safetyTest() {
		ArrayList<Integer>[] l = new ArrayList[2];
		l[0] = new ArrayList<Integer>();
		l[1] = new ArrayList<Integer>();
		System.out.println(Arrays.toString(l));
	}

}
