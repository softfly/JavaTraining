package training.java6.oca;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import training.AbstractTest;

public class SortTraining extends AbstractTest {

	protected final String[] a = { "a", "z", "ab", "A", "Ab" };

	@Test
	public void sortTest() {
		String[] b = Arrays.copyOf(a, a.length);
		Arrays.sort(b);
		System.out.println(Arrays.toString(b));
	}

	@Test
	public void listTest() {
		List<String> l = Arrays.asList(a);
		Collections.sort(l);
		System.out.println(l);
	}

	@Test
	public void treeSetTest() {
		Set<String> set = new TreeSet<String>();
		for (String s: a) {
			set.add(s);
		}

		System.out.println(set);
	}
}
