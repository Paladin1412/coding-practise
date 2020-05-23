package _2._17;

/**
 * @Description: 单链表的选择排序
 * @Author: wangyinghao_sx
 * @Date: 2020-05-21 20:59
 **/
public class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
    }

    public Node selectionSort(Node head) {
        Node tail = null;
        Node cur = head;
        Node smallPre = null;
        Node small = null;
        while (cur != null) {
            small = cur;
            smallPre = getSmallestPreNode(cur);
            if (smallPre != null) {
                small = smallPre.next;
                smallPre.next = small.next;
            }
            cur = cur == small ? cur.next : cur;
            if (tail == null) {
                head = small;
            } else {
                tail.next = small;
            }
            tail = small;
        }
        return head;
    }

    public Node getSmallestPreNode(Node head) {
        Node smallPre = null;
        Node small = head;
        Node pre = head;
        Node cur = head.next;
        while (cur != null) {
            if (cur.value < small.value) {
                smallPre = pre;
                small = cur;
            }
            pre = cur;
            cur = cur.next;
        }
        return smallPre;
    }
}
