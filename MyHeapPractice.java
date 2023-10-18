import java.util.ArrayList;

class MyHeap {
    private ArrayList<Integer> minHeap;

    public MyHeap() {
        this.minHeap = new ArrayList<Integer>();
    }

    private void swap(int indexA, int indexB) {
        int temp = this.minHeap.get(indexA);

        this.minHeap.set(indexA, this.minHeap.get(indexB));

        this.minHeap.set(indexB, temp);
    }

    private void swap(int[] arr, int indexA, int indexB) {
        int temp = arr[indexA];

        arr[indexA] = arr[indexB];

        arr[indexB] = temp;
    }

    private void heapify(int index) {
        int left = (2 * index) + 1;
        int right = (2 * index) + 2;
        int minIndex = index;

        if (left == this.minHeap.size() - 1 && this.minHeap.get(minIndex) > this.minHeap.get(left)) {
            minIndex = left;
        }

        if (right == this.minHeap.size() - 1 && this.minHeap.get(minIndex) > this.minHeap.get(right)) {
            minIndex = right;
        }

        if (minIndex != index) {
            this.swap(index, minIndex);

            heapify(minIndex);
        }
    }

    private void heapify(int[] arr, int index, int size) {
        int left = (2 * index) + 1;
        int right = (2 * index) + 2;
        int maxIndex = index;

        if (left < size && arr[left] > arr[maxIndex]) {
            maxIndex = left;
        }

        if (right < size && arr[right] > arr[maxIndex]) {
            maxIndex = right;
        }

        if (maxIndex != index) {
            swap(arr, index, maxIndex);

            heapify(arr, maxIndex, size);
        }
    }

    public void insert(int data) {
        // Add at last index
        this.minHeap.add(data);

        int childIndex = this.minHeap.size() - 1; // Child index

        int parentIndex = (childIndex - 1) / 2; // Parent index

        while ((this.minHeap.get(childIndex) < this.minHeap.get(parentIndex)) && (parentIndex >= 0)) {
            this.swap(childIndex, parentIndex);

            childIndex = parentIndex;

            parentIndex = (childIndex - 1) / 2;
        }
    }

    public int peek() {
        return this.minHeap.get(0);
    }

    public int delete() {
        int data = this.minHeap.get(0);

        // Swap first and last
        swap(0, this.minHeap.size() - 1);

        // Delete last
        this.minHeap.remove(this.minHeap.size() - 1);

        // Heapify
        heapify(0);

        return data;
    }

    public boolean isEmpty() {
        return this.minHeap.isEmpty();
    }

    public void heapSort(int[] arr) { // Max heap for ascending Order. Min heap for descending order
        // Build max heap
        for (int i = arr.length / 2; i >= 0; i--) {
            this.heapify(arr, i, arr.length);
        }

        // Push largest element to end
        for (int i = arr.length - 1; i > 0; i--) {
            // Swap largest (first index) with last index
            swap(arr, 0, i);

            heapify(arr, 0, i);
        }
    }
}

public class MyHeapPractice {
    public static void main(String[] args) {
        MyHeap heap = new MyHeap();

        // heap.insert(3);
        // heap.insert(4);
        // heap.insert(1);
        // heap.insert(5);

        // while (!heap.isEmpty()) {
        // System.out.print(heap.peek() + " ");
        // heap.delete();
        // }

        int[] arr = { 1, 2, 4, 5, 3 };

        System.out.print("Before Sorting: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.print("\n");

        heap.heapSort(arr);

        System.out.print("After Sorting: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
