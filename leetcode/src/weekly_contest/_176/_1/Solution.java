package weekly_contest._176._1;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-02-16 10:41
 **/
public class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int sum = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] < 0) {
                    sum += n - j;
                    break;
                }
            }
        }
        return sum;
    }
}
