import java.io.*;
import java.util.stream.*;


class Result {

    /*
    Base case:
    If the input has a length of less than 2, the function returns 0
    
    Recursive case:
    If the input string s has a length greater than 1, We check if the first character  matches the second character. If there is a match, We count the number of consecutive matching characters and remove them. Then, we recursively call the alternatingCharacters function with the remaining substring.

     */

        public static int alternatingCharacters(String s) {
        if (s.length() <= 1) {
            return 0;
        }

        char firstChar = s.charAt(0);
        int i = 1;
        while (i < s.length() && s.charAt(i) == firstChar) {
            i++;
        }

        String remainder = s.substring(i);
        
        return (s.length() - remainder.length() - 1) + alternatingCharacters(remainder);
    }
    
   

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.alternatingCharacters(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
