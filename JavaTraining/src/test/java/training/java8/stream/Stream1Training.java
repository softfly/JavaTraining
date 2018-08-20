package training.java8.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream1Training {

	public static void main(String[] args) {
		(new Stream1Training()).test1();
	}

	public void test1() {
		Stream<List<String>> integerListStream = Stream.of(Arrays.asList("5", "3"), Arrays.asList("3", "4"), Arrays.asList("1"));
		
		IntStream integerStream = integerListStream
				.flatMap( new Function<List<String>, Stream<String>>() {
					@Override
					public Stream<String> apply(List<String> t) {
						return t.stream();
					}
				})
				.flatMapToInt( new Function<String, IntStream>() {
					@Override
					public IntStream apply(String t) {
						return IntStream.of( Integer.parseInt(t) );
					}
				})
				.distinct()
				.sorted()
				.peek(System.out::println);
		
		System.out.println(integerStream.reduce(Integer::sum));
	}

	public void test2() {
		IntStream.iterate(1, i -> i + 1)//
				.limit(10)//
				.mapToObj(i -> new Integer(i))//
				.filter(((Predicate<Integer>) (p -> (p % 2) == 1)).negate())//
				.forEachOrdered(System.out::println);
	}

	public void test3() {
		IntStream.iterate(1, i -> i + 1)//
				.limit(10)//
				.filter(((IntPredicate) (p -> (p % 2) == 1)).negate())//
				.map(i -> i + 1).forEachOrdered(System.out::println);
	}
	
	public void test4() {
		Stream<List<Integer>> integerListStream = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(5));

		Stream<Integer> integerStream = integerListStream
				.flatMap(Collection::stream);
		integerStream.forEach(System.out::println);
	}
	
	public void test5() {
		Stream<List<String>> integerListStream = Stream.of(Arrays.asList("1", "2"), Arrays.asList("3", "4"), Arrays.asList("5"));
		
		IntStream integerStream = integerListStream
				.flatMap(Collection::stream)
				.flatMapToInt(i -> IntStream.of( Integer.parseInt(i) ) );
		integerStream.forEach(System.out::println);
	}

}
