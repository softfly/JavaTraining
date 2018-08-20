package training.java6.oca;

import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CharacterTraining {

    protected static String FORMAT_OUT = "%-25s %-5s%n";

    public static void main(String[] args) {
        Object[] a = Stream.of(Character.toChars(66304), Character.toChars(66305), Character.toChars(65))//
                .flatMapToInt(x -> CharBuffer.wrap(x).chars())//
                .mapToObj(i -> (char) i)//
                .toArray(Character[]::new);
        
        char[] c = Stream.of(Character.toChars(66304), Character.toChars(66305), Character.toChars(65))//
                .map(x -> String.valueOf(x))
                .collect(Collectors.joining())
                .toCharArray();
        System.out.println(c);
    }

}
