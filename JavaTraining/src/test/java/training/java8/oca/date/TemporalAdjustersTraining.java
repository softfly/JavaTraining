package training.java8.oca.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

import org.junit.Test;

/**
 * https://docs.oracle.com/javase/tutorial/datetime/iso/adjusters.html
 */
public class TemporalAdjustersTraining {

	@Test
	public void predefinedAdjusters() {
		LocalDate date = LocalDate.of(2000, Month.OCTOBER, 15);
		DayOfWeek dotw = date.getDayOfWeek();
		System.out.printf("%s is on a %s%n", date, dotw);

		System.out.printf("first day of Month: %s%n", date.with(TemporalAdjusters.firstDayOfMonth()));
		System.out.printf("first Monday of Month: %s%n", date.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)));
		System.out.printf("last day of Month: %s%n", date.with(TemporalAdjusters.lastDayOfMonth()));
		System.out.printf("first day of next Month: %s%n", date.with(TemporalAdjusters.firstDayOfNextMonth()));
		System.out.printf("first day of next Year: %s%n", date.with(TemporalAdjusters.firstDayOfNextYear()));
		System.out.printf("first day of Year: %s%n", date.with(TemporalAdjusters.firstDayOfYear()));
	}
	
	class PaydayAdjuster implements TemporalAdjuster {

		/**
		 * The adjustInto method accepts a Temporal instance 
		 * and returns an adjusted LocalDate. If the passed in
		 * parameter is not a LocalDate, then a DateTimeException is thrown.
		 */
		@Override
		public Temporal adjustInto(Temporal input) {
		    LocalDate date = LocalDate.from(input);
		    int day;
		    if (date.getDayOfMonth() < 15) {
		        day = 15;
		    } else {
		        day = date.with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth();
		    }
		    date = date.withDayOfMonth(day);
		    if (date.getDayOfWeek() == DayOfWeek.SATURDAY ||
		        date.getDayOfWeek() == DayOfWeek.SUNDAY) {
		        date = date.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
		    }

		    return input.with(date);
		}
	}
	
	@Test
	public void customAdjusters() {
		LocalDate date = LocalDate.of(2000, Month.OCTOBER, 15);
		LocalDate nextPayday = date.with(new PaydayAdjuster());
		System.out.println(nextPayday);
	}



}
