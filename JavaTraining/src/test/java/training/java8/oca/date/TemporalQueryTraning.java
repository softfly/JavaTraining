package training.java8.oca.date;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQueries;
import java.time.temporal.TemporalQuery;
import java.time.temporal.TemporalUnit;

import org.junit.Test;

/**
 * https://docs.oracle.com/javase/tutorial/datetime/iso/queries.html
 */
public class TemporalQueryTraning {

	@Test
	public void predefinedQueries() {
		TemporalQuery<TemporalUnit> query = TemporalQueries.precision();
		System.out.printf("LocalDate precision is %s%n", LocalDate.now().query(query));
		System.out.printf("LocalDateTime precision is %s%n", LocalDateTime.now().query(query));
		System.out.printf("Year precision is %s%n", Year.now().query(query));
		System.out.printf("YearMonth precision is %s%n", YearMonth.now().query(query));
		System.out.printf("Instant precision is %s%n", Instant.now().query(query));
	}
	

}
