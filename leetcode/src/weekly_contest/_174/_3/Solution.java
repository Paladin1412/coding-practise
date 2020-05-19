package weekly_contest._174._3;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-02-02 21:47
 **/
public class Solution {
    public int maxProduct(TreeNode root) {
        int sum = getSum(root);
        List<Long> list = new ArrayList<>();
        list.add(0L);
        getMax(root, sum, list);
        return (int) (list.get(0) % (1000000007));
    }

    public int getSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getSum(root.left);
        int right = getSum(root.right);
        return left + right + root.val;
    }

    public int getMax(TreeNode root, int sum, List list) {
        if (root == null) {
            return 0;
        }
        int left = getMax(root.left, sum, list);
        int right = getMax(root.right, sum, list);
        int s = left + right + root.val;
        long tmp  = (long) (sum-s)*s;
        if (tmp > (long) list.get(0)) {
            list.clear();
            list.add(tmp);
        }
        return s;
    }
}
