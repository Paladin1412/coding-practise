package problems._01_two_sum;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-31 22:04
 **/
public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    public static void main(String[] args) {
        int[] nums = new int[]{7,3,11,15};
        int target = 9;
        int[] res = Solution.twoSum(nums, target);
        System.out.println(Arrays.toString(res));
    }
}
