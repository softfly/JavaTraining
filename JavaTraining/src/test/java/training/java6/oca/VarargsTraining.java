package training.java6.oca;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import training.AbstractTest;

public class VarargsTraining extends AbstractTest {

	protected static String FORMAT_OUT = "%-25s %-25s\n";
		
	public static void intVargs(int... v) {
		print("int...", Arrays.toString(v));
	}
	
	public static void integerVargs(Integer... v) {
		print("Integer...", Arrays.toString(v));
	}
	
	public static <T> void genericVargs(T... v) {
		print("T...", Arrays.toString(v));
	}
	
	@Test
	public void intTest() {
		int[] a = {1,2};
		System.out.println(Arrays.toString(a));
		intVargs(a);
		//integerVargs(a); Autoboxing not working
		genericVargs(a);
	}
	
	@Test
	public void integerTest() {
		Integer[] a = {1,2};
		System.out.println(a);
		//intVargs(a); // Unboxing not working
		integerVargs(a);
		genericVargs(a);
	}

	protected static void print(Object v1, Object v2) {
		System.out.format(FORMAT_OUT, v1, v2);
	}

}
