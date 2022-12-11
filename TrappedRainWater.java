public class TrappedRainWater {
    public static int trappedWater(int[] height, int width) {
        // Calculate left-max boundary
        int[] leftMax = new int[height.length];

        leftMax[0] = height[0]; // There is nothing on the left of left most bar

        // Assigning left-max
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        // Calculate right-max boundary
        int[] rightMax = new int[height.length];

        rightMax[height.length - 1] = height[height.length - 1]; // There is nothing on the right of right most bar

        // Assigning the right-max
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        // Calculating trapped rainwater
        int totalTrappedWater = 0;

        for (int i = 0; i < height.length; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);

            totalTrappedWater += (waterLevel - height[i]) * width;
        }

        return totalTrappedWater;
    }

    public static void main(String[] args) {
        int[] height = { 4, 2, 0, 6, 3, 2, 5 };
        int width = 1;

        int totalWater = trappedWater(height, width);

        System.out.println("The total trapped rainwater is " + totalWater);
    }
}
