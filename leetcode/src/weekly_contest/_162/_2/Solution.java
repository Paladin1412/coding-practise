package weekly_contest._162._2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 给你一个 2 行 n 列的二进制数组：
 * 矩阵是一个二进制矩阵，这意味着矩阵中的每个元素不是 0 就是 1。
 * 第 0 行的元素之和为 upper。
 * 第 1 行的元素之和为 lower。
 * 第 i 列（从 0 开始编号）的元素之和为 colsum[i]，colsum 是一个长度为 n 的整数数组。
 * 你需要利用 upper，lower 和 colsum 来重构这个矩阵，并以二维整数数组的形式返回它。
 * <p>
 * 如果有多个不同的答案，那么任意一个都可以通过本题。
 * <p>
 * 如果不存在符合要求的答案，就请返回一个空的二维数组。
 * @Author: wangyinghao_sx
 * @Date: 2019-11-10 10:50
 **/
public class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int col = colsum.length;
        List<List<Integer>> res = new ArrayList<>();

        return null;
    }
}
