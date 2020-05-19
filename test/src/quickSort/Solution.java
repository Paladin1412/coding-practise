package quickSort;

import java.util.Arrays;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-02-27 15:07
 **/
public class Solution {
    public void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int part = partation(arr, start, end);
            quickSort(arr, start, part - 1);
            quickSort(arr, part + 1, end);
        }
    }

    private int partation(int[] arr, int start, int end) {
        int label = arr[end];
        while (start < end) {
            while (start < end && arr[start] < label) {
                start++;
            }
//            if (arr[start] >= label) {
            if (start < end) {
                arr[end] = arr[start];
                end--;
            }
            while (start < end && arr[end] >= label) {
                end--;
            }
//            if (arr[end] < label) {
            if (start < end) {
                arr[start] = arr[end];
                start++;
            }
        }
        arr[start] = label;
        return start;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{49, 38, 65, 97, 76, 13, 27, 49};
        new Solution().quickSort(arr, 0, 7);
        System.out.println(Arrays.toString(arr));
    }
}
