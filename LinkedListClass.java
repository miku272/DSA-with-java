public class LinkedListClass {
    public static class Node {
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

    public static Node head;
    public static Node tail;

    public void addfirst(int data) {
        Node newNode = new Node(data, head);

        if (head == null) {
            head = tail = newNode;

            return;
        }

        head = newNode;
    }

    public void printLinkedList() {
        Node node = head;
        while (node != null) {
            System.out.print(node.data + " ");

            node = node.next;
        }
    }

    public static void main(String[] args) {
        LinkedListClass ll = new LinkedListClass();

        ll.addfirst(3);
        ll.addfirst(2);
        ll.addfirst(1);

        ll.printLinkedList();
    }
}
