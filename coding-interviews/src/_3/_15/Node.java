package _3._15;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 判断一棵二叉树是否为搜索二叉树和完全二叉树 搜索二叉树需要看遍历二叉树的神级方法 还没看
 * @Author: wangyinghao_sx
 * @Date: 2020-05-28 21:54
 **/
public class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }

    public boolean isCBT(Node head) {
        if (head == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        boolean leaf = false;
        queue.offer(head);
        Node l = null;
        Node r = null;
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;
            if ((l == null && r != null) || (leaf && (r != null || l != null))) {
                return false;
            }
            if (l != null) {
                queue.offer(l);
            }
            if (r != null) {
                queue.offer(r);
            } else {
                leaf = true;
            }
        }
        return true;
    }
}
