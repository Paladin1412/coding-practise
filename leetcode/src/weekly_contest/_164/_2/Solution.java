package weekly_contest._164._2;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2019-11-24 10:47
 **/
public class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] >= 2 && col[j] >= 2) {
                    continue;
                }
                if (grid[i][j] == 1) {
                    row[i] += 1;
                    col[j] += 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==1){
                    if (row[i] >= 2 || col[j] >= 2) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,0},{0,1}};
        System.out.println(new Solution().countServers(grid));
    }
}
