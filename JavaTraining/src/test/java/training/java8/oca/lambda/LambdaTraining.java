package training.java8.oca.lambda;

import java.awt.Point;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import static java.util.Comparator.comparing;

public class LambdaTraining extends LambdaTraining2 {
	
	private static Integer p3 = 10;
	
	private Integer p4 = 10;

	public static void main(String[] args) {
		(new LambdaTraining()).main();
	}
	
	/*
	private static BiFunction<Integer, Integer, Integer> sum = (p1, p2) ->  {
		int p3 = 20;
		return p3 + p4 + p5 + p1 + p2 + this.getP4() + super.getP();
	};*/
	
	public void main() {
		Integer p5 = 10;
		
		BiFunction<Integer, Integer, Integer> sum = (p1, p2) ->  {
			//int p5 = 20;
			return p3 + p4 + p5 + p1 + p2 + this.getP4() + super.getP();
		};
		
		System.out.println(sum.apply(1, 2));
	}
	
	public Integer getP4() {
		return this.p4;
	}
	
	

}
