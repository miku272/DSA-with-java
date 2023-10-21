/*
 Find the maximum of all subarrays of size k
 */

import java.util.PriorityQueue;

class Pair implements Comparable<Pair> {
    public int num, index;

    public Pair(int num, int index) {
        this.num = num;
        this.index = index;
    }

    @Override
    public int compareTo(Pair p) {
        // return this.num - p.num; // For ascending
        return p.num - this.num; // For descending
    }
}

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        // int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[] arr = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3; // Window Size

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        int[] res = new int[arr.length - k + 1];

        // First Window
        for (int i = 0; i < k; i++) {
            pq.add(new Pair(arr[i], i));
        }

        res[0] = pq.peek().num;

        for (int i = k; i < arr.length; i++) {
            while (pq.size() > 0 && pq.peek().index <= (i - k)) {
                pq.remove();
            }

            pq.add(new Pair(arr[i], i));
            res[i - k + 1] = pq.peek().num;
        }

        // Print result
        for (int result : res) {
            System.out.print(result + " ");
        }
    }
}
