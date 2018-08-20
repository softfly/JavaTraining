package training.java6.ocp.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * https://docs.oracle.com/javase/tutorial/java/generics/capture.html
 */
public class WildcardCaptureTraining {

	public class WildcardError {

		void foo(List<?> i) {
			Object o = i.get(0);
			i.set(0, o);
		}

	}

	public class WildcardFixed {

		void foo(List<?> i) {
			fooHelper(i);
		}

		// l.get() is Object, not "capture#337 of ?," 
		private <T> void fooHelper(List<T> l) {
			l.set(0, l.get(0));
		}

	}

}
