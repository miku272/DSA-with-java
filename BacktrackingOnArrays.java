public class BacktrackingOnArrays {
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.print("\n");
    }

    public static void backtracking(int[] arr, int index, int value) {
        if (index == arr.length) {
            printArray(arr);

            return;
        }

        arr[index] = value;
        backtracking(arr, index + 1, value + 1);
        arr[index] -= 2; // Backtracking step
    }

    public static void main(String[] args) {
        int[] arr = new int[5];

        backtracking(arr, 0, 1);

        printArray(arr);
    }
}
