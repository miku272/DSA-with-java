public class LinkedListClass {
    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private static Node head;
    private static Node tail;
    private static int listSize = 0;

    public void addfirst(int data) {
        Node newNode = new Node(data, head);

        if (head == null) {
            head = tail = newNode;
            listSize++;

            return;
        }

        head = newNode;
        listSize++;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            listSize++;

            return;
        }

        tail.next = newNode;

        tail = newNode;

        listSize++;
    }

    public void add(int index, int data) {
        Node newNode = new Node(data);

        if (index == 0) {
            addfirst(data);
            return;
        }

        Node node = head;
        int i = 0;

        while (i < index - 1) {
            if (node == null) {
                System.out.println("Index out of bounds error: Can't add new node in the linked list");
                return;
            }

            node = node.next;

            i++;
        }

        newNode.next = node.next;
        node.next = newNode;

        listSize++;
    }

    public int removeFirst() {
        int data;

        if (listSize == 0) {
            System.out.println("Linked list is empty");
            return Integer.MIN_VALUE;
        } else if (listSize == 1) {
            data = head.data;
            head = tail = null;

            listSize--;

            return data;
        }

        data = head.data;

        head = head.next;

        listSize--;

        return data;
    }

    public int removeLast() {
        int data;

        if (listSize == 0) {
            System.out.println("Linked list is empty");

            return Integer.MIN_VALUE;
        } else if (listSize == 1) {
            data = tail.data;
            head = tail = null;

            listSize--;

            return data;
        }

        data = tail.data;
        Node node = head;
        
        while (node.next != tail) {
            node = node.next;
        }

        node.next = null;
        tail = node;

        listSize--;

        return data;
    }

    public int itrSearch(int key) {
        Node node = head;
        int index = 0;

        while (node != null) {
            if (node.data == key) {
                return index;
            }

            node = node.next;
            index++;
        }

        return -1;
    }

    // public int recursiveSearch(int key) {

    // }

    public void printLinkedList() {
        Node node = head;
        while (node != null) {
            System.out.print(node.data + " -> ");

            node = node.next;
        }
        System.out.println("Null");
    }

    public int size() {
        return listSize;
    }

    public static void main(String[] args) {
        LinkedListClass ll = new LinkedListClass();

        ll.addfirst(3);
        ll.addfirst(2);
        ll.addfirst(1);

        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(7);

        ll.add(5, 6);

        ll.printLinkedList();

        System.out.println("Size of linked list: " + ll.size());

        int index = ll.itrSearch(1);

        if (index == -1) {
            System.out.println("Key not found in the link list");
        } else {
            System.out.println("Key 1 was found at index: " + index);
        }
    }
}
