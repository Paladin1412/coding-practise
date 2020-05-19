package weekly_contest._160._3;

import java.util.List;

/**
 * @Description: 给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，如果 s 中的每一个字符都只出现过一次，那么它就是一个可行解。
 * <p>
 * 请返回所有可行解 s 中最长长度。
 * <p>
 * 示例 1：
 * 输入：arr = ["un","iq","ue"]
 * 输出：4
 * 解释：所有可能的串联组合是 "","un","iq","ue","uniq" 和 "ique"，最大长度为 4。
 * 示例 2：
 * 输入：arr = ["cha","r","act","ers"]
 * 输出：6
 * 解释：可能的解答有 "chaers" 和 "acters"。
 * 示例 3：
 * <p>
 * 输入：arr = ["abcdefghijklmnopqrstuvwxyz"]
 * 输出：26
 * <p>
 * 提示：
 * 1 <= arr.length <= 16
 * 1 <= arr[i].length <= 26
 * arr[i] 中只含有小写英文字母
 * @Author: wangyinghao_sx
 * @Date: 2019-10-27 11:02
 **/
public class Solution {
    public int maxLength(List<String> arr) {
        int arrLen = arr.size();
        int[][] twoArr = new int[arrLen][arrLen];
        for (int i = 0; i < arrLen; i++) {
            twoArr[i][i] = arr.get(i).length();
            for (int j = i + 1; j < arrLen; j++) {
                String si = arr.get(i);
                String sj = arr.get(j);
                for (int k = 0; k < si.length(); k++) {
                    if (sj.contains(si.substring(k))) {
                        twoArr[i][j] = 0;
                        break;
                    }
                }
                twoArr[i][j] = si.length() + sj.length();
            }
        }
        return 1;
    }
}
