package training.java8.oca.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.junit.Ignore;
import org.junit.Test;

public class CalendarTraining {

	final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd EEE HH:mm:ss");

	@Test
	public void weekYearTest() {
		System.out.println("==week year Test==");
		Calendar c = Calendar.getInstance();
		c.clear();
		System.out.println("isWeekDateSupported:       " + c.isWeekDateSupported());
		c.setWeekDate(1999, c.getWeeksInWeekYear() + 1, 1);

		System.out.println("Orignal date:              " + sdf.format(c.getTime()));
		System.out.println("getWeekYear:               " + c.getWeekYear());
		System.out.println("getWeeksInWeekYear:        " + c.getWeeksInWeekYear());
		System.out.println("getFirstDayOfWeek:         " + c.getFirstDayOfWeek());
		System.out.println("getMinimalDaysInFirstWeek: " + c.getMinimalDaysInFirstWeek());
		System.out.println();

		Calendar c1 = (Calendar) c.clone();
		c1.setFirstDayOfWeek(Calendar.MONDAY);
		c1.setWeekDate(1999, c1.getWeeksInWeekYear() + 1, 1);
		System.out.println("Orignal date:              " + sdf.format(c1.getTime()));
		System.out.println("getWeekYear:               " + c1.getWeekYear());
		System.out.println("getWeeksInWeekYear:        " + c1.getWeeksInWeekYear());
		System.out.println("getFirstDayOfWeek:         " + c1.getFirstDayOfWeek());
		System.out.println();
	}

	@Test
	public void minimalDaysWeekYearTest() {
		System.out.println("==minimal Days Week Year==");
		Calendar c = Calendar.getInstance();
		System.out.println("isWeekDateSupported:       " + c.isWeekDateSupported());
		c.clear();
		c.setWeekDate(1999, 1, 1);

		System.out.println("Orignal date:              " + sdf.format(c.getTime()));
		System.out.println("getMinimalDaysInFirstWeek: " + c.getMinimalDaysInFirstWeek());
		System.out.println();

		Calendar c1 = (Calendar) c.clone();
		c1.setMinimalDaysInFirstWeek(7);
		c1.setWeekDate(1999, 1, 1);
		System.out.println("Orignal date:              " + sdf.format(c1.getTime()));
		System.out.println("getMinimalDaysInFirstWeek: " + c1.getMinimalDaysInFirstWeek());
		System.out.println();
	}

	@Test
	public void getTest() {
		System.out.println("==get Test==");

		Calendar c = Calendar.getInstance();
		c.clear();
		c.set(1991, Calendar.APRIL, 10);
		System.out.println("Orignal date:              " + sdf.format(c.getTime()));

		System.out.println("getActualMinimum:          " + c.getActualMinimum(Calendar.DAY_OF_MONTH));
		System.out.println("getActualMaximum:          " + c.getActualMaximum(Calendar.DAY_OF_MONTH));
		System.out.println("getGreatestMinimum:        " + c.getGreatestMinimum(Calendar.DAY_OF_MONTH));
		System.out.println("getLeastMaximum            " + c.getLeastMaximum(Calendar.DAY_OF_MONTH));
		System.out.println("getMinimum:                " + c.getMinimum(Calendar.DAY_OF_MONTH));
		System.out.println("getMaximum:                " + c.getMaximum(Calendar.DAY_OF_MONTH));
		System.out.println();
		System.out.println("getFirstDayOfWeek:         " + c.getFirstDayOfWeek());
		System.out.println("getMinimalDaysInFirstWeek: " + c.getMinimalDaysInFirstWeek());

		System.out.println("getWeeksInWeekYear:        " + c.getWeeksInWeekYear());
		System.out.println();
	}

s

}
