package _2._6;

/**
 * @Description: 环形单链表的约瑟夫问题
 * @Author: wangyinghao_sx
 * @Date: 2020-05-18 19:37
 **/
public class Node {
    public int value;
    public Node next;

    public Node(int data) {
        value = data;
    }

    public Node josephusKill1(Node head, int m) {
        if (head == null || head.next == null || m < 1) {
            return head;
        }
        Node last = head;
        while (last.next != head) {
            last = last.next;
        }
        int count = 0;
        while (head != last) {
            if (++count == m) {
                last.next = head.next;
                count = 0;
            } else {
                last = last.next;
            }
            head = head.next;
        }
        return head;
    }

    public Node josephusKill2(Node head, int m) {
        if (head == null || head.next == head || m < 1) {
            return head;
        }
        Node cur = head.next;
        int tmp = 1;
        while (cur != head) {
            tmp++;
            cur = cur.next;
        }
        tmp = getLive(tmp, m);
        while (--tmp != 0) {
            head = head.next;
        }
        head.next = head;
        return head;
    }

    public int getLive(int i, int m) {
        if (i == 1) {
            return 1;
        }
        return (getLive(i - 1, m) + m - 1) % i + 1;
    }
}
