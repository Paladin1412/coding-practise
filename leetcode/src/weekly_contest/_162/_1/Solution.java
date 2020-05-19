package weekly_contest._162._1;

/**
 * @Description: 给你一个 n 行 m 列的矩阵，最开始的时候，每个单元格中的值都是 0。
 * 另有一个索引数组 indices，indices[i] = [ri, ci] 中的 ri 和 ci 分别表示指定的行和列（从 0 开始编号）。
 * 你需要将每对 [ri, ci] 指定的行和列上的所有单元格的值加 1。
 * 请你在执行完所有 indices 指定的增量操作后，返回矩阵中 「奇数值单元格」 的数目。
 * @Author: wangyinghao_sx
 * @Date: 2019-11-10 10:33
 **/
public class Solution {
    public int oddCells(int n, int m, int[][] indices) {
        int[][] arr = new int[n][m];
        for (int[] index : indices) {
            for (int c = 0; c < m; c++) {
                arr[index[0]][c]++;
            }
            for (int r = 0; r < n; r++) {
                arr[r][index[1]]++;
            }
        }
        int num = 0;
        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt % 2 == 1) {
                    num++;
                }
            }
        }
        return num;
    }
}
