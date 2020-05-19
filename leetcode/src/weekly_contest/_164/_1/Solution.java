package weekly_contest._164._1;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2019-11-24 10:31
 **/
public class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int slashStep = Math.max(Math.abs(points[i + 1][0] - points[i][0]),
                    Math.abs(points[i + 1][1] - points[i][1]));
            res += slashStep;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{1,1},{3,4},{-1,0}};
        System.out.println(new Solution().minTimeToVisitAllPoints(points));
    }
}
