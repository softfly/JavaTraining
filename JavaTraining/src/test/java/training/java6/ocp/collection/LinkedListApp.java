package training.java6.ocp.collection;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListApp {

	public static void main(String[] args) {
		test1();

	}
	
	public static void test1() {
		LinkedList<Integer> list = new LinkedList<Integer>(Arrays.asList(1,2,3,4,5));
		ListIterator<Integer> it = list.listIterator();
		it.previous();
		it.add(0);
		
		System.out.println(list);
	}
	

	

}
