package training.java6.ocp;

import java.util.Formatter;

public class FormatterTraining {

	public static void main(String[] args) {
		Formatter f = new Formatter(System.out);
		f.format("%b %b\n", true, false);
		f.format("%h %H\n", 255, 255);
		
	}

}
