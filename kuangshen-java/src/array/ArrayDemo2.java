package array;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-16 12:19
 **/
public class ArrayDemo2 {
    public static void main(String[] args) {
        int[] a = {454545,548,14848,168,55};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static int[] sort(int[] array) {
        int tmp = 0;
        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j + 1] > array[j]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    flag = true;
                }
            }
            if(!flag){
                break;
            }
        }
        return array;
    }
}
