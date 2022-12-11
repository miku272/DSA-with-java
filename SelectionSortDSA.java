public class SelectionSortDSA {
    static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    static void swap(int[] array, int indexA, int indexB) {
        int temp = array[indexA];

        array[indexA] = array[indexB];
        array[indexB] = temp;
    }

    static void selectionSort(int[] array) {
        for (int start = 0; start < array.length - 1; start++) {
            int lowest = start;

            for (int next = start + 1; next <array.length; next++) {
                if (array[next] < array[start]) {
                    lowest = next;
                }
            }

            if (lowest != start) {
                swap(array, start, lowest);
            }
        }
    }

    public static void main(String[] args) {
        int[] data = { 9, 4, 10, 3 };

        System.out.print("Before Bubble Sort: ");
        printArray(data);

        selectionSort(data);

        System.out.print("\nAfter Bubble Sort: ");
        printArray(data);
    }
}
