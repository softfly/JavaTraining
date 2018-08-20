package training.java8.oca.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

import org.junit.Test;

public class ChronoFieldTraining {

	final static ChronoField[] useLong = { 
			ChronoField.EPOCH_DAY, 
			ChronoField.PROLEPTIC_MONTH, 
			ChronoField.NANO_OF_DAY,
			ChronoField.MICRO_OF_DAY,
			ChronoField.INSTANT_SECONDS
			};
	
	final static List<ChronoField> useLongL = Arrays.asList(useLong);
	
	@Test
	public void test1() {
		chronoFieldTestWithLog(LocalTime.now());
		chronoFieldTestWithLog(LocalDate.now());
		chronoFieldTestWithLog(LocalDateTime.now());
		chronoFieldTestWithLog(OffsetTime.now());
		chronoFieldTestWithLog(OffsetDateTime.now());
		chronoFieldTestWithLog(ZonedDateTime.now());
	}

	public void chronoFieldTestWithLog(TemporalAccessor temporal) {
		System.out.println("=== " + temporal.getClass() + " ===");
		chronoFieldTest(temporal);
		System.out.println();
	}

	protected void chronoFieldTest(TemporalAccessor temporal) {
		EnumSet<ChronoField> chronoFields = EnumSet.allOf(ChronoField.class);
		for (ChronoField chronoField : chronoFields) {
			boolean supported = temporal.isSupported(chronoField);
			if (supported) {
				Object value = null;
				if (useLongL.contains(chronoField)) {
					value = temporal.getLong(chronoField);
				} else {
					value = temporal.get(chronoField);
				}
				System.out.format("%-25s %-5s %-15s %s%n", chronoField, supported, value, temporal.range(chronoField));
			} else {
				System.out.format("%-25s %-5s%n", chronoField, supported);
			}
		}
	}

}
