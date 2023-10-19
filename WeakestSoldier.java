import java.util.PriorityQueue;

class Row implements Comparable<Row> {
    public int soldiers;
    public int index;

    public Row(int soldiers, int index) {
        this.soldiers = soldiers;
        this.index = index;
    }

    @Override
    public int compareTo(Row row) {
        if (this.soldiers == row.soldiers) {
            return this.index - row.index;
        } else {
            return this.soldiers - row.soldiers;
        }
    }
}

public class WeakestSoldier {
    public static void main(String[] args) {
        int m = 4, n = 4, k = 2;
        int[][] army = { { 1, 0, 0, 0 }, { 1, 1, 1, 1 }, { 1, 0, 0, 0 }, { 1, 0, 0, 0 } };
        PriorityQueue<Row> pq = new PriorityQueue<Row>();

        for (int i = 0; i < m; i++) {
            int soldierCount = 0;

            for (int j = 0; j < n; j++) {
                soldierCount += army[i][j] == 1 ? 1 : 0;
            }

            pq.add(new Row(soldierCount, i));
        }

        System.out.print("Weakest Soldier: ");
        for (int i = 1; i <= k; i++) {
            System.out.print(pq.remove().index + " ");
        }
    }
}
