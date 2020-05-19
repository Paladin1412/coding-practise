package weekly_contest._171._2;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-01-12 10:51
 **/
public class Solution {
    public int minFlips(int a, int b, int c) {
        String aBinaryString = Integer.toBinaryString(a);
        String bBinaryString = Integer.toBinaryString(b);
        String cBinaryString = Integer.toBinaryString(c);
        int aLength = aBinaryString.length();
        int bLength = bBinaryString.length();
        int cLength = cBinaryString.length();
        int res = 0;
        int aIndex = 0;
        int bIndex = 0;
        int cIndex = 0;
        while (cLength > 0) {
            cIndex = cBinaryString.charAt(cLength-1)-'0';
            cLength--;
            cBinaryString = cBinaryString.substring(0,cLength);
            if (aLength > 0) {
                aIndex = aBinaryString.charAt(aLength-1)-'0';
                aLength--;
                aBinaryString = aBinaryString.substring(0,aLength);
            } else {
                aIndex = 0;
            }
            if (bLength > 0) {
                bIndex = bBinaryString.charAt(bLength-1)-'0';
                bLength--;
                bBinaryString = bBinaryString.substring(0,bLength);
            } else {
                bIndex = 0;
            }
            if (cIndex == 1 && (aIndex == 0 && bIndex == 0)) {
                res++;
            } else if (cIndex == 0 && (aIndex == 1 || bIndex == 1)) {
                res++;
                if (aIndex == 1 && bIndex == 1) {
                    res++;
                }
            }
        }
        while (aLength > 0) {
            aIndex = aBinaryString.charAt(aLength-1)-'0';
            aLength--;
            aBinaryString = aBinaryString.substring(0,aLength);
            if (aIndex == 1) {
                res++;
            }
        }
        while (bLength > 0) {
            bIndex = bBinaryString.charAt(bLength-1)-'0';
            bLength--;
            bBinaryString = bBinaryString.substring(0,bLength);
            if (bIndex == 1) {
                res++;
            }
        }
        return res;
    }
}
