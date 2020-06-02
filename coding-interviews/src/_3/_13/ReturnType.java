package _3._13;

/**
 * @Description: 判断二叉树是否为平衡二叉树
 * @Author: wangyinghao_sx
 * @Date: 2020-05-28 21:30
 **/
public class ReturnType {
    public boolean isBalanced;
    public int height;

    public ReturnType(boolean isBalanced, int height) {
        this.isBalanced = isBalanced;
        this.height = height;
    }

    public ReturnType process(Node head) {
        if (head == null) {
            return new ReturnType(true, 0);
        }
        ReturnType leftData = process(head.left);
        ReturnType rightData = process(head.right);
        int height = Math.max(leftData.height, rightData.height) + 1;
        boolean isBalanced = leftData.isBalanced && rightData.isBalanced && Math.abs(leftData.height - rightData.height) < 2;
        return new ReturnType(isBalanced, height);

    }

    public boolean isBalanced(Node head) {
        return process(head).isBalanced;
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
