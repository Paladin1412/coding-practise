package _3._2;

/**
 * @Description: 打印二叉树的边界节点
 * @Author: wangyinghao_sx
 * @Date: 2020-05-24 21:01
 **/
public class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }

    public void printEdge1(Node head) {
        if (head == null) {
            return;
        }
        int height = getHeight(head, 0);
        Node[][] edgeMap = new Node[height][2];
        setEdgeMap(head, 0, edgeMap);
        //打印左边界
        for (int i = 0; i < edgeMap.length; i++) {
            System.out.println(edgeMap[i][0]);
        }
        //打印既不是左边界 又不是右边界的叶子节点
        printLeafNotInMap(head, 0, edgeMap);
        //打印右边界 但不是左边界的节点
        for (int i = edgeMap.length - 1; i > 0; i--) {
            if (edgeMap[i][0] != edgeMap[i][1]) {
                System.out.println(edgeMap[i][1]);
            }
        }
    }

    private void printLeafNotInMap(Node head, int i, Node[][] edgeMap) {
        if (head == null) {
            return;
        }
        if (head.left == null && head.right == null && head != edgeMap[i][0] && head != edgeMap[i][1]) {
            System.out.println(head.value);
        }
        printLeafNotInMap(head.left, i + 1, edgeMap);
        printLeafNotInMap(head.right, i + 1, edgeMap);
    }

    private void setEdgeMap(Node head, int i, Node[][] edgeMap) {
        if (head == null) {
            return;
        }
        edgeMap[i][0] = edgeMap[i][0] == null ? head : edgeMap[i][0];
        edgeMap[i][1] = head;
        setEdgeMap(head.left, i + 1, edgeMap);
        setEdgeMap(head.right, i + 1, edgeMap);
    }

    private int getHeight(Node head, int i) {
        if (head == null) {
            return i;
        }
        return Math.max(getHeight(head.left, i + 1), getHeight(head.right, i + 1));
    }

    public void printEdge2(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head.value);
        if (head.left != null && head.right != null) {
            printLeftEdge(head.left, true);
            printRightEdge(head.right, true);
        }
    }

    private void printRightEdge(Node head, boolean print) {
        if (head == null) {
            return;
        }
        printRightEdge(head.left, print && head.right == null ? true : false);
        printRightEdge(head.right, print);
        if (print || (head.left == null && head.right == null)) {
            System.out.println(head.value);
        }
    }

    private void printLeftEdge(Node head, boolean print) {
        if (head == null) {
            return;
        }
        if (print || (head.left == null && head.right == null)) {
            System.out.println(head.value);
        }
        printLeftEdge(head.left, print);
        printLeftEdge(head.right, print && head.left == null ? true : false);
    }
}
