package training.java6.ocp.generics;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import training.AbstractTest;

public class InitGenericsTraining extends AbstractTest {

	@Test
	public void initRawType1Test() {
		Set set = new HashSet();// Object
		set.add(1);// unchecked
		set.add("test");// unchecked
	}

	@Test
	public void initRawType2Test() {
		Set set = new HashSet<>();// Object, DIAMOND JDK7
		set.add(1);
		set.add("test");
	}

	@Test
	public void initRawType3Test() {
		Set set = new HashSet<Integer>();// Object
		set.add(1);
		set.add("test");
	}

	@Test
	public void initRawType3FixedTest() {
		Set set = Collections.checkedSet(new HashSet<Integer>(), Integer.class);
		set.add(1);
		set.add("test");
	}

	@Test
	public void initRawType4Test() {
		Set<Integer> set = new HashSet();// Object
		set.add(1);
		// set.add("test");//NOT COMPILE

		Set set2 = set;
		set2.add("test");// COMPILE
	}

	@Test
	public void initRawType5Test() {
		Set<Integer> set = new HashSet<Integer>();// Object
		set.add(1);
		// set.add("test");//NOT COMPILE

		Set set2 = set;
		set2.add("test");// COMPILE
	}

	@Test
	public void initUnknownTypeTest() {
		// Set set = new HashSet<?>();// NOT COMPILE
		// Set<String> set = new HashSet<?>(); // NOT COMPILE
		Set<?> set = new HashSet();
		set.add("test");// NOT COMPILE
	}
	
	@Test
	public void init10Test() {
		Set<? extends Object> c = new HashSet<String>();
		c.add("test"); // Compile time error
	}

}
