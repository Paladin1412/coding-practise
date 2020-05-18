package array;

import java.util.Arrays;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-16 11:57
 **/
public class ArrayDemo1 {
    public static void main(String[] args) {
        int[] a = {45445,58,4548412,1548,135848};
        System.out.println(a);
        System.out.println(Arrays.toString(a));
        System.out.println(printArray(a));
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        Arrays.fill(a,0);
        System.out.println(Arrays.toString(a));
    }

    public static String printArray(int[] a){
        if (a == null)
            return "null";
        int iMax = a.length - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
    }
}
