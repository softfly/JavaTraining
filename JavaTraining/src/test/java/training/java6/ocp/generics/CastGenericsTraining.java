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
		@SuppressWarnings("rawtypes")
		List c2 = c1;
		@SuppressWarnings("unchecked")
		List<Integer> c3 = (List<Integer>) c2;
		c3.add(Integer.valueOf(2));
		System.out.println(c3);
	}
	
	@Test
	public void castUp2Test() {
		List<Object> c1 = new ArrayList<Object>();
		c1.add(Integer.valueOf(1));

		// compile-time error cannot cast
		// Collection<Integer> c2 = (Collection<Integer>) c1;

		// Cheat
		@SuppressWarnings("rawtypes")
		Collection c2 = c1;
		@SuppressWarnings("unchecked")
		Collection<Integer> c3 = (Collection<Integer>) c2;
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
		@SuppressWarnings("rawtypes")
		List c2 = c1;
		@SuppressWarnings("unchecked")
		List<Number> c3 = (List<Number>) c2;
		System.out.println(c3);
	}

	@Test
	public void castTest() {
		List<? extends Number> c1 = new ArrayList<Integer>();
		@SuppressWarnings({ "unchecked", "unused" })
		List<Integer> c2 = (List<Integer>) c1;
	}

	@Test
	public void cast2Test() {
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<? extends Integer> intList = new ArrayList();
		@SuppressWarnings("unused")
		List<? extends Number> numList = intList;
	}

	
}
