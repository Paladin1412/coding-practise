package reversePairs;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-03-02 16:03
 **/
public class Solution {
    public int reversePairs(int[] nums) {
        Integer[] tmp = new Integer[nums.length];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = nums[i];
        }
        long sum = 0;
        sum += doReversePairs(0, nums.length - 1, tmp);
        return (int) sum % 1000000007;
    }

    private long doReversePairs(int start, int end, Integer[] nums) {
        if (start >= end) {
            return 0;
        }
        long sum = 0;
        sum += doReversePairs(start, (end - start) / 2 + start, nums);
        sum += doReversePairs((end - start) / 2 + start + 1, end, nums);

        if (nums[start].compareTo(nums[end]) == 1) {
            int j = (end - start) / 2 + start + 1;
            for (int i = start; i <= (end - start) / 2 + start; i++) {
                if (nums[i].compareTo(nums[end]) != 1) {
                    break;
                }
                for (; j <= end; j++) {
                    if (nums[i].compareTo(nums[j]) == 1) {
                        sum += (end - j + 1)%1000000007;
                        break;
                    }
                }
            }
        }
        Arrays.sort(nums, start, end + 1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0 - o1.compareTo(o2);
            }
        });
        return sum% 1000000007;
    }

    public static void main(String[] args) {
        // 输入以二维数组形式输入 A： X^1 + 2 * X^2 + 3 * X^3  [[1,1],[2,2],[3,3]]

        
    }
}
