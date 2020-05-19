package weekly_contest._165._3;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2019-12-01 11:16
 **/
public class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = Math.min(m, n);
        int[] res = new int[max];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < max; k++) {
                    boolean flag = true;
                    if (i - k < 0 || j - k < 0) {
                        flag = false;
                        break;
                    }
                    for (int row = i - k; row <= i; row++) {
                        if (flag == true) {
                            for (int col = j - k; col <= j; col++) {
                                if (matrix[row][col] == 0) {
                                    flag = false;
                                    break;
                                }
                            }
                        } else {
                            break;
                        }
                    }
                    if (flag == true) {
                        System.out.println("i:" + i + " j:" + j + " k:" + k);
                        res[k]++;
                    }
                }
            }
        }
        int count = 0;
        for (int re : res) {
            count += re;
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 1}, {1, 1, 0}, {1, 1, 0}};
        new Solution().countSquares(matrix);
    }
}
