package weekly_contest._165._1;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2019-12-01 10:33
 **/
public class Solution {
    public String tictactoe(int[][] moves) {
        int[][] arr = new int[3][3];
        for (int i = 0; i < moves.length; i++) {
            if (i % 2 == 0) {
                arr[moves[i][0]][moves[i][1]] = 1;
            } else {
                arr[moves[i][0]][moves[i][1]] = -1;
            }
        }
        if(arr[0][0] == 1 && arr[1][1] == 1 & arr[2][2] == 1||arr[0][2] == 1 && arr[1][1] == 1 & arr[2][0] == 1){
            return "A";
        }else if(arr[0][0] == -1 && arr[1][1] == -1 & arr[2][2] == -1||arr[0][2] == -1 && arr[1][1] == -1 & arr[2][0] == -1){
            return "B";
        }
        String res = "Draw";
        for (int i = 0; i < 3; i++) {
            if (arr[i][0] == 1 && arr[i][1] == 1 & arr[i][2] == 1) {
                return "A";
            } else if (arr[i][0] == -1 && arr[i][1] == -1 & arr[i][2] == -1) {
                return "B";
            }
            for (int j = 0; j < 3; j++) {
                if (arr[i][j] == 0) {
                    res =  "Pending";
                }
                if (arr[0][j] == 1 && arr[1][j] == 1 & arr[2][j] == 1) {
                    return "A";
                } else if (arr[0][j] == -1 && arr[1][j] == -1 & arr[2][j] == -1) {
                    return "B";
                }
            }
        }
        return res;
    }
}
