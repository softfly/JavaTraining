package training.java6.ocp.collection;

import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;



public class NavigableSetTraining {

	public static void main(String[] args) {
		Object o1 = 1;
		Object o2 = 2;
		Object o3 = 3;
		Object o4 = 4;
		Object o5 = 5;
		
		NavigableSet<Object> s = new TreeSet<Object>();
		//s.add(o1);
		s.add(o2);
		//s.add(o3);
		s.add(o4);
		//s.add(o5);
		
		System.out.println("Lower: " + s.lower(o3));
		System.out.println("Floor: " + s.floor(o3));
		
		System.out.println("Higher: " + s.higher(o3));
		System.out.println("Ceiling: " + s.ceiling(o3));
		
		
		System.out.println(s.subSet(o1, false, o5, false));
		
		
	}

}
