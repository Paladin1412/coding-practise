package _1._7;

import java.util.LinkedList;

/**
 * @Description: 生成窗口最大值数组
 * @Author: wangyinghao_sx
 * @Date: 2020-05-12 21:45
 **/
public class MaxWindow {
    public static int[] getMaxWindow1(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i - w) {
                qmax.pollFirst();
            }
            if (i >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }

    public static int[] getMaxWindow2(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (i >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
            if (qmax.peekFirst() == i + 1 - w) {
                qmax.pollFirst();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,3,5,4,3,3,6,7};
        int[] maxWindow1 = getMaxWindow1(arr, 3);
        int[] maxWindow2 = getMaxWindow2(arr, 3);
    }
}
