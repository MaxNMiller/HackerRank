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
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        
        List<Long> longarr = arr.stream().map(Integer::longValue).collect(Collectors.toList());
        Collections.sort(longarr);

        // sum without the last element (largest number)
        long mini = longarr.get(0) + longarr.get(1) + longarr.get(2) + longarr.get(3);
        
       // sum without the first element (smallest number)
        long max = longarr.get(1) + longarr.get(2) + longarr.get(3) + longarr.get(4);

        //Print the space-separated integers on one line
        System.out.println(mini + " " + max);

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
