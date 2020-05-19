package weekly_contest._178._3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-03-02 12:03
 **/
public class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (dfsNum(head, node)) {
                return true;
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return false;
    }

    private boolean dfsNum(ListNode node1, TreeNode node2) {
        if (node1 == null) {
            return true;
        }
        if (node2 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        return dfsNum(node1.next, node2.left)|| dfsNum(node1.next, node2.right);
    }
}
