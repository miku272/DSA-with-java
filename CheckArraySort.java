public class CheckArraySort {
    public static boolean checkArraySortUsingRecursion(int[] arr, int i) {
        if (i == arr.length - 1) {
            return true;
        }

        if (arr[i] > arr[i + 1]) {
            return false;
        }

        return checkArraySortUsingRecursion(arr, i + 1);
    }

    public static void main(String[] args) {
        // int[] arr = {8, 3, 6, 9, 5, 10, 2, 5, 3};
        int[] arr = {1, 2, 3, 4, 5};

        System.out.println(checkArraySortUsingRecursion(arr, 0));
    }
}
