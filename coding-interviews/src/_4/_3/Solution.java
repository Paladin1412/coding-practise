package _4._3;

/**
 * @Description: 换钱的最少货币数
 * @Author: wangyinghao
 * @Date: 2020-06-04 20:15
 **/
public class Solution {
    public int minCoins1(int[] arr, int aim) {
        return process(arr, 0, aim);
    }

    private int process(int[] arr, int i, int rest) {
        if (i == arr.length) {
            return rest == 0 ? 0 : -1;
        }
        int res = -1;
        for (int k = 0; k * arr[i] <= rest; k++) {
            int next = process(arr, i + 1, rest - k * arr[i]);
            if (next != -1) {
                res = res == -1 ? next + k : Math.max(res, next + k);
            }
        }
        return res;
    }

    public int minCoins2(int[] arr, int aim) {
        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
        for (int col = 1; col <= aim; col++) {
            dp[N][col] = -1;
        }
        for (int i = N - 1; i >= 0; i--) {
            for (int rest = 0; rest <= aim; rest++) {
                if (dp[i + 1][rest] != -1) {
                    dp[i][rest] = dp[i + 1][rest];
                }
                if (rest - arr[i] >= 0 && dp[i][rest - arr[i]] != -1) {
                    if (dp[i][rest] == -1) {
                        dp[i][rest] = dp[i][rest - arr[i]] + 1;
                    } else {
                        dp[i][rest] = Math.min(dp[i][rest], dp[i][rest - arr[i]] + 1);
                    }
                }
            }
        }
        return dp[0][aim];
    }
}
