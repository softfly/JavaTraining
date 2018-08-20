package training.java8.oca;

public interface Person {
	
	int avaregeAge=10;
	
	static int getAvaregeAge() {
		return avaregeAge;
	}
	
	default int getAvaregeAgeD() {
		return avaregeAge;
	}

}
