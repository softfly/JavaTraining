package training.java6.ocp.text;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class DataFormatTraining {

	public static void main(String[] args) {
		Date d = new Date();
		Locale l = Locale.US;
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT, l);
		print("DEFAULT", df.format(d));
		df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, l);
		print("SHORT", df.format(d));
		df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, l);
		print("MEDIUM", df.format(d));
		df = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, l);
		print("LONG", df.format(d));
		df = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, l);
		print("FULL", df.format(d));

		// System.out.println(df.getCalendar());
	}

	protected static void print(Object v1, Object v2) {
		System.out.format("%-10s %-40s\n", v1, v2);
	}

}
