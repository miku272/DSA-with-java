import java.util.ArrayList;;

public class ContainerWithMostWater {
    public static int maxWater(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        int width;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                width = Math.abs(j - i);

                maxArea = Math.max(maxArea, width * Math.min(height[i], height[j]));
            }
        }

        return maxArea;
    }

    public static int maxWaterTwoPointer(ArrayList<Integer> height) {
        int maxArea = Integer.MIN_VALUE;
        int leftPointer = 0, rightPointer = height.size() - 1;
        int currentHeight, width, currentWater;

        while (leftPointer < rightPointer) {
            currentHeight = Math.min(height.get(leftPointer), height.get(rightPointer));

            width = rightPointer - leftPointer;

            currentWater = currentHeight * width;

            maxArea = Math.max(maxArea, currentWater);

            if (height.get(leftPointer) < height.get(rightPointer)) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        // int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        System.out.println(maxWaterTwoPointer(height));
    }
}
