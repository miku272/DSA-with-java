class ArrayQueue {
    int[] arr;
    int rear;

    ArrayQueue() {
        this.arr = new int[10];
        this.rear = -1;
    }

    ArrayQueue(int size) {
        this.arr = new int[size];
        this.rear = -1;
    }

    public boolean isEmpty() {
        return this.rear == -1;
    }

    public void enqueue(int data) {
        if (rear == this.arr.length - 1) {
            System.out.println("Queue is full");
            return;
        }

        this.rear++;

        this.arr[this.rear] = data;
    }

    public int dequeue() {
        if (this.isEmpty()) {
            System.out.println("Queue is empty...");
            return Integer.MIN_VALUE;
        }

        int front = this.arr[0];

        for (int i = 0; i < this.rear; i++) {
            this.arr[i] = this.arr[i + 1];
        }

        rear--;

        return front;
    }

    public int peek() {
        if (this.isEmpty()) {
            System.out.println("Queue is empty...");
            return Integer.MIN_VALUE;
        }

        return this.arr[0];
    }
}

public class MyQueue {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
