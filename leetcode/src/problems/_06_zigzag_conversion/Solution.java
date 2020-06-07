package problems._06_zigzag_conversion;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: Z 字形变换
 * @Author: wangyinghao
 * @Date: 2020-06-06 21:58
 **/
public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int tmpCol = chars.length / (numRows * 2 - 2) * (numRows - 1);
        int remainder = chars.length % (numRows * 2 - 2);
        int col = remainder == 0 ? tmpCol : (tmpCol + 1 + ((remainder <= numRows) ? 1 :
                (remainder - numRows)));
        char[][] tmpChars = new char[numRows][col];
        int index = 0;
        int i = 0;
        int j = 0;
        boolean flag = true;
        while (index < chars.length) {
            char c = chars[index++];
            tmpChars[i][j] = c;
            if ((i == numRows - 1 && flag) || (i == 0 && !flag)) {
                flag = !flag;
            }
            if (flag) {
                i++;
            } else {
                i--;
                j++;
            }
        }
        StringBuilder res = new StringBuilder();
        for (char[] tmpChar : tmpChars) {
            for (char c : tmpChar) {
                if (c != '\u0000') {
                    res.append(c);
                }
            }
        }
        return res.toString();
    }

    public String convert1(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) {
            ret.append(row);
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        new Solution().convert(s, 3);
    }
}
