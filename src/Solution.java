import java.io.*;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.*;

public class Solution {

    static int minimumNumber(int n, String password) {
        String specialCharacters = "!@#$%^&*()-+";
        int minimumNum = Math.max(6 - n, 0);
        boolean isUpper = false;
        boolean isLower = false;
        boolean isNumber = false;
        boolean isSpecialCharacter = false;
        int checkSum = 4;

        CharacterIterator i = new StringCharacterIterator(password);

        while (i.current() != CharacterIterator.DONE) {
            if (Character.isUpperCase(i.current()) && !isUpper) {
                isUpper = true;
                checkSum--;
            }
            if (Character.isLowerCase(i.current()) && !isLower) {
                isLower = true;
                checkSum--;
            }
            if (Character.isDigit(i.current()) && !isNumber) {
                isNumber = true;
                checkSum--;
            }
            if (specialCharacters.indexOf(i.current()) != -1 && !isSpecialCharacter) {
                isSpecialCharacter = true;
                checkSum--;
            }
            i.next();
        }

        minimumNum = Math.max(minimumNum, checkSum);

        return minimumNum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        long[] arr = {1, 2, 3, 4, 5};
//        long result = gradingStudents(arr, 8);
//        List<Integer> list = Arrays.asList(73, 67, 38, 33);
//        List<Integer> result = gradingStudents(list);

        String str = "#HackerRank";
        int result = minimumNumber(11, str);
        System.out.println(result);
    }
}
