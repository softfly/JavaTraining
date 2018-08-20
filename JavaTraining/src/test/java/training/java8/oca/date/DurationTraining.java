package training.java8.oca.date;

import java.time.Duration;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class DurationTraining {
	
	final String format = "%-25s = %-5s%n";
	
	@Rule public TestName testName = new TestName();
	
    @Before
    public void setUp() {
    	System.out.println("== "+testName.getMethodName()+" ==");
    }
	
	@Test
	public void testConstructor() {
		System.out.println(Duration.ZERO);
		System.out.println(Duration.of(1, ChronoUnit.DAYS));
		System.out.println(Duration.ofMinutes(1));
		System.out.println(Duration.ofSeconds(60));
		System.out.println(Duration.ofMillis(1));
		System.out.println(Duration.ofMillis(1_000));
		System.out.println(Duration.ofNanos(1));
		System.out.println(Duration.ofNanos(1_000_000_000));
	}
	
	@Test
	public void unit() {
		System.out.println(Duration.ZERO.getUnits());
		for (TemporalUnit unit: Duration.ZERO.getUnits()) {
			System.out.println(unit);
			System.out.println(Duration.ZERO.plus(1, unit));
		}
		System.out.println(Duration.ZERO.plusDays(1));
		System.out.println(Duration.ZERO.plusHours(1));
		System.out.println(Duration.ZERO.plusMinutes(1));
		System.out.println(Duration.ZERO.plusSeconds(1));
		System.out.println(Duration.ZERO.plusMillis(1));
		System.out.println(Duration.ZERO.plusNanos(1));
	}
	
	@Test
	public void other() {
		System.out.println(Duration.from(Duration.ZERO));
		System.out.println(Duration.parse("PT-6H3M"));
	}
	
    @After
    public void tearDown() { 
    	System.out.println();
    }

}
