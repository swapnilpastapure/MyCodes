public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;

        while (left < right) {
            int width = right - left;

            // Area is limited by the shorter line
            int currentWater = Math.min(height[left], height[right]) * width;

            maxWater = Math.max(maxWater, currentWater);

            // Move the pointer pointing to the shorter line inward
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }

    // Optional: Main method to test the code locally
    public static void main(String[] args) {
        ContainerWithMostWater solver = new ContainerWithMostWater();
        int[] testHeight = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Max Water: " + solver.maxArea(testHeight)); // Output: 49
    }
}
