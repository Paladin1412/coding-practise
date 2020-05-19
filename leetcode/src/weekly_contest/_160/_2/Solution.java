package weekly_contest._160._2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 给你两个整数 n 和 start。你的任务是返回任意 (0,1,2,,...,2^n-1) 的排列 p，并且满足：
 * <p>
 * p[0] = start
 * p[i] 和 p[i+1] 的二进制表示形式只有一位不同
 * p[0] 和 p[2^n -1] 的二进制表示形式也只有一位不同
 * <p>
 * 示例 1：
 * 输入：n = 2, start = 3
 * 输出：[3,2,0,1]
 * 解释：这个排列的二进制表示是 (11,10,00,01)
 * 所有的相邻元素都有一位是不同的，另一个有效的排列是 [3,1,0,2]
 * 示例 2：
 * 输出：n = 3, start = 2
 * 输出：[2,6,7,5,4,0,1,3]
 * 解释：这个排列的二进制表示是 (010,110,111,101,100,000,001,011)
 * <p>
 * 提示：
 * 1 <= n <= 16
 * 0 <= start < 2^n
 * <p>
 * 先看示例，找规律。
 * 示例 1：
 * 输入：n = 2, start = 3
 * 输出：[3,2,0,1]
 * 解释：这个排列的二进制表示是 (11,10,00,01)
 * 从 0开始的二进制排列是 [0,1,3,2] (00,01,11,10)
 * <p>
 * 示例 2：
 * 输出：n = 3, start = 2
 * 输出：[2,6,7,5,4,0,1,3]
 * 从 0开始的二进制排列是
 * [0,1,3,2,6,7,5,4]
 * (000,001,011,010,110,111,101,100)
 * <p>
 * 发现n=3的的从0开始的前四位与n=2的数值相同，后4位为镜像+4（首位为1，<000 : 100>,<001 : 101>）
 * 那么 n=4的时候，前8位与n=3时相同，后8位，为镜像+8。
 * <p>
 * <p>
 * 思路：
 * 1.生成格雷码列表
 * 2.截断列表，从start开始，生成结果
 * <p>
 * 1)什么是格雷码
 * 在一组数的编码中，若任意两个相邻的代码只有一位二进制数不同，则称这种编码为格雷码（Gray Code）,
 * 另外由于最大数与最小数之间也仅一位数不同，即“首尾相连”，因此又称循环码或反射码。
 * <p>
 * 如何求解格雷码
 * 生成格雷码的方法: n+1位格雷码G(n+1)总数 等于 n位格雷码G(n)总数的2倍。只需将n位格雷码G(n)最高位添加0作为G(n+1)的前一半数据(符合格雷码要求)，然后G(n)逆序排,并在最高位加1,作为G(n+1)的后一半数据(也符合格雷码要求),即G(n)每一位加上1<<(n)。
 * 两种方法：递归和循环。
 * 循环方法更优, 计算G(n+1)时不需要多次复制G(n)。
 * @Author: wangyinghao_sx
 * @Date: 2019-10-27 10:47
 **/
public class Solution {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> list = new ArrayList<>();
        if (n == 1) {
            list.add(start);
            list.add(1 - start);
            return list;
        }

        list.add(0);
        list.add(1);
        int index = start == 1 ? 1 : 0;
        for (int i = 2; i <= n; i++) {
            int temp = list.size();
            for (int j = temp - 1; j >= 0; j--) {
                int value = list.get(j) + (1 << (i - 1));
                list.add(value);
                if (value == start) {
                    index = list.size()-1;
                }
            }
        }
        //截断格雷码，重排序
        List<Integer> result = new ArrayList<>();
        result.addAll(list.subList(index, list.size()));
        result.addAll(list.subList(0, index));
        return result;

//        if (n <= 0 || start < 0 || start >= (int) Math.pow(2, n)) {
//            return Collections.emptyList();
//        }
//
//        List<Integer> list = new ArrayList<>();
//        if (n == 1) {
//            list.add(start);
//            list.add(1 - start);
//            return list;
//        }
//        //生成格雷码
//        list.add(0);
//        list.add(1);
//        int index = start == 1 ? 1 : 0;
//        for (int i = 2; i <= n; i++) {
//            int temp = list.size();
//            for (int j = temp - 1; j >= 0; j--) {
//                int value = list.get(j) + (1 << (i - 1));
//                list.add(value);
//                if (value == start) {
//                    index = list.size() - 1;
//                }
//            }
//        }
//        //截断格雷码，重排序
//        List<Integer> result = new ArrayList<>();
//        result.addAll(list.subList(index, list.size()));
//        result.addAll(list.subList(0, index));
//        return result;
    }
}
