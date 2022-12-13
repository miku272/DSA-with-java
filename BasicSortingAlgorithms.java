public class BasicSortingAlgorithms {
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void swap(int[] array, int indexA, int indexB) {
        int temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
    }

    public static void merge(int[] array, int sI, int mid, int eI) {
        int[] temp = new int[eI - sI + 1];
        int i = sI; // Iterator for left part
        int j = mid + 1; // Iterator for right part
        int k = 0; // Iterator for temp array

        while (i <= mid && j <= eI) {
            if (array[i] < array[j]) {
                temp[k] = array[i];
                i++;
            } else {
                temp[k] = array[j];
                j++;
            }
            k++;
        }

        // If left array has some leftover elements
        while (i <= mid) {
            temp[k++] = array[i++];
        }

        // If right array has some leftover elements
        while (j <= eI) {
            temp[k++] = array[j++];
        }

        // Copy temp array in original array
        for (k = 0, i = sI; k < temp.length; k++, i++) {
            array[i] = temp[k];
        }
    }

    public static int partition(int[] array, int sI, int eI) {
        // We will take last element as our pivot
        int pivot = array[eI];
        int i = sI - 1; // To make room for element smaller than the pivot

        for (int j = sI; j < eI; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, j, i);
            }
        }

        i++;
        swap(array, eI, i);

        return i;
    }

    public static void bubbleSort(int[] array) {
        boolean isSwapped;

        for (int turn = 0; turn < array.length - 1; turn++) {
            isSwapped = false;

            for (int j = 0; j < array.length - 1 - turn; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);

                    isSwapped = true;
                }
            }

            if (!isSwapped) {
                break;
            }
        }
    }

    public static void selectionSort(int[] array) {
        int minPosition;

        for (int turn = 0; turn < array.length - 1; turn++) {
            minPosition = turn;

            for (int j = turn + 1; j < array.length; j++) {
                if (array[minPosition] > array[j]) {
                    minPosition = j;
                }
            }

            swap(array, minPosition, turn);
        }
    }

    public static void insertionSort(int[] array) {
        int current, previous;

        for (int i = 1; i < array.length; i++) {
            current = array[i];
            previous = i - 1;

            while (previous >= 0 && array[previous] > current) {
                array[previous + 1] = array[previous];
                previous--;
            }

            array[previous + 1] = current;
        }
    }

    public static void countSort(int[] array) {
        int largest = Integer.MIN_VALUE, j = 0;

        for (int i = 0; i < array.length; i++) {
            largest = Math.max(largest, array[i]);
        }

        int[] count = new int[largest + 1];

        for (int i = 0; i < array.length; i++) {
            count[array[i]]++;
        }

        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                array[j] = i;
                j++;
                count[i]--;
            }
        }
    }

    public static void mergeSort(int[] array, int sI, int eI) {
        if (sI >= eI) {
            return;
        }

        int mid = sI + (eI - sI) / 2; // (sI + eI) / 2

        mergeSort(array, sI, mid); // Left Part
        mergeSort(array, mid + 1, eI); // Right Part

        merge(array, sI, mid, eI);
    }

    public static void quickSort(int[] array, int sI, int eI) {
        if (sI >= eI) {
            return;
        }

        // We will take last element as our pivot
        int pivotIndex = partition(array, sI, eI);

        quickSort(array, sI, pivotIndex - 1); // Left Part
        quickSort(array, pivotIndex + 1, eI); // Right Part
    }

    public static void main(String[] args) {
        int[] array = { 5, 4, 1, 3, 2 };
        // int[] array = { 1, 2, 3, 4, 5 };

        printArray(array);
        System.out.print("\n");

        // bubbleSort(array);
        // selectionSort(array);
        // insertionSort(array);
        // Arrays.sort(array);
        // countSort(array);
        // mergeSort(array, 0, array.length - 1);
        quickSort(array, 0, array.length - 1);

        printArray(array);
    }
}
