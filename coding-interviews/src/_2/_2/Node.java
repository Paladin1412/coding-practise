package _2._2;

/**
 * @Description: 在单链表和双链表中删除倒数第K个节点
 * @Author: wangyinghao_sx
 * @Date: 2020-05-17 20:08
 **/
public class Node {
    public int value;
    public Node next;

    public Node(int data) {
        this.value = data;
    }

    public Node removeLastKthNode(Node head, int lastKth) {
        if (head == null || lastKth < 1) {
            return head;
        }
        Node cur = head;
        while (cur != null) {
            lastKth--;
            cur = cur.next;
        }
        if (lastKth == 0) {
            head = head.next;
        }
        if (lastKth < 0) {
            cur = head;
            while (++lastKth != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }
}
