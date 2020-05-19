package weekly_contest._167._1;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2019-12-15 10:43
 **/
public class Solution {
    public int getDecimalValue(ListNode head) {
        int res = 0;
        while (head != null) {
            res *= 2;
            res += head.val;
            head = head.next;
        }
        return res;
    }
}
