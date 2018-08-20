package training.java6.ocp.text;

import static org.junit.Assert.assertTrue;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import org.junit.Test;

import training.AbstractTest;

public class NumberFormatTraining extends AbstractTest {

    protected static String FORMAT_OUT = "%-50s %-50s\n";

    protected static Number VALUE = -1000000.4555;

    public static void main(String[] args) throws ParseException {
        Locale[] locales = NumberFormat.getAvailableLocales();
        //Locale[] locales = { Locale.US };

        for (Locale l : locales) {
            if (l.getCountry().length() == 0) {
                continue; // Skip language-only locales
            }
            info(l);
        }
    }

    protected static void info(Locale l) {
        System.out.println(new StringBuilder(l.getDisplayName()).append(" ")
                .append(repeat("=", 100 - l.getDisplayName().length())));

        NumberFormat nf = NumberFormat.getInstance(l);
        print("getInstance:", nf.format(VALUE));
        info(nf);
        nf = NumberFormat.getNumberInstance(l);
        print("getNumberInstance:", nf.format(VALUE));
        info(nf);
        nf = NumberFormat.getCurrencyInstance(l);
        print("getCurrencyInstance:", nf.format(VALUE));
        info(nf);
        nf = NumberFormat.getIntegerInstance(l);
        print("getIntegerInstance:", nf.format(VALUE));
        info(nf);
        nf = NumberFormat.getPercentInstance(l);
        print("getPercentInstance:", nf.format(VALUE));
        info(nf);

        System.out.println();
    }

    protected static void info(NumberFormat nf) {
        //print("toString:", nf.toString());
        print("FractionDigits:", nf.getMinimumFractionDigits() + "-" + nf.getMaximumFractionDigits());
        print("IntegerDigits:", nf.getMinimumIntegerDigits() + "-" + nf.getMaximumIntegerDigits());
        print("getRoundingMode:", nf.getRoundingMode());
        print("isGroupingUsed:", nf.isGroupingUsed());
        print("isParseIntegerOnly:", nf.isParseIntegerOnly());
        System.out.println();
    }

    @Test
    public void parseTest() throws ParseException {
        Number VALUE = -1000000.455;
    	 
        System.out.println(VALUE);
        for (Locale l : NumberFormat.getAvailableLocales()) {
            System.out.println(l.getDisplayName());
            String s = NumberFormat.getNumberInstance(l).format(VALUE);
            Number p = NumberFormat.getNumberInstance(l).parse(s);
            System.out.println(s);
            System.out.println(p);
            System.out.println();
            try {
                assertTrue(VALUE.equals(p));
            } catch (AssertionError e) {
                throw new AssertionError(new StringBuilder(l.getDisplayName()).append(", ").append(VALUE).append("!=")
                        .append(p).toString());
            }
        }
    }

    protected static void print(Object v1, Object v2) {
        System.out.format(FORMAT_OUT, v1, v2);
    }

}
