package training.java6.ocp.collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IteratorTraining {

	public static void main(String[] args) {
		List<Integer> list = new LinkedList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
		for (Iterator<Integer> it=list.iterator();it.hasNext();) {
			//it.next();
			it.remove();
			it.remove();
		}
	}

}
