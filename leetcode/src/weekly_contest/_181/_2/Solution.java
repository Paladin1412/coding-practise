package weekly_contest._181._2;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-03-22 10:42
 **/
public class Solution {
    public int sumFourDivisors(int[] nums) {
        int res = 0;
        for (int num : nums) {
            int tmp = getDivisorsSum(num);
            res += tmp;
        }
        return res;
    }

    private int getDivisorsSum(int num) {
        int sum = 0;
        int count = 0;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                if (num / i != i) {
                    count = count + 2;
                    sum += i;
                    sum += num / i;
                } else {
                    count = count + 1;
                    sum += i;
                }
                if (count>4){
                    return 0;
                }
            }
        }
        if (count!=4){
            return 0;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{21, 4, 7};
        new Solution().sumFourDivisors(nums);
    }
}
