public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        // Ensure nums1 is the smaller array for binary search
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0;
        int high = m;

        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (m + n + 1) / 2 - partitionX;

            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];

            // Correct partition found
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {

                // If total length is even
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeftX, maxLeftY)
                            + Math.min(minRightX, minRightY)) / 2.0;
                }

                // If total length is odd
                return Math.max(maxLeftX, maxLeftY);
            }

            // Move towards left in nums1
            if (maxLeftX > minRightY) {
                high = partitionX - 1;
            }
            // Move towards right in nums1
            else {
                low = partitionX + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted.");
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays solution = new MedianOfTwoSortedArrays();

        int[] nums1 = {1, 3};
        int[] nums2 = {2};

        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
        // Output: 2.0

        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};

        System.out.println(solution.findMedianSortedArrays(nums3, nums4));
        // Output: 2.5
    }
}
