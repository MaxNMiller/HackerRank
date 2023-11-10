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
import  javafx.util.Pair;

class Result {

    /*
     * Complete the 'icecreamParlor' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER m
     *  2. INTEGER_ARRAY arr
     */


/* 
Recursive Definition:
Let f(i, m) denote the number of combinations considering ice cream prices up to index i, with remaining money equal to m. The base case is defined as f(i, m) = 0 when i < 0 or m < 0.

Recursive Relation:
f(i, m) = f(i - 1, m) + (does (m - arr[i]) exist in prices[0..i-1] ? 1 : 0)
*/


public static Integer icecreamParlor(int m, List<Integer> arr) {
        Map<Integer, Integer> priceIndices = new HashMap<>();

        int result = 0;

        for (int i = 0; i < arr.size(); i++) {
            int currentPrice = arr.get(i);
            int complement = m - currentPrice;

            if (priceIndices.containsKey(complement)) {
                result++;
            }

            priceIndices.put(currentPrice, i + 1); 
        }

        return result;
    }
}


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int m = Integer.parseInt(bufferedReader.readLine().trim());

                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                Integer result = Result.icecreamParlor(m, arr);
                bufferedWriter.write(result.toString() + "\n");
                
                // bufferedWriter.write(
                //     result.stream()
                //         .map(Object::toString)
                //         .collect(joining(" "))
                //     + "\n"
                // );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
