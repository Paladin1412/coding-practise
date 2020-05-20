package _2._14;

import java.util.HashSet;

/**
 * @Description: 删除无序单链表中值重复出现的节点
 * @Author: wangyinghao_sx
 * @Date: 2020-05-20 21:10
 **/
public class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
    }

    public void removeRep1(Node head) {
        HashSet<Integer> set = new HashSet<>();
        Node pre = head;
        Node cur = head.next;
        set.add(head.value);
        while (cur != null) {
            if (set.contains(cur.value)) {
                pre.next = cur.next;
            } else {
                set.add(cur.value);
                pre = cur;
            }
            cur = cur.next;
        }
    }

    public void removeRep2(Node head) {
        Node cur = head;
        Node pre = null;
        Node next = null;
        while (cur != null) {
            pre = cur;
            next = cur.next;
            while (next != null) {
                if (cur.value == next.value) {
                    pre.next = next.next;
                } else {
                    pre = next;
                }
                next = next.next;
            }
            cur = cur.next;
        }
    }
}
