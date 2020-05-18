package _1._10;

import java.util.LinkedList;

/**
 * @Description: 最大值减去最小值小于或等于num的子数组数量
 * @Author: wangyinghao_sx
 * @Date: 2020-05-16 19:29
 **/
public class Solution {
    public static int getNum(int[] arr, int num) {
        if (arr == null || arr.length == 0 || num < 0) {
            return 0;
        }
        LinkedList<Integer> qmin = new LinkedList<>();
        LinkedList<Integer> qmax = new LinkedList<>();

        int i = 0;
        int j = 0;
        int res = 0;
        while (i < arr.length) {
            while (j < arr.length) {
                if (qmin.isEmpty() || qmin.peekLast() != j) {
                    while (!qmin.isEmpty() && qmin.peekLast() >= arr[j]) {
                        qmin.pollLast();
                    }
                    qmin.addLast(j);
                    while (!qmax.isEmpty() && qmax.peekLast() <= arr[j]) {
                        qmax.pollLast();
                    }
                    qmax.addLast(j);
                }
                if (arr[qmax.getFirst()] - arr[qmin.getFirst()] > num) {
                    break;
                }
                j++;
            }
            res += j - i;
            if (qmin.peekFirst() == i) {
                qmin.pollFirst();
            }
            if (qmax.peekFirst() == i) {
                qmax.pollFirst();
            }
            j++;
        }
        return res;
    }
}
