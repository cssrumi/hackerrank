import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Solution {

    public static Integer gradeRounding(Integer grade) {
        if (grade < 38) return grade;
        else if (grade % 5 > 2) return grade + 5 - grade % 5;
        else return grade;
    }

    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> newGrades = grades.stream()
                .map(Solution::gradeRounding)
                .collect(Collectors.toList());
        return newGrades;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        long[] arr = {1, 2, 3, 4, 5};
//        long result = gradingStudents(arr, 8);

        List<Integer> list = Arrays.asList(73, 67, 38, 33);
        List<Integer> result = gradingStudents(list);
        System.out.println(result);
    }
}
