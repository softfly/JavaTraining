package training.java6.ocp.collection;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class EnumSetTraining {
	
    protected static String FORMAT_OUT = "%-25s %-5s%n";
    
	public enum Color {
		RED, BLUE, YELLOW
	}

	/**
	 * TODO: RegularEnumSet vs JumboEnumSet
	 */
	@Test
	public void main() {
		Set<Color> pink = EnumSet.of(Color.BLUE);
		System.out.format(FORMAT_OUT, "EnumSet.of(Color.BLUE)", pink);
		System.out.format(FORMAT_OUT, "EnumSet.copyOf(pink)", EnumSet.copyOf(pink));
		List<Color> list = Arrays.asList(Color.RED);
		System.out.format(FORMAT_OUT, "EnumSet.copyOf(list)", EnumSet.copyOf(list));
		
	}

}
