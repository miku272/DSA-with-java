public class TilingProblem {
    public static int tilingWays(int n) { // Breadth will always be 2. here 'int n' tells us the total length
        // Base case
        if (n == 0 || n == 1) {
            return 1;
        }

        // For vertical choice (If we choose vertical choice, we assume that we placed 1 tile vertically already)
        int verticalTiles = tilingWays(n - 1);

        // For horizontal choice (If we choose vertical choice, we assume that we placed 2 tile horizontally already)
        int horizontalTiles = tilingWays(n - 2);

        int totalWays = verticalTiles + horizontalTiles;

        return totalWays;
    }
    public static void main(String[] args) {
        System.out.println(tilingWays(10));
    }
}
