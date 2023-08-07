import java.util.Arrays;

public class MinAbsoluteDifferencePairs {
    public static void main(String[] args) {
        int[] a = { 4, 1, 8, 7 };
        int[] b = { 2, 3, 6, 5 };

        int absAns = 0;

        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0; i < a.length; i++) {
            absAns += Math.abs(a[i] - b[i]);
        }

        System.out.println("Absolute minimum: " + absAns);
    }
}
