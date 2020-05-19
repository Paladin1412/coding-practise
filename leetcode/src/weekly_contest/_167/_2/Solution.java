package weekly_contest._167._2;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2019-12-15 10:54
 **/
public class Solution {
//    public List<Integer> sequentialDigits(int low, int high) {
//        List<Integer> res = new ArrayList<>();
//        String lowStr = String.valueOf(low);
//        String highStr = String.valueOf(high);
//        int lenLow = lowStr.length();
//        int lenHigh = highStr.length();
//        int low_0 = Integer.valueOf(lowStr.indexOf(0));
//        int high_0 = Integer.valueOf(highStr.indexOf(0));
//        if (low_0 + lenLow > 10) {
//            low_0 = 1;
//            lenLow++;
//        }
//        int beg = low_0;
//        for (int i = 1; i <= lenLow; i++) {
//            beg *= 10;
//            beg += (low_0 + i);
//        }
//        if (beg <= low) {
//            if (low_0 + lenLow >= 10) {
//                low_0 = 0;
//                lenLow++;
//            }
//            beg = low_0 + 1;
//            for (int i = 1; i <= lenLow; i++) {
//                beg *= 10;
//                beg += (low_0 + 1 + i);
//            }
//        }
//        while (beg < high) {
//
//        }
//    }
}