package training.java6.oca;

public class StaticVariableTraining {

    static public class B {

        static String s1 = "B";

        String s2 = "B";

    }

    static class A extends B {

        static String s1 = "A";

        String s2 = "A";

    }

    public static void main(String[] args) {
        B b = new A();
        System.out.println(b.s1);
        System.out.println(b.s2);
    }

}
