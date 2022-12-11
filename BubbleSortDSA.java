public class BubbleSortDSA {
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

    static void bubbleSort(int[] array) {
        boolean swapped = false;

        for (int end = array.length - 1; end > 0; end--) {
            for (int current = 0; current < end; current++) {
                if (array[current] > array[current + 1]) {
                    swap(array, current, current + 1);
                    swapped = true;
                }
            }

            if (!swapped) return;
        }
    }

    public static void main(String[] args) {
        int[] data = { 9, 4, 10, 3 };

        System.out.print("Before Bubble Sort: ");
        printArray(data);

        bubbleSort(data);

        System.out.print("\nAfter Bubble Sort: ");
        printArray(data);
    }
}