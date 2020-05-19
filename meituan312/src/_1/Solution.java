package _1;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-03-12 19:06
 **/
public class Solution {
    // n  是第一行输入
    // 二三行输入转存到arr中
    public int path(int n, char[][] arr) {
        int sum = 0;
        sum += doPath(0, 0, n, arr);
        return sum == 0 ? -1 : sum;
    }


    public int doPath(int x, int y, int n, char[][] arr) {
        if (x > 1 || x < 0 || y > n - 1 || arr[x][y] == 'X') {
            return 0;
        }
        if (x == 1 && y == n - 1) {
            return 1;
        }
        int sum = 0;
        sum += doPath(x, y + 1, n, arr);
        sum += doPath(x - 1, y + 1, n, arr);
        sum += doPath(x + 1, y + 1, n, arr);
        return sum;
    }

    public static void main(String[] args) {
        int n = 5;
        char[][] arr = new char[][]{{'.', '.', 'X', '.', 'X'}, {'X', 'X', '.', '.', '.'}};
        System.out.println(new Solution().path(n, arr));
    }
}
