package weekly_contest._176._3;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-02-16 11:14
 **/
public class Solution {
    public int maxEvents(int[][] events) {
        int m = events.length;
        int n = 0;
        for (int[] event : events) {
            for (int i : event) {
                n = i > n ? i : n;
            }
        }
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            int event0 = events[i][0];
            int event1 = events[i][1];
            while (event0 <= event1) {
                arr[i][event0 - 1] = 1;
                event0++;
            }
        }
        int max = 0;
        for (int j = 0; j < n; j++) {
            if (arr[0][j] == 0) {
                int[][] tmp = new int[m - 1][n];
                for (int i = 1; i < m; i++) {
                    for (int k = 0; k < n; k++) {
                        tmp[i - 1][k] = arr[i][k];
                    }
                }
                max = getMax(tmp) > max ? getMax(tmp) : max;
            } else if (arr[0][j] == 1) {
                int[][] tmp = new int[m - 1][n - 1];
                for (int i = 1; i < m; i++) {
                    for (int k = 0; k < n; k++) {
                        if (k < j) {
                            tmp[i - 1][k] = arr[i][k];
                        } else if (k > j) {
                            tmp[i - 1][k - 1] = arr[i][k];
                        }
                    }
                }
                max = getMax(tmp) + 1 > max ? getMax(tmp) + 1 : max;
            }
        }
        return max;
    }

    private int getMax(int[][] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int m = arr.length;
        int n = arr[0].length;
        int max = 0;
        for (int j = 0; j < n; j++) {
            if (arr[0][j] == 0) {
                int[][] tmp = new int[m - 1][n];
                for (int i = 1; i < m; i++) {
                    for (int k = 0; k < n; k++) {
                        tmp[i - 1][k] = arr[i][k];
                    }
                }
                max = getMax(tmp) > max ? getMax(tmp) : max;
            } else if (arr[0][j] == 1) {
                int[][] tmp = new int[m - 1][n - 1];
                for (int i = 1; i < m; i++) {
                    for (int k = 0; k < n; k++) {
                        if (k < j) {
                            tmp[i - 1][k] = arr[i][k];
                        } else if (k > j) {
                            tmp[i - 1][k - 1] = arr[i][k];
                        }
                    }
                }
                max = getMax(tmp) + 1 > max ? getMax(tmp) + 1 : max;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{26, 27}, {24, 26}, {1, 4}, {1, 2}, {3, 6}, {2, 6}, {9, 13}, {6, 6}, {25, 27}, {22, 25}, {20, 24}, {8, 8},
                {27, 27}, {30, 32}};
        new Solution().maxEvents(arr);
    }
}
