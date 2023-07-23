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

class Node {
    private int data;
    private Node next;

    Node() {
        this.data = 0;
        this.next = null;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

class LLQueue {
    private Node head;
    private Node tail;

    LLQueue() {
        this.head = null;
        this.tail = null;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public boolean isEmpty() {
        return this.head == null && this.tail == null;
    }

    public void add(int data) {
        Node newNode = new Node(data);

        if (this.head == null) {
            this.head = this.tail = newNode;
            return;
        }

        this.tail.setNext(newNode);
        this.tail = newNode;
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("Queue is empty...");
            return Integer.MIN_VALUE;
        }

        int frontData = this.head.getData();

        if (this.head == this.tail) {
            this.head = this.tail = null;
        } else {
            this.head.setNext(head.getNext());
        }

        return frontData;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty...");
            return Integer.MIN_VALUE;
        }

        return this.head.getData();
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
