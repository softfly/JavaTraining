package training.java6.ocp.text;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SimpleDataFormatTraining {

    public static void main(String[] args) {
        Date d = new Date();
        Locale l = Locale.US;
        SimpleDateFormat sdf = new SimpleDateFormat("EEE d MMM yyy", l);
        System.out.println(sdf.format(d));
    }

}
