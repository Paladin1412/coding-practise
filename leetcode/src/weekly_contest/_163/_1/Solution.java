package weekly_contest._163._1;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2019-11-17 10:36
 **/
public class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        if (k % (m * n) == 0) {
            return arrToList(grid, n, m);
        }
        k = k % (m * n);
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int r = i + k / m;
                int c = j + k % m;
                if (c >= m) {
                    r += 1;
                    c -= m;
                }
                if (r >= n) {
                    r = r % n;
                }
                arr[r][c] = grid[i][j];
            }
        }
        return arrToList(arr, n, m);
    }

    private List<List<Integer>> arrToList(int[][] arr, int n, int m) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List tmp = new ArrayList();
            for (int j = 0; j < m; j++) {
                tmp.add(arr[i][j]);
            }
            res.add(tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{3, 8, 1, 9}, {19, 7, 2, 5}, {4, 6, 11, 10}, {12, 0, 21, 13}};
        System.out.println(new Solution().shiftGrid(grid, 4));
    }
}
