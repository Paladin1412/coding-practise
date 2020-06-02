package _3._8;

/**
 * @Description: 找到二叉树中符合搜索二叉树条件的最大拓扑结构
 * @Author: wangyinghao_sx
 * @Date: 2020-05-26 19:17
 **/
public class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }

    public int bstTopoSize1(Node head) {
        if (head == null) {
            return 0;
        }
        int max = maxTopo(head, head);
        max = Math.max(max, bstTopoSize1(head.left));
        max = Math.max(max, bstTopoSize1(head.right));
        return max;
    }

    private int maxTopo(Node h, Node n) {
        if (h != null && n != null && isBSTNode(h, n, n.value)) {
            return maxTopo(h, n.left) + maxTopo(h, n.right) + 1;
        }
        return 0;
    }

    private boolean isBSTNode(Node h, Node n, int value) {
        if (h == null) {
            return false;
        }
        if (h == n) {
            return true;
        }
        return isBSTNode(h.value > value ? h.left : h.right, n, value);
    }
}
