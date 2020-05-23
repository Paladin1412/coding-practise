package _2._16;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Predicate;

/**
 * @Description: 将搜索二叉树转换成双向链表
 * @Author: wangyinghao_sx
 * @Date: 2020-05-21 20:23
 **/
public class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }

    public Node convert1(Node head) {
        Queue<Node> queue = new LinkedList<>();
        inOrderToQueue(head, queue);
        if (queue.isEmpty()) {
            return head;
        }
        head = queue.poll();
        Node pre = head;
        Node cur = null;
        pre.left = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }
        pre.right = null;
        return head;
    }

    public void inOrderToQueue(Node head, Queue<Node> queue) {
        if (head == null) {
            return;
        }
        inOrderToQueue(head.left, queue);
        queue.offer(head);
        inOrderToQueue(head.right, queue);
    }

    public Node convert2(Node head) {
        if (head == null) {
            return null;
        }
        return process(head).start;
    }

    public ReturnType process(Node head) {
        if (head == null) {
            return new ReturnType(null, null);
        }
        ReturnType leftList = process(head.left);
        ReturnType rightList = process(head.right);
        if (leftList.end != null) {
            leftList.end.right = head;
        }
        head.left = leftList.end;
        head.right = rightList.start;
        if (rightList.start != null) {
            rightList.start.left = head;
        }
        return new ReturnType(leftList.start != null ? leftList.start : head, rightList.end != null ? rightList.end : head);
    }
}


class ReturnType {
    public Node start;
    public Node end;

    public ReturnType(Node start, Node end) {
        this.start = start;
        this.end = end;
    }
}