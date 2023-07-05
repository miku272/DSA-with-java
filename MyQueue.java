class ArrayQueue {
    int[] arr;
    int size;
    int rear;

    ArrayQueue() {
        this.arr = new int[10];
        this.size = 10;
        this.rear = -1;
    }

    ArrayQueue(int size) {
        this.arr = new int[size];
        this.size = size;
        this.rear = -1;
    }

    public boolean isEmpty() {
        return this.rear == -1;
    }

    public void enqueue(int data) {
        
    }

    public int dequeue() {
        return 0;
    }

    public int peek() {
        return 0;
    }
}

public class MyQueue {
    public static void main(String[] args) {

    }
}
