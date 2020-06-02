package _3._22;

import java.util.HashMap;

/**
 * @Description: 通过先序和中序数组生成后序数组
 * @Author: wangyinghao_sx
 * @Date: 2020-06-01 19:44
 **/
public class Solution {
    public int[] getPosArray(int[] pre, int[] in) {
        if (pre == null || in == null) {
            return null;
        }
        int len = pre.length;
        int[] pos = new int[len];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        setPos(pre, 0, len - 1, in, 0, len - 1, pos, len - 1, map);
        return pos;
    }

    private int setPos1(int[] p, int pi, int pj, int[] n, int ni, int nj, int[] s, int si, HashMap<Integer,
            Integer> map) {
        if (pi > pj) {
            return si;
        }
        s[si--] = p[pi];
        int i = map.get(p[pi]);
        si = setPos1(p, pj - nj + i + 1, pj, n, i + 1, nj, s, si, map);
        return setPos1(p, pi + 1, pi + i - ni, n, ni, i - 1, s, si, map);
    }

    private void setPos(int[] p, int pi, int pj, int[] n, int ni, int nj, int[] s, int si, HashMap<Integer,
            Integer> map) {
        if (pi > pj) {
            return;
        }
        s[si--] = p[pi];
        int i = map.get(p[pi]);
        setPos(p, pi + 1, i - ni + pi, n, ni, i - 1, s, si - (nj - i), map);
        setPos(p, i - ni + pi + 1, pj, n, i + 1, nj, s, si, map);
    }

    public static void main(String[] args) {
        int[] pre = new int[]{1, 2, 4, 5, 3, 6, 7};
        int[] in = new int[]{4, 2, 5, 1, 6, 3, 7};
        new Solution().getPosArray(pre, in);
    }
}
