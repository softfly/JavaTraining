package training.java6.oca;

public class AssertionsTraining {

	public static void main(String[] args) {
		assert Integer.parseInt(args[0]) < 10 : "x=" + args[0];
		System.out.println(args[0]);
	}

}
