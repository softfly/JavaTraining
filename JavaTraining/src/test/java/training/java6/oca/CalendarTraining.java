package training.java6.oca;

import java.text.DateFormat;
import java.util.Calendar;

import org.junit.Test;

import training.AbstractTest;

public class CalendarTraining extends AbstractTest {

	protected final static DateFormat DF = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);

	protected static String FORMAT_OUT = "%-25s %-25s\n";

	@Test
	public void clearTest() {
		Calendar calendar = Calendar.getInstance();
		System.out.println(DF.format(calendar.getTime()));
		
		calendar.clear(Calendar.ERA);
		print("ERA", DF.format(calendar.getTime()));
		calendar.clear(Calendar.YEAR);
		print("YEAR", DF.format(calendar.getTime()));
		calendar.clear(Calendar.MONTH);
		print("MONTH", DF.format(calendar.getTime()));
		calendar.clear(Calendar.WEEK_OF_YEAR);
		print("WEEK_OF_YEAR", DF.format(calendar.getTime()));
		calendar.clear(Calendar.WEEK_OF_MONTH);
		print("WEEK_OF_MONTH", DF.format(calendar.getTime()));
		calendar.clear(Calendar.DAY_OF_MONTH);
		
		//For reset DAY have to reset all day fields.
		print("DAY_OF_MONTH", DF.format(calendar.getTime()));
		calendar.clear(Calendar.DAY_OF_YEAR);
		print("DAY_OF_YEAR", DF.format(calendar.getTime()));
		calendar.clear(Calendar.DAY_OF_WEEK);
		print("DAY_OF_WEEK", DF.format(calendar.getTime()));
		calendar.clear(Calendar.DAY_OF_WEEK_IN_MONTH);
		print("DAY_OF_WEEK_IN_MONTH", DF.format(calendar.getTime()));
		
		
		calendar.clear(Calendar.AM_PM);
		print("AM_PM", DF.format(calendar.getTime()));
		calendar.clear(Calendar.MILLISECOND);
		print("MILLISECOND", DF.format(calendar.getTime()));
		calendar.clear(Calendar.SECOND);
		print("SECOND", DF.format(calendar.getTime()));
		calendar.clear(Calendar.MINUTE);
		print("MINUTE", DF.format(calendar.getTime()));
		calendar.clear(Calendar.HOUR_OF_DAY);
		
		//HOUR not reset to 0, use set
		print("HOUR_OF_DAY", DF.format(calendar.getTime()));
		calendar.clear(Calendar.HOUR);
		print("HOUR", DF.format(calendar.getTime()));
	}

	@Test
	public void setAddRollTest() {
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
		Calendar c = Calendar.getInstance();
		c.clear();
		c.set(Calendar.YEAR, 1999);
		c.set(Calendar.MONTH, Calendar.JANUARY);
		c.set(Calendar.DAY_OF_MONTH, 31);
		print("Orignal date:", df.format(c.getTime()));

		Calendar c1 = (Calendar) c.clone();
		c1.set(Calendar.MONTH, Calendar.FEBRUARY);
		print("set   +1month:", df.format(c1.getTime()));

		c1 = (Calendar) c.clone();
		c1.add(Calendar.MONTH, 1);
		print("add   +1month:", df.format(c1.getTime()));

		c1 = (Calendar) c.clone();
		c1.roll(Calendar.MONTH, 1);
		print("roll  +1month:", df.format(c1.getTime()));
		System.out.println();

		c1 = (Calendar) c.clone();
		c1.set(Calendar.MONTH, Calendar.FEBRUARY);
		c1.getTime();//March 3, 1999
		c1.set(Calendar.MONTH, Calendar.MARCH);
		print("set   +1+1month:", df.format(c1.getTime()));
		
		c1 = (Calendar) c.clone();
		c1.set(Calendar.MONTH, Calendar.MARCH);
		print("set   +2month:", df.format(c1.getTime()));

		c1 = (Calendar) c.clone();
		c1.add(Calendar.MONTH, 1);
		c1.getTime();
		c1.add(Calendar.MONTH, 1);
		print("add   +1+1month:", df.format(c1.getTime()));
		
		c1 = (Calendar) c.clone();
		c1.add(Calendar.MONTH, 2);
		print("add   +2month:", df.format(c1.getTime()));
	}

	@Test
	public void rollTest() {
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
		Calendar c = Calendar.getInstance();
		c.clear();
		c.set(Calendar.YEAR, 1999);
		c.set(Calendar.MONTH, Calendar.JANUARY);
		c.set(Calendar.DAY_OF_MONTH, 31);
		System.out.println("Orignal date:    " + df.format(c.getTime()));

		Calendar c1 = (Calendar) c.clone();
		c1.add(Calendar.MONTH, 13);
		print("add   +13month:", df.format(c1.getTime()));

		c1 = (Calendar) c.clone();
		c1.roll(Calendar.MONTH, 13);
		print("roll  +13month:", df.format(c1.getTime()));
	}

	@Test
	public void test() {
		// Consider a GregorianCalendar originally set to August 31, 1999.
		Calendar c = Calendar.getInstance();
		c.clear();
		c.set(Calendar.YEAR, 1999);
		c.set(Calendar.MONTH, Calendar.AUGUST);
		c.set(Calendar.DAY_OF_MONTH, 31);
		System.out.println("date:   " + DF.format(c.getTime()));

		// Calling add(Calendar.MONTH, 13) sets the calendar to September 30, 2000.
		c.add(Calendar.MONTH, 13);
		// rule 1 +13 MONTH=September
		// DAY_OF_MONTH=31
		// rule 2 DAY_OF_MONTH=30, the closest possible value.
		System.out.println("add 13 month" + DF.format(c.getTime()));

	}

	@Test(expected = IllegalArgumentException.class)
	public void leniencyTest() {
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
		Calendar c = Calendar.getInstance();
		c.clear();
		c.set(Calendar.YEAR, 1999);
		c.set(Calendar.MONTH, Calendar.JANUARY);
		c.set(Calendar.DAY_OF_MONTH, 31);
		System.out.println("Orignal date:    " + df.format(c.getTime()));
		
		Calendar c1 = (Calendar) c.clone();
		c1.set(Calendar.MONTH, Calendar.FEBRUARY);
		c.setLenient(true);
		System.out.println("set   +1month:   " + df.format(c1.getTime()));

		Calendar c2 = (Calendar) c.clone();
		c2.set(Calendar.MONTH, Calendar.FEBRUARY);
		c2.setLenient(false);
		System.out.println("set   +1month:   " + df.format(c2.getTime()));

		System.out.println();
	}

	protected static void print(Object v1, Object v2) {
		System.out.format(FORMAT_OUT, v1, v2);
	}

}
