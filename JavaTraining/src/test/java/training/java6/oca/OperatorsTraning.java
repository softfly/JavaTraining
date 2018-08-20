package training.java6.oca;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class OperatorsTraning {

    @Test
    public void bitwiseTest() {
        int i = Integer.MIN_VALUE;
        System.out.println(i);
        System.out.println(toBinaryString(i));
        System.out.println(i << 1);
        System.out.println(toBinaryString(i << 1));
        System.out.println(i >> 1);
        System.out.println(toBinaryString(i >> 1));
        System.out.println(i >>> 1);
        System.out.println(toBinaryString(i >>> 1));
    }

    @Test
    public void test() {
        int a = 1;
        int b = 2;

        // Okay. Prints
        if (a == 1 | b == 3) {
            System.out.println("Comparison via |" + "\na is " + a + "\nb is " + b);
        }

        // Okay. Prints
        if (a == 1 || b == 3) {
            System.out.println("Comparison via ||" + "\na is " + a + "\nb is " + b);
        }

        // Okay. Does not print
        if (a == 1 & b == 3) {
            System.out.println("Comparison via &" + "\na is " + a + "\nb is " + b);
        }

        // I don't understand. Shouldn't the Short Circuit succeed since the left side of the equation equals 1?
        if (a == 1 && b == 3) {
            System.out.println("Comparison via &&" + "\na is " + a + "\nb is " + b);
        }
    }

    protected String toBinaryString(int i) {
        return StringUtils.leftPad(Integer.toBinaryString(i), 32, '0');
    }

}
