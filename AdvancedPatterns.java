public class AdvancedPatterns {
    public static void invertedPyramid(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            System.out.print("\n");
        }
    }

    public static void invertedPyramidWithNumbers(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print(j + " ");
            }

            System.out.print("\n");
        }
    }

    public static void floydsTriangle(int n) {
        int counter = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(counter + " ");

                counter++;
            }

            System.out.print("\n");
        }
    }
    public static void main(String[] args) {
        // invertedPyramid(5);
        // invertedPyramidWithNumbers(30);
        floydsTriangle(20);
    }
}
