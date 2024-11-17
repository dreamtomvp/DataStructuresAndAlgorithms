import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        /*
         * Question: Given an array of integers, nums, and an integer target, return the indices of the two numbers that
         * add up to the target. You may assume that each input would have exactly one solution, and you may not use the
         * same element twice.
         *
         * You can return the answer in any order.
         *
         * e.g. Input: nums = [2,7,11,15], target = 9, Output: [0,1]
         *      Input: nums = [3,2,4], target = 6, Output: [1,2]
         */

        // Solution 1: Brute force approach
        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(solution1(nums, 9)));

        // Solution 2: One pass hash map
        System.out.println(Arrays.toString(solution2(nums, 9)));
    }

    // Solution 1: Brute force approach
    // Time complexity: O(n * n)
    // Space complexity: O(1)
    private static int[] solution1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    // Solution 2: One pass hash table
    // Time complexity: O(n)
    // Space complexity: O(n)
    private static int[] solution2(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[]{i, numMap.get(complement)};
            } else {
                numMap.put(nums[i], i);
            }
        }
        return null;
    }

}