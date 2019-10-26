import java.io.*;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.*;

public class Solution {

    static boolean isAllNextUnique(String str) {
        if (str.length() == 0) return false;
        CharacterIterator iter = new StringCharacterIterator(str);
        char cur = iter.current();

        while (iter.next() != CharacterIterator.DONE) {
            if (cur == iter.current()) return false;
            cur = iter.current();
        }
        return true;
    }

    static String superReducedString(String s) {
        String emptyString = "Empty String";
        String tempString = s;

        CharacterIterator iter;
        char cur;
        int counter;

        while (!isAllNextUnique(tempString)) {
            if (tempString.length() == 0) return emptyString;
            iter = new StringCharacterIterator(tempString);
            cur = iter.current();
            counter = 0;
            while (iter.next() != CharacterIterator.DONE) {
                if (cur == iter.current()) {
                    tempString = tempString.substring(0, counter) + tempString.substring(counter + 2);
                    break;
                }
                cur = iter.current();
                counter++;
            }
        }
        return tempString;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        long[] arr = {1, 2, 3, 4, 5};
//        long result = gradingStudents(arr, 8);
//        List<Integer> list = Arrays.asList(73, 67, 38, 33);
//        List<Integer> result = gradingStudents(list);

        String str = "baaddcrrcb";
        String result = superReducedString(str);
        System.out.println(result);
    }
}
