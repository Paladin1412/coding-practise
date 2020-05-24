package _2._21;

import java.rmi.dgc.Lease;

/**
 * @Description: 按照左右半区的方式重新组合单链表
 * @Author: wangyinghao_sx
 * @Date: 2020-05-23 22:19
 **/
public class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
    }

    public void relocate(Node head) {
        if (head == null || head.next == null) {
            return;
        }
        Node mid = head;
        Node right = head.next;
        while (right.next != null && right.next.next != null) {
            mid = mid.next;
            right = right.next.next;
        }
        right = mid.next;
        mid.next = null;
        mergeLR(head, right);
    }

    private void mergeLR(Node left, Node right) {
        Node next = null;
        while (left.next != null) {
            next = right.next;
            right.next = left.next;
            left.next = right;
            left = right.next;
            right = next;
        }
        left.next = right;
    }
}
