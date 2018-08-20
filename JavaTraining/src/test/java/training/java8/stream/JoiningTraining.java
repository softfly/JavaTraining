package training.java8.stream;

import java.util.Arrays;
import java.util.stream.Collectors;

public class JoiningTraining {
	
	public static void main(String[] arg) {
		
		String joined = Arrays.asList("1", "2", "3").stream()
				  .collect(Collectors.joining());
		System.out.println(joined);

	}

}
