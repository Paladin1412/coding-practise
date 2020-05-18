package _2._4;

/**
 * @Description: 反转单向和双向链表
 * @Author: wangyinghao_sx
 * @Date: 2020-05-17 20:42
 **/
public class Node {
    public int value;
    public Node next;

    public Node(int data) {
        this.value = data;
    }

    public Node reverseList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
