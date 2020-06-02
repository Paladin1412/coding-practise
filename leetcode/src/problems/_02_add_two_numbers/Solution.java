package problems._02_add_two_numbers;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-06-01 20:19
 **/
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode head = new ListNode(0);
        ListNode node = head;
        int add = 0;
        int tmp = 0;
        while (l1 != null && l2 != null) {
            tmp = l1.val + l2.val + node.val;
            node.val = tmp % 10;
            add = tmp / 10;
            l1 = l1.next;
            l2 = l2.next;
            if (l1 != null || l2 != null || add != 0) {
                node.next = new ListNode(add);
                node = node.next;
            }
        }
        while (l1 != null) {
            tmp = l1.val + node.val;
            node.val = tmp % 10;
            add = tmp / 10;
            l1 = l1.next;
            if (l1 != null || add != 0) {
                node.next = new ListNode(add);
                node = node.next;
            }
        }
        while (l2 != null) {
            tmp = l2.val + node.val;
            node.val = tmp % 10;
            add = tmp / 10;
            l2 = l2.next;
            if (l2 != null || add != 0) {
                node.next = new ListNode(add);
                node = node.next;
            }
        }
        return head;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode cur = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = p == null ? 0 : p.val;
            int y = q == null ? 0 : q.val;
            int sum = x + y + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            p = p == null ? p : p.next;
            q = q == null ? q : q.next;
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
