import java.util.ArrayList;

public class IndianCoins {
    public static void main(String[] args) {
        int[] denominations = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };
        // int value = 590;
        int value = 1059;

        int remainingValue = value;
        int maxCurrency = 0;
        ArrayList<Integer> currencyUsed = new ArrayList<Integer>();

        while (remainingValue > 0) {
            for (int i = denominations.length - 1; i >= 0; i--) {
                if (denominations[i] <= remainingValue) {
                    remainingValue -= denominations[i];
                    currencyUsed.add(denominations[i]);
                    maxCurrency++;
                    i++;
                }
            }
        }

        System.out.println("Max currency used: " + maxCurrency);
        System.out.println("Currency used: " + currencyUsed);
    }
}
