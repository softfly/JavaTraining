package training.java6.oca;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class StringTraining {

    protected static String FORMAT_OUT = "%-40s %-5s%n";

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
    
    protected void print(String val1, String val2) {
        System.out.format(FORMAT_OUT, val1, val2);
    }

    @Test
    public void constructorTest() {
        System.out.format(FORMAT_OUT, "String(byte[] bytes, int offset, int length, Charset charset)",
                new String(new byte[] { 0, 0, 0, 97, 0, 0, 0, 98, 0, 0, 0, 99 }, 0, 12, Charset.forName("UTF-32")));
        System.out.format(FORMAT_OUT, "String(int[] codePoints, int offset, int count)",
                new String(new int[] { 97, 98, 99 }, 0, 3));
    }

    @Test
    public void creatingTest() {
        char[] data = { 'a', 'b', 'c', 'd' };
        System.out.format(FORMAT_OUT, "copyValueOf", String.copyValueOf(data, 0, 4));
        System.out.format(FORMAT_OUT, "valueOf", String.valueOf(data, 0, 4));
        System.out.format(FORMAT_OUT, "valueOf", String.valueOf(new Object()));
    }

    @Test
    public void gettersTest() {
        String s = "abc";
        char[] c = new char[s.length()];
        s.getChars(0, 3, c, 0);
        System.out.format(FORMAT_OUT, "getChars", Arrays.toString(c));
        System.out.format(FORMAT_OUT, "getBytes", Arrays.toString(s.getBytes()));
    }
    
    @Test
    public void compareTest() {
        System.out.format(FORMAT_OUT, "a.compareTo(a)", "a".compareTo(new String("a")));
        System.out.format(FORMAT_OUT, "a.compareTo(azz)", "a".compareTo(new String("azz")));
        System.out.format(FORMAT_OUT, "z.compareTo(a)", "z".compareTo(new String("a")));
        System.out.format(FORMAT_OUT, "zz.compareTo(a)", "zz".compareTo(new String("a")));
        System.out.format(FORMAT_OUT, "zz.compareToIgnoreCase(A)", "zz".compareToIgnoreCase(new String("A")));
        System.out.format(FORMAT_OUT, "contentEquals", "abab".contentEquals(new String("abab")));
        System.out.format(FORMAT_OUT, "equals", "abab".equals(new String("abab")));
    }
    
    @Test
    public void manipulateTest() {
        String s = "abaabab";
        System.out.format(FORMAT_OUT, "a.concat(bb)", "aa".concat("bb"));
        System.out.format(FORMAT_OUT, "abab.replace('a', 'b')", "abab".replace('a', 'b'));
    }
    
    @Test
    public void searchingTest() {
        System.out.format(FORMAT_OUT, "abbb.contains(ab)", "abbb".contains("ab"));
        System.out.format(FORMAT_OUT, "abbb.endsWith(bb)", "abbb".endsWith("bb"));
        System.out.format(FORMAT_OUT, "regionMatches", "abaabcab".regionMatches(true, 3, "ABcd", 0, 3));
        System.out.format(FORMAT_OUT, "indexOf", "abbb".indexOf("a"));
    }

    @Test
    public void substringTest() {
        String s = "abaabab";
        System.out.format(FORMAT_OUT, "STRING:", s);
        for (int i = -2; i < 5; i++) {
            System.out.format(FORMAT_OUT, String.format("split([b], %s)", i), Arrays.toString(s.split("[b]", i)));
        }
    }

    /**
     * https://www.javatpoint.com/java-string-intern
     */
    @Test
    public void internTest() {
        String s1 = new String("hello");
        String s2 = "hello";
        String s3 = s1.intern();//returns string from pool, now it will be same as s2  
        System.out.format(FORMAT_OUT, "s1==s2", s1 == s2);//false because reference is different
        System.out.format(FORMAT_OUT, "s2==s3", s2 == s3);//true because reference is same 	
    }

    @Test
    public void utf16Test() {
        String s = Stream
                .of(Character.toChars(66304), //
                        Character.toChars(65), //
                        Character.toChars(66305), //
                        Character.toChars(66))//
                .map(x -> String.valueOf(x))//
                .collect(Collectors.joining());

        System.out.format(FORMAT_OUT, "STRING:", s);
        System.out.format(FORMAT_OUT, "length", s.length());//2+1+2+1=6
        System.out.format(FORMAT_OUT, "codePointCount", s.codePointCount(0, s.length()));//4
        System.out.format(FORMAT_OUT, "getBytes().length", s.getBytes().length);//4+1+4+1=10
        for (int i = 0; i <= s.codePointCount(0, s.length()); i++) {
            for (int ii = 0; i + ii <= s.codePointCount(0, s.length()); ii++) {
                System.out.format(FORMAT_OUT, String.format("offsetByCodePoints(%s, %s)", i, ii),
                        s.offsetByCodePoints(i, ii));
            }
        }
        /*for (byte b : s.getBytes()) {
            System.out.println(b);
        }*/
        for (int i = 0; i < s.length(); i++) {
            System.out.format(FORMAT_OUT, String.format("charAt(%s)", i), s.charAt(i));
            System.out.format(FORMAT_OUT, String.format("codePointAt(%s)", i), s.codePointAt(i));
        }
    }

    @Test
    public void regexTest() {
        String s = "abab";
        System.out.format(FORMAT_OUT, "matches", s.matches("aa"));
        System.out.format(FORMAT_OUT, "replaceAll", s.replaceAll("a", "b"));
        System.out.format(FORMAT_OUT, "replaceFirst", s.replaceFirst("a", "b"));
    }

}
