package _3._14;

/**
 * @Description: 根据后序数组重建搜索二叉树
 * @Author: wangyinghao_sx
 * @Date: 2020-05-28 21:36
 **/
public class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }

    public boolean isPostArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        return isPost(arr, 0, arr.length - 1);
    }

    private boolean isPost(int[] arr, int start, int end) {
        if (start == end) {
            return true;
        }
        int less = -1;
        int more = end;
        for (int i = start; i < end; i++) {
            if (arr[end] > arr[i]) {
                less = i;
            } else {
                more = more == end ? i : more;
            }
        }
        if (less == -1 || more == end) {
            return isPost(arr, start, end - 1);
        }
        if (less != more - 1) {
            return false;
        }
        return isPost(arr, start, less) && isPost(arr, more, end - 1);
    }

    public Node posArrayToBST(int[] posArr) {
        if (posArr == null) {
            return null;
        }
        return posToBST(posArr, 0, posArr.length - 1);
    }

    private Node posToBST(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        Node head = new Node(arr[end]);
        int less = -1;
        int more = end;
        for (int i = start; i < end; i++) {
            if (arr[end] > arr[i]) {
                less = i;
            } else {
                more = more == end ? i : more;
            }
        }
        head.left = posToBST(arr, start, less);
        head.right = posToBST(arr, more, end - 1);
        return head;
    }
}
