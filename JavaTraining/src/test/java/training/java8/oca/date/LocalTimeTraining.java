package training.java8.oca.date;

import java.time.Duration;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class LocalTimeTraining {
	
	@Rule public TestName testName = new TestName();
	
    @Before
    public void setUp() {
    	System.out.println("== "+testName.getMethodName()+" ==");
    }
	
	@Test
	public void test1() {		
		System.out.println(ZoneId.getAvailableZoneIds());
		System.out.format("%-25s = %-5s%n", "now", LocalTime.now());
		System.out.format("%-25s = %-5s%n", "UTC", LocalTime.now(ZoneId.of("UTC")));
		System.out.format("%-25s = %-5s%n", "UTC+00:00", LocalTime.now(ZoneId.of("UTC+00:00")));
		System.out.format("%-25s = %-5s%n", "UTC+01:00", LocalTime.now(ZoneId.of("UTC+01:00")));
		System.out.format("%-25s = %-5s%n", "UTC+02:00", LocalTime.now(ZoneId.of("UTC+02:00")));
		System.out.format("%-25s = %-5s%n", "", LocalTime.of(0,0,0,999_999_999));
		System.out.format("%-25s = %-5s%n", "ofSecondOfDay", LocalTime.ofSecondOfDay(60));
		//http://javapapers.com/java/java-8-date-and-time-temporal-adjuster/
		//System.out.format("%-25s = %-5s%n", "", LocalTime.now().with(TemporalAdjusters.firstDayOfYear()));
		System.out.format("%-25s = %-5s%n", "truncated", LocalTime.now().truncatedTo(ChronoUnit.DAYS));
		System.out.format("%-25s = %-5s%n", "minus", LocalTime.now().minus(Duration.ofMinutes(10L)));
		//System.out.format("%-25s = %-5s%n", "minus", LocalTime.now().minus(Period));
	}
	
    @After
    public void tearDown() { 
    	System.out.println();
    }

}
