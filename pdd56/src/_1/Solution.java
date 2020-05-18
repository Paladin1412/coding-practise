package _1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-06 14:03
 **/
public class Solution {
    public int lessBall(int n, int[] arr) {
        int sum = 0;
        Map<Integer, Integer> ballNumMap = new HashMap<>(n);
        Map<Integer, Integer> ballNumMapCopy = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            if (!ballNumMap.containsKey(arr[i])) {
                ballNumMap.put(arr[i], 1);
            } else {
                ballNumMap.replace(arr[i], ballNumMap.get(arr[i]) + 1);
            }
        }
        Iterator iterator = ballNumMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            Integer key = (Integer) entry.getKey();
            Integer value = (Integer) entry.getValue();
            ballNumMapCopy.put(key, value);
        }
        iterator = ballNumMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            Integer key = (Integer) entry.getKey();
            Integer value = (Integer) entry.getValue();
            int i = key;
            while (value > 1) {
                for (i = i + 1; i < 1_000_000_001 + n; i++) {
                    if (!ballNumMapCopy.containsKey(i)) {
                        sum += (i - key);
                        ballNumMapCopy.put(i, 1);
                        break;
                    }
                }
                value--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] arr = new int[]{1_000_000_000, 1_000_000_000, 1_000_000_000, 1_000_000_000, 1_000_000_000};
        System.out.println(new Solution().lessBall(n, arr));
    }
}
