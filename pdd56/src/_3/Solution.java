package _3;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-06 15:07
 **/
public class Solution {
    public static int fib(int a, int b, int n) {
        if (n == 0)
            return a;
        else if (n == 1)
            return b;
        else
            return fib(a, b, n - 1) + fib(a, b, n - 2);
    }

    public static void main(String[] args) {
        int a = 7;
        int b = 11;
        int n = 2;
        int first = -1;
        int second = -1;
        for (int i = 0; i <= n; i++) {
            if (i != n && fib(a, b, i) % 3 == 0) {
                if (first == -1) {
                    first = i;
                } else if (first != -1 && second == -1) {
                    second = i;
                }
                if (first != -1 && second != -1) {
                    if ((n - first) % (second - first) == 0) {
                        System.out.println("YES");
                        return;
                    } else {
                        System.out.println("NO");
                        return;
                    }
                }
            }
            if (i == n && fib(a, b, i) % 3 == 0) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}
