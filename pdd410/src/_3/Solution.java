package _3;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-04-10 19:32
 **/
public class Solution {
    public void getMinLuck(int N, int K, int[] arr) {
        int loss = 9 * K;
        int[] arrTmp = new int[arr.length];
        int[] arrRes = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arrRes[i] = 9;
        }
        int[][] arrNum = new int[10][N + 1];
        for (int i = 0; i < arr.length; i++) {
            int anInt = arr[i];
            int sum = arrNum[anInt][0] + 1;
            arrNum[anInt][0] = sum;
            arrNum[anInt][sum] = i;
        }
        for (int i = 0; i < 10; i++) {
            if (arrNum[i][0] >= K) {
                System.out.println(0);
                for (int anInt : arr) {
                    System.out.print(anInt);
                }
                return;
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < arr.length; j++) {
                arrTmp[j] = arr[j];
            }
            int m = K - arrNum[i][0];
            int lossTmp = 0;
            int j = 2;
            int k = -1;
            while (m > 0) {
                if (j % 2 == 0) {
                    k = -(j / 2);
                } else {
                    k = j / 2;
                }
                if (i + k >= 0 && i + k < 10) {
                    if (k > 0) {
                        for (int l = 1; l <= arrNum[i + k][0]; l++) {
                            if (m > 0) {
                                lossTmp += Math.abs(k);
                                arrTmp[arrNum[i + k][l]] = i;
                                m--;
                            } else {
                                break;
                            }
                        }
                    } else {
                        for (int l = arrNum[i + k][0]; l >= 1; l--) {
                            if (m > 0) {
                                lossTmp += Math.abs(k);
                                arrTmp[arrNum[i + k][l]] = i;
                                m--;
                            } else {
                                break;
                            }
                        }
                    }
                }
                j++;
            }
            if (lossTmp == loss) {
                loss = lossTmp;
                for (int n = 0; n < arr.length; n++) {
                    if (arrRes[n] > arrTmp[n]) {
                        for (int z = 0; z < arr.length; z++) {
                            arrRes[z] = arrTmp[z];
                        }
                        break;
                    }
                }
            } else if (lossTmp < loss) {
                loss = lossTmp;
                for (int z = 0; z < arr.length; z++) {
                    arrRes[z] = arrTmp[z];
                }
            }
        }
        System.out.println(loss);
        for (int anInt : arrRes) {
            System.out.print(anInt);
        }
        return;
    }

    public static void main(String[] args) {
        int N = 6;
        int K = 5;
        int[] arr = new int[]{7, 8, 7, 5, 8, 5};
        new Solution().getMinLuck(N, K, arr);
    }
}
