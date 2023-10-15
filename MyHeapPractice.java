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

    public void insert(int data) {
        // Add at last index
        this.minHeap.add(data);

        int childIndex = this.minHeap.size() - 1; // Child index

        int parentIndex = (childIndex - 1) / 2; // Parent index

        while ((this.minHeap.get(childIndex) < this.minHeap.get(parentIndex)) /*&& (parentIndex >= 0)*/) {
            this.swap(childIndex, parentIndex);

            // childIndex = parentIndex;

            // parentIndex = (childIndex - 1) / 2;
        }
    }

    public int peek() {
        return this.minHeap.get(0);
    }
}

public class MyHeapPractice {
    public static void main(String[] args) {

    }
}
