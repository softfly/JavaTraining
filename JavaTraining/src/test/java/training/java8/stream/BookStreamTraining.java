package training.java8.stream;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.BinaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

import java.time.Year;

import static java.util.Comparator.*;

public class BookStreamTraining {

	enum Topic {
		HISTORY, PROGRAMMING, MEDICINE, COMPUTING, FICTION
	}

	class Book {

		private String title;

		private List<String> authors;

		private int[] pageCounts;

		private Topic topic;

		private Year pubDate;

		private double height;

		public Book(String title, List<String> authors, int[] pageCounts, Year pubDate, double height, Topic topic) {
			super();
			this.title = title;
			this.authors = authors;
			this.pageCounts = pageCounts;
			this.topic = topic;
			this.pubDate = pubDate;
			this.height = height;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public List<String> getAuthors() {
			return authors;
		}

		public void setAuthors(List<String> authors) {
			this.authors = authors;
		}

		public int[] getPageCounts() {
			return pageCounts;
		}

		public void setPageCounts(int[] pageCounts) {
			this.pageCounts = pageCounts;
		}

		public Topic getTopic() {
			return topic;
		}

		public void setTopic(Topic topic) {
			this.topic = topic;
		}

		public Year getPubDate() {
			return pubDate;
		}

		public void setPubDate(Year pubDate) {
			this.pubDate = pubDate;
		}

		public double getHeight() {
			return height;
		}

		public void setHeight(double height) {
			this.height = height;
		}

	}

	public List<Book> getLibrary() {
		List<Book> library = new LinkedList<>();
		library.add(new Book("Fundamentals of Chinese Fingernail Image", //
				Arrays.asList("Li", "Fu", "Li"), //
				new int[] { 256 }, // pageCount per volume
				Year.of(2014), // publication date
				25.2, // height in cms
				Topic.MEDICINE));
		library.add(new Book("Compilers: Principles, Techniques and Tools", //
				Arrays.asList("Aho", "Lam", "Sethi", "Ullman"), //
				new int[] { 1009 }, //
				Year.of(2006), // publication date (2nd edition)
				23.6, //
				Topic.COMPUTING));
		library.add(new Book("Voss", //
				Arrays.asList("Patrick White"), //
				new int[] { 478 }, //
				Year.of(1957), //
				19.8, //
				Topic.FICTION));
		library.add(new Book("Lord of the Rings", //
				Arrays.asList("Tolkien"), //
				new int[] { 531, 416, 624 }, //
				Year.of(1955), //
				23.0, //
				Topic.FICTION));
		return library;
	}

	List<Book> library = getLibrary();

	public static void main(String[] args) {
		(new BookStreamTraining()).testToMap();
	}

	/**
	 * Mastering lambdas s86
	 * 
	 * @return
	 */
	public Optional<Topic> getMostPopularTopic() {
		return library.stream().collect(groupingBy(Book::getTopic, counting())).entrySet().stream()
				.max(Map.Entry.comparingByValue()).map(Map.Entry::getKey);
	}

	public void testToMap() {
		Map<Topic, List<Book>> booksByTopic = library.stream().collect(groupingBy(Book::getTopic));
		System.out.println(booksByTopic);

		Map<String, Year> titleToPubDate = library.stream().collect(//
				toMap(//
						Book::getTitle, //
						Book::getPubDate, //
						BinaryOperator.maxBy(naturalOrder()), //
						TreeMap::new//
				)//
		);
		System.out.println(titleToPubDate);

		Map<Boolean, List<Book>> fictionOrNon = library.stream().collect(//
				partitioningBy(b -> b.getTopic() == Topic.FICTION)//
		);
		System.out.println(fictionOrNon);

		Map<Topic, Optional<Book>> mostAuthorsByTopic = library.stream().collect(//
				groupingBy(//
						Book::getTopic, //
						maxBy(comparing(b -> b.getAuthors().size()))//

				)//
		);

		Map<Topic, Integer> volumeCountByTopic = library.stream().collect(//
				groupingBy(//
						Book::getTopic, //
						summingInt(b -> b.getPageCounts())//
				)//
		);

		Optional<Topic> mostPopularTopic = library.stream()//
				.collect(groupingBy(Book::getTopic, counting()))//
				.entrySet().stream()//
				.max(Map.Entry.comparingByValue())//
				.map(Map.Entry::getKey);//

		Map<Topic, String> concatenatedTitlesByTopic = library.stream()
				.collect(groupingBy(Book::getTopic, mapping(Book::getTitle, joining(";"))));

	}

}
