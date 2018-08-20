package training.java8.oca.date;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import org.junit.Ignore;
import org.junit.Test;

public class SimpleDateFormatTraining {

	@Test
	public void clearTest() {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat();
		System.out.println(sdf.format(c.getTime()));

		sdf = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z", DateFormatSymbols.getInstance(Locale.ENGLISH));
		System.out.println(sdf.format(c.getTime()));
	}
	
	@Test
	@Ignore
	public void test1() {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z",
				DateFormatSymbols.getInstance(Locale.ENGLISH));
		System.out.println(sdf.format(c.getTime()));
	}
	
	@Test
	//@Ignore
	public void test2() {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat();
		
		sdf.applyLocalizedPattern("'This moment: 'dd MMM yyyy '@'hh 'hours and 'mm 'minutes.'");
		
		System.out.println(sdf.toPattern());
		System.out.println(sdf.toLocalizedPattern());
		
		System.out.println(sdf.format(c.getTime()));
	}

}
