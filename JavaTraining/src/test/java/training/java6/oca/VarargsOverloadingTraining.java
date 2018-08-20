package training.java6.oca;

public class VarargsOverloadingTraining {

	static class A {

		public void test(int[] a) {
			System.out.println("A");

		}
	}

	static class B extends A {

		public void test(int... a) {
			System.out.println("B");
		}

	}

	public static void main(String[] args) {
		(new B()).test(new int[] { 1, 2 }); //B
		(new B()).test(1, 2); //B
	}

}
