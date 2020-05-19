package _2;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-03-12 19:19
 **/
public class Solution {
    public int max(int x, int[] arr) {
        return doMax(0, x, arr);
    }

    public int doMax(int index, int x, int[] arr) {
        if (index == arr.length) {
            return getMax(arr);
        }
        int[] arrTmp = arr;
        arrTmp[index] = arr[index] | x;
        return Math.max(doMax(index + 1, x, arr), doMax(index + 1, x, arrTmp));
    }

    public int getMax(int[] arr) {
        int[] tmp = new int[1000];
        // 就是for循环
        for (int i : arr) {
            tmp[i - 1]++;
        }
        int res = 0;
        for (int i : tmp) {
            res = i > res ? i : res;
        }
        return res;
    }

    public static void main(String[] args) {
        int x = 2;
        int[] arr = new int[]{3, 1, 3, 2, 5};
        System.out.println(new Solution().max(x, arr));
    }
}
