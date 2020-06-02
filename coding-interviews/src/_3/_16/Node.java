package _3._16;

/**
 * @Description: 通过有序数组生成平衡搜索二叉树
 * @Author: wangyinghao_sx
 * @Date: 2020-05-30 19:11
 **/
public class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }

    public Node generateTree(int[] sortArr) {
        if (sortArr == null) {
            return null;
        }
        return generate(sortArr, 0, sortArr.length - 1);
    }

    private Node generate(int[] sortArr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node head = new Node(sortArr[mid]);
        head.left = generate(sortArr, 0, mid - 1);
        head.right = generate(sortArr, mid + 1, end);
        return head;
    }
}
