import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'staircase' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void staircase(int n) {
        
        /* this approach creates the staircase one layer at a time */
        
        for (int i = 1; i <= n; i++) {
            
            /* Using StringBuilder improves effeciency by bypassing the need for intermediate  
               string objects */
            StringBuilder stairBuilder = new StringBuilder();
            
            stairBuilder.append(" ".repeat(n - i));
            stairBuilder.append("#".repeat(i));
            
            System.out.println(stairBuilder.toString());
        }
    }   
}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result.staircase(n);

        bufferedReader.close();
    }
}

