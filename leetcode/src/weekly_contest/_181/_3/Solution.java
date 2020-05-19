package weekly_contest._181._3;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-03-22 11:15
 **/
public class Solution {
    public boolean hasValidPath(int[][] grid) {
        int i = 0;
        int j = 0;
        while (i < grid.length && j < grid[0].length) {
            if (i==grid.length-1&&j==grid[grid.length-1][grid[0].length-1]){
                return true;
            }
            if (grid[i][j]==1){
                j++;
            }else if(grid[i][j]==2){
                i++;
            }else if(grid[i][j]==3){
                i++;
                j++;
            }else if(grid[i][j]==4){
                i++;
                j--;
            }else if(grid[i][j]==5){
                i=i+1;
            }else if(grid[i][j]==6){
                i=i+1;
            }
        }
        return false;
    }
}
