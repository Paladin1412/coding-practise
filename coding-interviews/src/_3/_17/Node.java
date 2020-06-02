package _3._17;

/**
 * @Description: 在二叉树中找到一个节点的后继节点
 * @Author: wangyinghao_sx
 * @Date: 2020-05-30 19:18
 **/
public class Node {
    public int value;
    public Node left;
    public Node right;
    public Node parent;

    public Node(int value) {
        this.value = value;
    }

    public Node getNextNode(Node node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            return getLeftMost(node.right);
        } else {
            Node parent = node.parent;
            while (parent != null && parent.left != node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    private Node getLeftMost(Node node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
