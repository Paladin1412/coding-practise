package _3._3;

/**
 * @Description: 如何较为直观的打印二叉树
 * @Author: wangyinghao_sx
 * @Date: 2020-05-24 22:26
 **/
public class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }

    public void printTree(Node head) {
        printInOrder(head, 0, "H", 17);
    }

    private void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    private String getSpace(int len) {

        String space = " ";
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < len; i++) {
            buf.append(space);
        }
        return buf.toString();
    }
}
