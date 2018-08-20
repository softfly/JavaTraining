package training.java8.oca.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.EnumSet;

import org.junit.Test;

public class LocalDateTraining {

	@Test
	public void test1() {
		{
			LocalDateTime dateTime = LocalDateTime.now();
			LocalDate date = LocalDate.from(dateTime);
			System.out.println(date.toString());
		}
		{
			LocalDate date = LocalDate.parse("20111203", DateTimeFormatter.BASIC_ISO_DATE);
			System.out.println(date.toString());
		}


	}

}
