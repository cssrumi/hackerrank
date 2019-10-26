import java.io.*;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class Solution {

    static int marsExploration(String s) {
        String sos = "SOS";
        int diff = 0;
        String temp;

        for (int i = 0; i < s.length(); i += sos.length()) {
            temp = s.substring(i, i + sos.length());
            for (int l = 0; l < sos.length(); l++) {
                if (temp.charAt(l) != sos.charAt(l)) diff++;
            }
        }
        return diff;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        long[] arr = {1, 2, 3, 4, 5};
//        long result = gradingStudents(arr, 8);
//        List<Integer> list = Arrays.asList(73, 67, 38, 33);
//        List<Integer> result = gradingStudents(list);

        String str = "SOSSPSSQSSOR";
        int result = marsExploration(str);
        System.out.println(result);
    }
}
