package training.java6.ocp.text;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import org.junit.Test;

import training.AbstractTest;

public class DecimalFormatTraining extends AbstractTest {

    protected static Number VALUE = -1000000.4555;

    public static void main(String[] args) throws ParseException {
        Locale[] locales = NumberFormat.getAvailableLocales();
        //Locale[] locales = { Locale.US };

        for (Locale l : locales) {
            if (l.getCountry().length() == 0) {
                continue; // Skip language-only locales
            }
            System.out.println(new StringBuilder(l.getDisplayName()).append(" ")
                    .append(repeat("=", 150 - l.getDisplayName().length())));
            DecimalFormat fm = (DecimalFormat) NumberFormat.getInstance(l);
            print("Number");
            info(fm);
            fm = (DecimalFormat) NumberFormat.getIntegerInstance(l);
            print("Integer");
            info(fm);
            fm = (DecimalFormat) NumberFormat.getCurrencyInstance(l);
            print("Currency");
            info(fm);
            fm = (DecimalFormat) NumberFormat.getPercentInstance(l);
            print("Percent");
            info(fm);
        }
    }

    protected static void info(DecimalFormat fm) throws ParseException {
        print(fm.toPattern());
        print(" -> " + fm.format(VALUE));
        print(" -> " + fm.parse(fm.format(VALUE)));
        System.out.println();
    }

    protected static void print(Object v1) {
        System.out.format("%-40s", v1);
    }

    @Test
    public void formatIntTest() {
        format(5);
    }

    @Test
    public void formatDoubleTest() {
        format(1234567.437);
    }

    protected final static String[] PATTERNS =
            { "\u00A4 ###,###,###.0000", "#.#", "##.#", "######.##E0", "###test", "### \u2030" };

    protected void format(Object o) {
        DecimalFormat df = new DecimalFormat();
        for (String p : PATTERNS) {
            df.applyPattern(p);
            print(p, df.format(o));
        }
    }

    protected static void print(Object v1, Object v2) {
        System.out.format("%-40s %-40s\n", v1, v2);
    }

}
