package training.java6.ocp;

import java.util.Iterator;
import java.util.Scanner;

import org.junit.Test;

import training.AbstractTest;

public class ScannerTraining extends AbstractTest {

	@Test
	public void nextLineTest() {
		Scanner sc = new Scanner("ab\ncd");
		while (sc.hasNextLine()) {
			System.out.println(sc.nextLine());
			System.out.println(sc.match());
		}
		sc.close();
	}

	@Test
	public void iteratorTest() {
		Scanner sc = new Scanner("ab;cd");
		sc.useDelimiter("\\W");
		for (Iterator<String> it = sc; it.hasNext();) {
			System.out.println(it.next());
		}
		sc.close();
	}

	@Test
	public void findInLineTest() {
		String p = "[A-z]+";
		Scanner sc = new Scanner("ab;cd");
		String s;
		while ((s = sc.findInLine(p)) != null) {
			System.out.println(s);
			System.out.println(sc.match());
		}
		sc.close();
	}

	@Test
	public void findWithinHorizonTest() {
		String p = "[A-z]+\\W";
		Scanner sc = new Scanner("ab;cd");
		System.out.println(sc.findWithinHorizon(p, 1));
		System.out.println(sc.findWithinHorizon(p, 4));
		sc.close();
	}

}
