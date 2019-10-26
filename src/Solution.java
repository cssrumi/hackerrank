import java.io.*;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class Solution {

    static String caesarCipher(String s, int k) {
        StringBuffer sb = new StringBuffer(s.length());
        int diff = 'z' - 'a' + 1;
        int realK = k % diff;
        int lowerA = 'a';
        int upperA = 'A';

        CharacterIterator i = new StringCharacterIterator(s);
        char current = i.current();
        while (current != CharacterIterator.DONE) {
            if (Character.isUpperCase(current)) {
                sb.append((char) ((current - upperA + realK) % diff + upperA));
            } else if (Character.isLowerCase(current)) {
                sb.append((char) ((current - lowerA + realK) % diff + lowerA));
            } else sb.append(current);

            current = i.next();
        }
        return sb.toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        long[] arr = {1, 2, 3, 4, 5};
//        long result = gradingStudents(arr, 8);
//        List<Integer> list = Arrays.asList(73, 67, 38, 33);
//        List<Integer> result = gradingStudents(list);

        String str = "middle-Outz";
        String result = caesarCipher(str, 2);
        System.out.println(result);
    }
}
