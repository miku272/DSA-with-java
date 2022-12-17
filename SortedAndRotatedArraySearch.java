public class SortedAndRotatedArraySearch {
    public static int arraySearch(int[] arr, int target, int sI, int eI) {
        if (sI > eI) {
            return -1;
        }

        int mid = sI + (eI - sI) / 2;

        if (arr[mid] == target) {
            return mid;
        }

        if (arr[sI] <= arr[mid]) {
            if (arr[sI] <= target && target <= arr[mid]) {
                return arraySearch(arr, target, sI, mid - 1);
            } else {
                return arraySearch(arr, target, mid + 1, eI);
            }
        } else {
            if (arr[mid] <= target && target <= arr[eI]) {
                return arraySearch(arr, target, mid + 1, eI);
            } else {
                return arraySearch(arr, target, sI, mid - 1);
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int target = 7;

        System.out.println("Index: " + arraySearch(arr, target, 0, arr.length - 1));
    }
}
