package _3._6;

import java.util.HashMap;

/**
 * @Description: 在二叉树中找到累加和为指定值的最长路径长度
 * @Author: wangyinghao_sx
 * @Date: 2020-05-25 19:40
 **/
public class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }

    public int getMaxLength(Node head, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        return preOrder(head, sum, 0, 1, 0, map);
    }

    private int preOrder(Node head, int sum, int preSum, int level, int maxLen, HashMap<Integer, Integer> map) {
        if (head == null) {
            return maxLen;
        }
        int curSum = preSum + head.value;
        if (!map.containsKey(curSum)) {
            map.put(curSum, level);
        }
        if (map.containsKey(curSum - sum)) {
            maxLen = Math.max(maxLen, level - map.get(curSum - sum));
        }
        maxLen = preOrder(head.left, sum, curSum, level + 1, maxLen, map);
        maxLen = preOrder(head.right, sum, curSum, level + 1, maxLen, map);
        if (level == map.get(curSum)) {
            map.remove(curSum);
        }
        return maxLen;
    }
}
