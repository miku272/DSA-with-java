import java.util.PriorityQueue;

class PointInfo implements Comparable<PointInfo> {
    int x;
    int y;
    int distanceSquare;

    public PointInfo() {
        this.x = 0;
        this.y = 0;
        this.distanceSquare = 0;
    }

    public PointInfo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public PointInfo(int x, int y, int distanceSquare) {
        this.x = x;
        this.y = y;
        this.distanceSquare = distanceSquare;
    }

    @Override
    public int compareTo(PointInfo pointInfo) {
        return this.distanceSquare - pointInfo.distanceSquare;
    }
}

public class NearbyCars {
    public static void main(String[] args) {
        int[][] coOrdinates = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        int k = 2;
        PriorityQueue<PointInfo> points = new PriorityQueue<PointInfo>();

        for (int[] point : coOrdinates) {
            int distSq = (point[0] * point[0]) + (point[1] + point[1]);

            points.add(new PointInfo(point[0], point[1], distSq));
        }

        System.out.print("Nearest cars: ");
        for (int i = 1; i <= k; i++) {
            PointInfo pt = points.remove();
            System.out.print("(" + pt.x + ", " + pt.y + ") " + " ");
        }
    }
}
