package training.java8.oca.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import training.java8.oca.lambda.FunctionTraining.Person;

public class StringTraining {
	
	public class Person {
		
		private String lastName;
		
		public Person(String lastName) {
			super();
			this.lastName = lastName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		
	}

	public static void main(String[] args) {
		new StringTraining().test2();

	}
	
	public void test() {
		List<Person> persons = Arrays.asList(new Person("Husband"), new Person("Dad"),
				new Person("Software engineer"), new Person("Adjunct instructor"),
				new Person("Pepperoni hanger"));
		
	}
	
	public void test2() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("alpha", "X");
		map.put("bravo", "Y");
		map.put("charlie", "Z");
		System.out.println(map);
		
		
		String str = "alpha-bravo-charlie";
		map.replaceAll(str::replace);
		System.out.println(map);
	}
	

}
