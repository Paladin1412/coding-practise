package _2._15;

import java.util.Stack;

/**
 * @Description: 在单链表中删除指定值的节点
 * @Author: wangyinghao_sx
 * @Date: 2020-05-21 20:00
 **/
public class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
    }

    public Node removeValue1(Node head, int num) {
        Stack<Node> stack = new Stack<>();
        while (head != null) {
            if (head.value != num) {
                stack.push(head);
            }
            head = head.next;
        }
        while (!stack.isEmpty()) {
            stack.peek().next = head;
            head = stack.pop();
        }
        return head;
    }

    public Node removeValue2(Node head, int num) {
        while (head != null) {
            if (head.value != num) {
                break;
            }
            head = head.next;
        }
        Node pre = head;
        Node cur = head;
        while (cur != null) {
            if (cur.value == num) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
