package weekly_contest._180._1;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-03-15 10:38
 **/
public class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int[] rowMin = new int[matrix.length];
        int[] colMax = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            int min = 100001;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                }
            }
            rowMin[i] = min;
            min = 100001;
        }
        for (int j = 0; j < matrix[0].length; j++) {
            int max = 0;
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
            colMax[j] = max;
            max = 0;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == rowMin[i] && matrix[i][j] == colMax[j]) {
                    res.add(matrix[i][j]);
                }
            }
        }
        return res;
    }
}
