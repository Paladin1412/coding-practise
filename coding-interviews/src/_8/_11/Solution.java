package _8._11;

import java.util.HashMap;

/**
 * @Description: 未排序的数组中累加和为给定值的最长子数组
 * @Author: wangyinghao_sx
 * @Date: 2020-05-25 19:55
 **/
public class Solution {
    public int maxLength(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int len = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - k)) {
                len = Math.max(i - map.get(sum - k), len);
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return len;
    }
}
