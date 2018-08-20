package training;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;

public class AbstractTest {

	@Rule
	public TestName testName = new TestName();

	@Before
	public void setUp() {
		String p = repeat("=", 25);
		System.out.println(new StringBuilder(p).append(" ").append(splitCamelCase(testName.getMethodName())).append(" ")
				.append(p).toString());
	}

	@After
	public void tearDown() {
		System.out.println();
	}

	protected static String splitCamelCase(String s) {
		return s.replaceAll(String.format("%s|%s|%s", "(?<=[A-Z])(?=[A-Z][a-z])", "(?<=[^A-Z])(?=[A-Z])",
				"(?<=[A-Za-z])(?=[^A-Za-z])"), " ");
	}

	protected static String repeat(String s, int n) {
		return new String(new char[n]).replace("\0", s);
	}

}
