package training.java6.ocp.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import training.AbstractTest;

public class CastGenericsTraining extends AbstractTest {

	@Test
	public void castUpTest() {
		List<Object> c1 = new ArrayList<Object>();
		c1.add(Integer.valueOf(1));

		// compile-time error cannot cast
		// List<Integer> c2 = (List<Integer>) c1;

		// Cheat
		List c2 = c1;
		List<Integer> c3 = (List<Integer>) c2;
		c3.add(Integer.valueOf(2));
		System.out.println(c3);
	}

	@Test
	public void castDownTest() {
		List<Integer> c1 = new ArrayList<Integer>();
		c1.add(Integer.valueOf(1));

		// compile-time error cannot cast
		// List<Number> c2 = (List<Number>) c1;

		// cheat
		List c2 = c1;
		List<Number> c3 = (List<Number>) c2;
		System.out.println(c3);
	}

	@Test
	public void castTest() {
		List<? extends Number> c1 = new ArrayList<Integer>();
		List<Integer> c2 = (List<Integer>) c1;
	}

	@Test
	public void cast2Test() {
		List<? extends Integer> intList = new ArrayList();
		List<? extends Number> numList = intList;
	}
	
	@Test
	public void cast3Test() {
		List<? extends Integer> intList = new ArrayList();
		List<? extends Number> numList = intList;
	}
	
}
