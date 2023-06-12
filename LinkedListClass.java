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

    public int removeNthNodeFromEnd(int index) {
        int size = 0, data = 0;
        Node node = head;

        // Calculate Size
        while (node != null) {
            size++;
            node = node.next;
        }

        if (index == size) {
            data = head.data;
            head = head.next;
            listSize--;

            return data;
        }

        int indexToFind = size - index;
        node = head;

        for (int i = 1; i < indexToFind; i++) {
            node = node.next;
        }

        data = node.next.data;
        node.next = node.next.next;

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

    private Node findMid(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public boolean checkPalindrome() {
        if (head == null || head.next == null) {
            {
                return true;
            }

        }

        // Step 1 - Find mid
        Node midNode = findMid(head);

        // Step 2 - reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev;
        Node left = head;

        // Step 3 - Check the equality of 1st and reversed 2nd half
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }

            left = left.next;
            right = right.next;
        }

        return true;
    }

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

    public static boolean isCycle() {
        Node slow = head;
        Node fast = head;

        while (fast.next != null || fast == null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast.next != null || fast != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow; // Mid node
    }

    private Node merge(Node leftHalf, Node rightHalf) {
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while (leftHalf != null && rightHalf != null) {
            if (leftHalf.data <= rightHalf.data) {
                temp.next = leftHalf;

                leftHalf = leftHalf.next;
                temp = temp.next;
            } else {
                temp.next = rightHalf;

                rightHalf = rightHalf.next;
                temp = temp.next;
            }
        }

        while (leftHalf != null) {
            temp.next = leftHalf;

            leftHalf = leftHalf.next;
            temp = temp.next;
        }

        while (rightHalf != null) {
            temp.next = rightHalf;

            rightHalf = rightHalf.next;
            temp = temp.next;
        }

        return mergedLL.next;
    }

    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Find mid
        Node mid = getMid(head);

        // merge sort on left and right half
        Node rightHalf = mid.next;
        mid.next = null;
        Node leftHalf = head;

        Node newLeft = mergeSort(leftHalf);
        Node newRight = mergeSort(rightHalf);

        // Merge left and right half
        return merge(newLeft, newRight);
    }

    public static void main(String[] args) {
        // LinkedListClass ll = new LinkedListClass();

        // ll.addfirst(3);
        // ll.addfirst(2);
        // ll.addfirst(1);

        // ll.addLast(4);
        // ll.addLast(5);
        // ll.addLast(7);

        // ll.add(5, 6);

        // ll.addLast(1);
        // ll.addLast(2);
        // ll.addLast(1);

        // ll.printLinkedList();
        // System.out.println(ll.checkPalindrome());

        // System.out.println("Size of linked list: " + ll.size());

        // int index = ll.itrSearch(1);

        // if (index == -1) {
        // System.out.println("Key not found in the link list");
        // } else {
        // System.out.println("Key 1 was found at index: " + index);
        // }

        // Check loop in LL
        // head = new Node(1);
        // head.next = new Node(2);
        // head.next.next = new Node(3);
        // head.next.next.next = head;

        // System.out.println(isCycle());

        LinkedListClass ll = new LinkedListClass();

        ll.addfirst(1);
        ll.addfirst(2);
        ll.addfirst(3);
        ll.addfirst(4);
        ll.addfirst(5);

        ll.printLinkedList();

        head = ll.mergeSort(head);

        ll.printLinkedList();
    }
}