import java.util.Random;

public class Smit {
    public static void generateNumbers(int[] numArray) {
        Random rng = new Random();

        numArray[0] = rng.nextInt(1, 50);

        for (int i = 0; i < numArray.length; i++) {
            numArray[i] = rng.nextInt(1, 50);

            for(int j = 0; j < i; j++) {
                if (numArray[i] == numArray[j]) {
                    i--;
                }
            }
        }

        for (int i = 0; i < numArray.length; i++) {
            System.out.print(numArray[i] + " ");
        }
    }

    public static String buildString(int[] numArray) {
        StringBuilder str = new StringBuilder("");

        for (int i = 0; i < numArray.length; i++) {
            str.append(Integer.valueOf(numArray[i]).toString());
        }

        return str.toString();
    }

    public static int compareArrays(int[] arr1, int[] arr2) {
        return 0;
    }

    public static void main(String[] args) {
        int[] playerNumbers = new int[7];
        int[] winNumbers = new int[6];

        generateNumbers(playerNumbers);
        generateNumbers(winNumbers);

        System.out.println(buildString(winNumbers));
    }
}