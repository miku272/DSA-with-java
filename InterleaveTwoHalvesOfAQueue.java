import java.util.LinkedList;
import java.util.Queue;

public class InterleaveTwoHalvesOfAQueue {
    public static void interleaveTwoHalvesOfAQueue(Queue<Integer> q) {
        Queue<Integer> q2 = new LinkedList<Integer>();
        int size = q.size() / 2;

        for (int i = size; i >= 1; i--) {
            q2.add(q.remove());
        }

        while (!q2.isEmpty()) {
            q.add(q2.remove());

            q.add(q.remove());
        }

        while (!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }
    }

    
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<Integer>();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);

        interleaveTwoHalvesOfAQueue(q);
    }
}
