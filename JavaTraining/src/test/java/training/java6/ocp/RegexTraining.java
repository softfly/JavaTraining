package training.java6.ocp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import training.AbstractTest;

public class RegexTraining extends AbstractTest {

    @Test
    public void quoteTest() {
        find("\\Q\07\\E", "\07");
    }

    @Test
    public void groupTest() {
        find("(?<abc>abc)(?:def)", "abcdef");
    }

    @Test
    public void POSIXTest() {
        find("\\p{Lower}+", "abcdef");
    }

    protected void find(String regex, String input) {
        print("Pattern:", regex);
        print("Input:", input);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        boolean found = false;
        while (matcher.find()) {
            print(matcher);
            found = true;
        }
        if (!found) {
            System.out.println("No match found.");
        }
    }

    @Test
    public void matchesVsLookingAtTest() {
        matches("abc", "abcdef");
        System.out.println();
        lookingAt("abc", "abcdef");
    }

    @Test
    public void regionTest() {
        String regex = "[a]+";
        String input = "bbbaa";

        print("Input:", input);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        matches(matcher);
        matcher.region(3, input.length());
        matches(matcher);
    }

    protected static void matches(String regex, String input) {
        print("Input:", input);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        matches(matcher);
    }

    protected static void matches(Matcher matcher) {
        print("Pattern:", matcher.pattern());

        boolean found = false;
        if (matcher.matches()) {
            print(matcher);
            found = true;

        }
        if (!found) {
            System.out.println("No match found.");
        }
    }

    protected static void lookingAt(String regex, String input) {
        print("Input:", input);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        lookingAt(matcher);
    }
    
    protected static void lookingAt(Matcher matcher) {
    	print("Pattern:", matcher.pattern());
    	
        boolean found = false;
        if (matcher.lookingAt()) {
            print(matcher);
            found = true;

        }
        if (!found) {
            System.out.println("No match found.");
        }
    }

    @Test
    public void replaceAllTest() {
        replaceAll("\\d", "fda43fds534a", "*");
    }

    protected static void replaceAll(String regex, String input, String replacement) {
        print("Pattern:", regex);
        print("Input:", input);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        print("Replacement:", matcher.replaceAll(replacement));
    }

    protected static void print(Matcher matcher) {
        System.out.format("I found the text \"%s\" starting at index %d and ending at index %d.%n", matcher.group(),
                matcher.start(), matcher.end());
        for (int i = 0; i <= matcher.groupCount(); i++) {
            System.out.println("Group[" + i + "]=" + matcher.group(i));
        }
    }

    protected static void print(Object v1, Object v2) {
        System.out.format("%-10s %-40s\n", v1, v2);
    }

}
