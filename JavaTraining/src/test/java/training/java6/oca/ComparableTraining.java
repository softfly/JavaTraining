package training.java6.oca;

public class ComparableTraining {

	public static void main(String[] args) {
		System.out.println("a".compareTo("a"));// 0
		System.out.println("a".compareTo("z"));// -25
		System.out.println("z".compareTo("a"));// 25
		System.out.println("a".compareTo("az"));// -1
		System.out.println("aa".compareTo("az"));// -25
		System.out.println("a".compareTo("A"));// 32
	}
}
