package _3._8;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-26 19:49
 **/
public class Record {
    public int l;
    public int r;

    public Record(int l, int r) {
        this.l = l;
        this.r = r;
    }

    public int bstTopoSize2(Node head) {
        Map<Node, Record> map = new HashMap<>();
        return posOrder(head, map);
    }

    private int posOrder(Node h, Map<Node, Record> map) {
        if (h == null) {
            return 0;
        }
        int ls = posOrder(h.left, map);
        int rs = posOrder(h.right, map);
        modifyMap(h.left, h.value, map, true);
        modifyMap(h.right, h.value, map, false);
        Record lr = map.get(h.left);
        Record rr = map.get(h.right);
        int lbst = lr == null ? 0 : lr.l + lr.r + 1;
        int rbst = rr == null ? 0 : rr.l + rr.r + 1;
        map.put(h, new Record(lbst, rbst));
        return Math.max(lbst + rbst + 1, Math.max(ls, rs));
    }

    private int modifyMap(Node n, int v, Map<Node, Record> m, boolean s) {
        if (n == null || !m.containsKey(n)) {
            return 0;
        }
        Record r = m.get(n);
        if ((s && n.value > v) || ((!s) && n.value < v)) {
            m.remove(n);
            return r.l + r.r + 1;
        } else {
            int minus = modifyMap(s ? n.right : n.left, v, m, s);
            if (s) {
                r.r -= minus;
            } else {
                r.l -= minus;
            }
            m.put(n, r);
            return minus;
        }

    }
}
