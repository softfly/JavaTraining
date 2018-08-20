package training.java6.oca;

public class MemberInnerClassTraining {
	
	static int a = 2;
	static void print() {
	}
	
	private class MemberInnerClass {
		static int a = 2;
		
		static void print() {
			
		}
	}
	
	private void test() {
		class LocalClass {
			static int a = 2;
			
			static void print() {
				
			}
		}
	}

}
