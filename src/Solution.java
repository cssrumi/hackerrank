import java.io.*;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class Solution {

    static String hackerrankInString(String s) {
        String h = "hackerrank";
        CharacterIterator hi = new StringCharacterIterator(h);
        CharacterIterator si = new StringCharacterIterator(s);

        char hCur = hi.current();
        char sCur = si.current();

        while (sCur != CharacterIterator.DONE) {
            if (hCur == sCur) hCur = hi.next();
            sCur = si.next();
            if (hCur == CharacterIterator.DONE) return "YES";
        }
        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        long[] arr = {1, 2, 3, 4, 5};
//        long result = gradingStudents(arr, 8);
//        List<Integer> list = Arrays.asList(73, 67, 38, 33);
//        List<Integer> result = gradingStudents(list);

        String str = "hereiamstackerrank";
        String result = hackerrankInString(str);
        System.out.println(result);
    }
}
