import java.io.*;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.*;

public class Solution {

    static int camelcase(String s) {
        CharacterIterator i = new StringCharacterIterator(s);
        int counter = 1;
        while (i.current() != CharacterIterator.DONE) {
            if (Character.isUpperCase(i.next())) counter++;
        }
        return counter;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        long[] arr = {1, 2, 3, 4, 5};
//        long result = gradingStudents(arr, 8);
//        List<Integer> list = Arrays.asList(73, 67, 38, 33);
//        List<Integer> result = gradingStudents(list);

        String str = "baaddCrrcEb";
        int result = camelcase(str);
        System.out.println(result);
    }
}
