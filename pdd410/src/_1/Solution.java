package _1;

import java.util.Arrays;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-04-10 19:10
 **/


// 改成C++的时候 N是输入的第一行整数 数组A是输入的第二行数组
public class Solution {
    public long getMinSum(int N, int[] A) {
        long sum = 0;
        // 将A从小到大排序
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 0; i = i - 3) {
            sum += A[i];
            if (i - 1 >= 0) {
                sum += A[i - 1];
            }
        }
        return sum;
    }
}
