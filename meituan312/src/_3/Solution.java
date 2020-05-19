package _3;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-03-12 19:46
 **/
public class Solution {
    public int getNum(int n, int k, int L, int R) {
        return doGetNum(0, n, k, L, R, 0);
    }

    public int doGetNum(int index, int n, int k, int L, int R, int sum) {
        long res = 0;
        if (index == n) {
            if (sum % k == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        for (int i = L; i <= R; i++) {
            res += doGetNum(index + 1, n, k, L, R, sum + i);
            res %= 1000000007;
        }
        return (int) (res % 1000000007);
    }

    public static void main(String[] args) {
        int n = 9;
        int k = 1;
        int L = 1;
        int R = 3;
        System.out.println(new Solution().getNum(n, k, L, R));
    }
}
