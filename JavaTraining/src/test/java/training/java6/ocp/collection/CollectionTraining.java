package training.java6.ocp.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

import org.junit.Test;

public class CollectionTraining {

    public static void main(String[] args) {
        Collection<String> c = new ArrayList<String>();
        c.add("Test");
        c.add("test2");

        //String[] a1 = (String[]) c.toArray();
        String[] a2 = c.toArray(new String[c.size()]);
        a2[0] = null;
        a2[1] = null;

        System.out.println(a2.toString());
        System.out.println(c);
    }

    public static void test1() {
        Collection<String> c = new ArrayList<String>();
        c.add("Test");
        c.add("test2");

        String[] a1 = (String[]) c.toArray();
        String[] a2 = c.toArray(new String[c.size()]);
        System.out.println(a2);
    }

    @Test
    public void subListTest() {
        List<Integer> l = new ArrayList<Integer>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);

        System.out.println(l.subList(1, 5));
    }

    @Test
    public void addNullPointerExceptionTest() throws InstantiationException, IllegalAccessException {
        List<Class> list = Arrays.asList(ArrayList.class, LinkedBlockingQueue.class);
        for (Class<Collection<Integer>> clazz : list) {
            System.out.println(clazz.getName());
            Collection<Integer> c = clazz.newInstance();
            try {
                c.add(null);
                System.out.println(c);
            } catch (NullPointerException e) {
                System.out.println("Null don't support");
            }
        }

    }

}
