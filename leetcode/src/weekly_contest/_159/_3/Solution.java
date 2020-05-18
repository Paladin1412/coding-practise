package weekly_contest._159._3;

import org.junit.Test;

/**
 * @Description: 有一个只含有 'Q', 'W', 'E', 'R' 四种字符，且长度为 n 的字符串。
 * <p>
 * 假如在该字符串中，这四个字符都恰好出现 n/4 次，那么它就是一个「平衡字符串」。
 * <p>
 * 给你一个这样的字符串 s，请通过「替换子串」的方式，使原字符串 s 变成一个「平衡字符串」。
 * <p>
 * 你可以用和「待替换子串」长度相同的 任何 其他字符串来完成替换。
 * <p>
 * 请返回待替换子串的最小可能长度。
 * <p>
 * 如果原字符串自身就是一个平衡字符串，则返回 0。
 * <p>
 * 示例 1：
 * 输入：s = "QWER"
 * 输出：0
 * 解释：s 已经是平衡的了。
 * <p>
 * 示例 2：
 * 输入：s = "QQWE"
 * 输出：1
 * 解释：我们需要把一个 'Q' 替换成 'R'，这样得到的 "RQWE" (或 "QRWE") 是平衡的。
 * <p>
 * 示例 3：
 * 输入：s = "QQQW"
 * 输出：2
 * 解释：我们可以把前面的 "QQ" 替换成 "ER"。
 * <p>
 * 示例 4：
 * 输入：s = "QQQQ"
 * 输出：3
 * 解释：我们可以替换后 3 个 'Q'，使 s = "QWER"。
 * <p>
 * 思路：
 * 统计字符个数
 * 只考虑大于n / 4的字符，目标找到最短的子串将这些多的字符替换掉。
 * 窗口中s[l,r]就是子串candidate:
 * 1）如果子串里包含了足够多要替换的字符，则l += 1， 缩小考察范围；
 * 2）如果子串里需要换掉的字符不够，则r += 1，考察更多的字符；
 * 举个栗子：
 * ‘WQWRQQQW’
 * 统计字典为counter = {W:3,Q:4,R:1}
 * 只考虑出现次数大于 n / 4 = 2的字母：counter = {W:3,Q:4}
 * 我们的目标是把字符串中多余的字母替换掉，即使得 counter_balanced = {W:2,Q:2,E:2,R:2}
 * 开始时 l = r = 0，此时s[l,r] = 'W',那么此子串不足以将W和Q替换完，所以我们继续考察后面的字符串，r += 1
 * 到了r = 4时，此时s[l,r] = 'WQWRQ'，那么可替换掉的W有两个，Q有两个，对比counter_balanced和counter
 * 我们可以知道，其实我们只需要换掉一个W和两个Q。此时我们可以考虑缩小考察范围，以获得最小的子串，l += 1
 * 直到l = 1时，此时s[l,r] = 'QWRQ'，我们就可以更新最小子串的长度。
 * 当l移动到一定程度的时候，子串里的字母又不够替换了，此时我们再移动r。长此以往，就能得到最短替换子串了。
 * @Author: wangyinghao_sx
 * @Date: 2019-10-22 19:09
 **/
public class Solution {
    @Test
    public void balancedString() {
        String s = "WWEQERQWQWWRWWERQWEQ";
        int[] count = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'A']++;
        }
        int left = 0;
        int right = 0;
        int ret = n;
        for (right = 0; right < n; right++) {
            count[s.charAt(right) - 'A']--;
            while (left < n && count['Q' - 'A'] <= n / 4 && count['W' - 'A'] <= n / 4 && count['E' - 'A'] <= n / 4 && count['R' - 'A'] <= n / 4) {
                ret = Math.min(ret, right - left + 1);
                count[s.charAt(left) - 'A']++;
                left++;
            }
        }
    }
}
