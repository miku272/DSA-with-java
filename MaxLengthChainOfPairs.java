import java.util.Arrays;
import java.util.Comparator;

public class MaxLengthChainOfPairs {
    public static void main(String[] args) {
        int[][] pairArr = { { 5, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40 }, { 50, 90 } };

        Arrays.sort(pairArr, Comparator.comparingDouble(o -> o[1]));

        int chainLength = 1;
        int chainEnd = pairArr[0][1]; // Selected pair's last element (Chain end)

        for (int i = 1; i < pairArr.length; i++) {
            if (pairArr[i][0] > chainEnd) {
                chainLength++;

                chainEnd = pairArr[i][1];
            }
        }

        System.out.print("Max length of chain: " + chainLength);
    }
}
