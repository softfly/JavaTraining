package training.java6.ocp.collection;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class SortedSetTraining {
    
    final String FORMAT = "%-25s %-5s%n";
    
    @Rule
    public TestName testName = new TestName();

    @Before
    public void setUp() {
        System.out.println("============= " + testName.getMethodName() + " =============");
    }

    @After
    public void tearDown() {
        System.out.println();
    }
    
    @Test
    public void methodsTest() {
        Object o1 = "1";
        Object o2 = "2";
        Object o3 = "3";
        Object o4 = "4";
        
        SortedSet<Object> s = new TreeSet<Object>();
        s.add(o1);
        s.add(o2);
        s.add(o3);
        s.add(o4);
        
        System.out.format(FORMAT, "headSet(o3)", s.headSet(o3));
        System.out.format(FORMAT, "tailSet(o3)", s.tailSet(o3));
        System.out.format(FORMAT, "subSet(o2, o3)", s.subSet(o2, o3));
    }
	
	public static class CustomComparator implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			// TODO Auto-generated method stub
			return -1;
		}

	}
	
	public static void test1() {
		Object o1 = "1";
		Object o2 = "2";
		Object o3 = new Integer(1);
		
		SortedSet<Object> s = new TreeSet<Object>(new CustomComparator());
		s.add(o1);
		s.add(o2);
		s.add(o3);
		
		SortedSet<Object> s2 = s.headSet(o2);
		
		System.out.println(s);
		System.out.println(s2);
	}
	
	@Test
	public void Test() {
		Object o1 = "1";
		Object o2 = "2";
		Object o3 = "3";
		
		SortedSet<Object> s = new TreeSet<Object>();
		s.add(o1);
		s.add(o2);
		s.add(o3);
		
		SortedSet<Object> s2 = s.tailSet(o2);
		s2.remove(o3);
		
		System.out.println(s);
		System.out.println(s2);
	}
	
}
