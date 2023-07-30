import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingLetter {
    public static String firstNonRepeatingLetter(String stream) {
        Queue<Character> charQueue = new LinkedList<>();
        int[] frequency = new int[26]; // subtract 97 from the characters to get the actual position
        String finalAnswer = "";

        for (int i = 0; i < stream.length(); i++) {
            char ch = stream.charAt(i);

            charQueue.add(ch);
            frequency[ch - 'a']++;

            while (!charQueue.isEmpty() && frequency[charQueue.peek() - 'a'] > 1) {
                charQueue.remove();
            }

            if (charQueue.isEmpty()) {
            finalAnswer += "-1";
            } else {
            finalAnswer += charQueue.peek();
            }

            // if (charQueue.isEmpty()) {
            //     System.out.println("-1" + " ");
            // } else {
            //     System.out.println(charQueue.peek() + " ");
            // }
        }

        return finalAnswer;
    }

    public static void main(String[] args) {
        String stream = "aabccxb";

        System.out.println(firstNonRepeatingLetter(stream));
    }
}