package weekly_contest._159._1;

/**
 * @Description: 在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，其中 coordinates[i] = [x, y] 表示横坐标为 x、纵坐标为 y 的点。
 * <p>
 * 请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 <font color="#c7254e" face="Menlo, Monaco, Consolas, Courier New, monospace">true</font>，
 * 否则请返回 <font color="#c7254e" face="Menlo, Monaco, Consolas, Courier New, monospace">false</font>。
 *
 * 两点确定一条直线，少于等于两个点直接返回 true
 * 根据前两个点求出斜率；
 * 遍历比较后面的点和第一个点的斜率是否与第二步骤求出的斜率相等；
 * 如果有一次斜率不等，即有点不在直线上；
 *
 * @Author: wangyinghao_sx
 * @Date: 2019-10-27 11:23
 **/
public class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        for (int i = 1; i < coordinates.length - 1; i++) {
            if ((double) (coordinates[i][1] - coordinates[i - 1][1]) / (double) (coordinates[i][0] - coordinates[i - 1][0]) == (double) (coordinates[i + 1][1] - coordinates[i][1]) / (double) (coordinates[i + 1][0] - coordinates[i][0])) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
