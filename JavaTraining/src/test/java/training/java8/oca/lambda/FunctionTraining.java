package training.java8.oca.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionTraining {

	class Person {

		private int personId;
		private String jobDescription;

		public Person(int personId, String jobDescription) {
			super();
			this.personId = personId;
			this.jobDescription = jobDescription;
		}

		public int getPersonId() {
			return personId;
		}

		public void setPersonId(int personId) {
			this.personId = personId;
		}

		public String getJobDescription() {
			return jobDescription;
		}

		public void setJobDescription(String jobDescription) {
			this.jobDescription = jobDescription;
		}

	}

	class Job {

		private int personId;
		private String description;

		public Job(int personId, String description) {
			super();
			this.personId = personId;
			this.description = description;
		}

		public int getPersonId() {
			return personId;
		}

		public void setPersonId(int personId) {
			this.personId = personId;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

	}

	Function<Person, Job> mapPersonToJob = new Function<Person, Job>() {
		
		private int i = 0;
		
		public Job apply(Person person) {
			Job job = new Job(person.getPersonId(), person.getJobDescription());
			i++;
			System.out.println(i);
			return job;
		}
	};

	public void map_objects_with_java8_function() {
		List<Person> persons = Arrays.asList(new Person(1, "Husband"), new Person(2, "Dad"),
				new Person(3, "Software engineer"), new Person(4, "Adjunct instructor"),
				new Person(5, "Pepperoni hanger"));

		List<Job> jobs = persons.stream()//
				.map(mapPersonToJob)//
				.collect(Collectors.toList());
		
		jobs.forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		new FunctionTraining().map_objects_with_java8_function();
	}
}
