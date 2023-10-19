import java.util.PriorityQueue;

public class ConnectNRopes {
    public static void main(String[] args) {
        int[] ropeLengths = { 4, 3, 3, 2, 6 };
        PriorityQueue<Integer> lengthPriority = new PriorityQueue<Integer>();
        int cost = 0;

        for (int ropeLength : ropeLengths) {
            lengthPriority.add(ropeLength);
        }

        while (lengthPriority.size() > 1) {
            int min1 = lengthPriority.remove();
            int min2 = lengthPriority.remove();

            cost += min1 + min2;

            lengthPriority.add(min1 + min2);
        }

        System.out.println("Minimum cost: " + cost);
    }
}
