import java.util.ArrayList;

class ArrayListStack {
    private ArrayList<Integer> list = new ArrayList<>();

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public void push(int data) {
        list.add(data);
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Empty...");
            return Integer.MIN_VALUE;
        }

        int topData = list.get(list.size() - 1);
        list.remove(list.size() - 1);

        return topData;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack Empty...");
            return Integer.MIN_VALUE;
        }

        return list.get(list.size() - 1);
    }
}

class Node {
    private int data;
    private Node next;

    Node() {
        this.next = null;
    };

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    Node(int data, Node node) {
        this.data = data;
        this.next = node;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }
}

class LinkedListStack {
    private Node head = null;

    public int getHead() {
        return head.getData();
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void push(int data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            head = newNode;
            return;
        }

        newNode.setNext(head);

        head = newNode;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack empty. Nothing to pop...");
            return Integer.MIN_VALUE;
        }

        int deletedData = head.getData();

        head = head.getNext();

        return deletedData;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack empty. Nothing to pop...");
            return Integer.MIN_VALUE;
        }

        return head.getData();
    }

    public void printList() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.getData() + " -> ");
            temp = temp.getNext();
        }

        System.out.print("null");
    }
}

public class MyStack {
    public static void main(String[] args) {
        // ArrayListStack stack = new ArrayListStack();

        // stack.push(0);
        // stack.push(1);
        // stack.push(2);
        // stack.push(3);

        // System.out.println(stack.pop());
        // System.out.println(stack.pop());

        LinkedListStack stack = new LinkedListStack();

        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);

        stack.pop();
        stack.pop();

        stack.printList();
    }
}
