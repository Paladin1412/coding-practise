package _3._20;

/**
 * @Description: 二叉树节点间的最大距离问题
 * @Author: wangyinghao_sx
 * @Date: 2020-06-01 19:21
 **/
public class ReturnType {
    public int maxDistance;
    public int height;

    public ReturnType(int maxDistance, int height) {
        this.maxDistance = maxDistance;
        this.height = height;
    }

    public ReturnType process(Node head) {
        if (head == null) {
            return new ReturnType(0, 0);
        }
        ReturnType leftData = process(head.left);
        ReturnType rightData = process(head.right);
        int height = Math.max(leftData.height, rightData.height) + 1;
        int maxDistance = Math.max(leftData.height + rightData.height + 1, Math.max(leftData.maxDistance,
                rightData.maxDistance));
        return new ReturnType(maxDistance, height);
    }
}

class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }
}