package training.java8.oca.date;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class LocalDateTimeTraining {

	@Rule
	public TestName testName = new TestName();

	@Before
	public void setUp() {
		System.out.println("== " + testName.getMethodName() + " ==");
	}
	
	@Test
	public void test() {
		
	}

	@After
	public void tearDown() {
		System.out.println();
	}
}
