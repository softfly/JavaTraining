package training.java8.oca;

public class InterfaceTraining implements Person {
	
	public final int avaregeAge=20;
	
	public static void main(String... args) {
		InterfaceTraining training = new InterfaceTraining();
		System.out.println(Person.getAvaregeAge());
		System.out.println(training.getAvaregeAgeD());
	}

}
