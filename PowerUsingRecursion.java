public class PowerUsingRecursion {
    public static int printPowerUsingRecur(int n, int pow) {
        if (pow == 1) {
            return n;
        }

        if (pow == 0) {
            return 1;
        }

        return n * printPowerUsingRecur(n, pow - 1);
    }

    public static int optimizedPower(int n, int pow) {
        if (pow == 1) {
            return n;
        }

        if (pow == 0) {
            return 1;
        }

        boolean isEven = pow % 2 == 0;

        if (isEven) {
            int value = optimizedPower(n, pow / 2);

            return value * value;
        } else {
            int value = optimizedPower(n, pow / 2);

            return n * value * value;
        }

    }
    public static void main(String[] args) {
        // System.out.println(printPowerUsingRecur(2, 10));
        System.out.println(optimizedPower(2, 10));
    }
}
