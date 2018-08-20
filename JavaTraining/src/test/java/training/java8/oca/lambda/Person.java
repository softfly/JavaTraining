package training.java8.oca.lambda;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Person {

	public enum Sex {
		MALE, FEMALE
	}

	String name;

	LocalDate birthday;

	Sex gender;

	String emailAddress;

	Integer age;

	public Person(String name, LocalDate birthday, Sex gender, String emailAddress, Integer age) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.emailAddress = emailAddress;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public Sex getGender() {
		return gender;
	}

	public void setGender(Sex gender) {
		this.gender = gender;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void printPerson() {
		System.out.println(this.toString());
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	static List<Person> roster = Arrays.asList(//
			new Person("Greg", LocalDate.now(), Sex.MALE, "test@example.com", 45),//
			new Person("Greg", LocalDate.now(), Sex.MALE, "test@example.com", 45),//
			new Person("Greg", LocalDate.now(), Sex.MALE, "test@example.com", 45),//
			new Person("Greg", LocalDate.now(), Sex.MALE, "test@example.com", 45)//
	);

	public static <X, Y> void processElements(Iterable<X> source, Predicate<X> tester, Function<X, Y> mapper,
			Consumer<Y> block) {
		for (X p : source) {
			if (tester.test(p)) {
				Y data = mapper.apply(p);
				block.accept(data);
			}
		}
	}

	public static int compareByAge(Person a, Person b) {
		return a.birthday.compareTo(b.birthday);
	}

	public static void main(String[] args) {
		processElements(roster, p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25,
				p -> p.getEmailAddress(), email -> System.out.println(email));
		
		Person[] rosterAsArray = roster.toArray(new Person[roster.size()]);

		        
		Arrays.sort(rosterAsArray, Person::compareByAge );
		
	}

}
