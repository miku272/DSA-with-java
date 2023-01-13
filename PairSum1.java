import java.util.ArrayList;

public class PairSum1 {
    public static boolean pairSumBrute(ArrayList<Integer> list, int target) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) + list.get(j) == target) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean pairSumTwoPointer(ArrayList<Integer> list, int target) {
        int leftPointer = 0, rightPointer = list.size() - 1;

        while (leftPointer < rightPointer) {
            if (list.get(leftPointer) + list.get(rightPointer) == target) {
                return true;
            } else if (list.get(leftPointer) + list.get(rightPointer) < target) {
                leftPointer++;
            } else if (list.get(leftPointer) + list.get(rightPointer) < target) {
                rightPointer--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int target = 5;
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        System.out.println(pairSumBrute(list, target));
    }
}
