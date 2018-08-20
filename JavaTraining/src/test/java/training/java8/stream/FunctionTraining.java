package training.java8.stream;

import java.util.function.BinaryOperator;
import java.util.function.Function;

public class FunctionTraining {

	public static void main(String[] args) {
		Function<Integer, String> f = (Integer i) -> i.toString(); 
		
		
		BinaryOperator<String> binaryOpt = (s1,s2)-> s1+"-"+s2; 

	}

}
