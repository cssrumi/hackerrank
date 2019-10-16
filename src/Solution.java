import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
        SimpleDateFormat dateFormat12 = new SimpleDateFormat("hh:mm:ssaa");
        SimpleDateFormat dateFormat24 = new SimpleDateFormat("HH:mm:ss");

        try {
            return dateFormat24.format(dateFormat12.parse(s));
        } catch (ParseException e) {
            return e.getMessage();
        }

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String s = scan.nextLine();

        String result = timeConversion(s);
        System.out.println(result);
    }
}
