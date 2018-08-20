package training.java8.oca.date;

import java.time.Clock;

import org.junit.Test;

public class ClockTraining {

	@Test
	public void test() {
		Clock clock = Clock.systemUTC();
		System.out.println(clock);
	}
	
}
