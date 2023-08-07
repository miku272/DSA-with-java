import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int[] valArr = { 60, 100, 120 };
        int[] weightArr = { 10, 20, 30 };
        int weight = 50;

        double[][] ratioArr = new double[valArr.length][2]; // 0th Col => Original Index, 1st Col => Ratio

        for (int i = 0; i < valArr.length; i++) {
            ratioArr[i][0] = i;

            ratioArr[i][1] = valArr[i] / (double) weightArr[i];
        }

        Arrays.sort(ratioArr, Comparator.comparingDouble(o -> o[1]));

        int capacity = weight;
        int finalValue = 0;

        for (int i = ratioArr.length - 1; i >= 0; i--) {
            int index = (int) ratioArr[i][0];

            if (capacity >= weightArr[index]) {
                finalValue += valArr[index];

                capacity -= weightArr[index];
            } else {
                finalValue += (capacity * ratioArr[i][1]);
                capacity = 0;

                break;
            }
        }

        System.out.println("Max Value: " + finalValue);
    }
}
