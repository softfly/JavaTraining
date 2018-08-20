package training.java8.oca.lambda;

import static java.time.temporal.ChronoField.DAY_OF_YEAR;

import java.time.temporal.TemporalAdjuster;

public class Test1 {
	
    public static TemporalAdjuster firstDayOfYear() {
        return (temporal) -> temporal.with(DAY_OF_YEAR, 1);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
