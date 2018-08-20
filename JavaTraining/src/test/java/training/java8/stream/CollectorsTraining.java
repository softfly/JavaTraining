package training.java8.stream;

import java.util.stream.Stream;
import static java.util.stream.Collectors.*;

public class CollectorsTraining {

	static class Book {

		String title;

		public Book(String title) {
			super();
			this.title = title;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

	}

	public static void main(String[] args) {
		String concatenatedTitles = Stream.iterate(1, i -> i + 1)//
				.limit(10)//
				.map(i -> new Book("Test" + i))//
				.map(Book::getTitle)//
				.collect(joining("::"));
		
		System.out.println(concatenatedTitles);

	}

}
