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
}

public class MyHeapPractice {
    public static void main(String[] args) {
        MyHeap heap = new MyHeap();

        heap.insert(3);
        heap.insert(4);
        heap.insert(1);
        heap.insert(5);

        while (!heap.isEmpty()) {
            System.out.print(heap.peek() + " ");
            heap.delete();
        }
    }
}
