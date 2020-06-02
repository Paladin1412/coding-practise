package _3._18;

import java.util.HashMap;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-31 20:20
 **/
public class Record2 {
    private HashMap<Node, HashMap<Node, Node>> map;

    public Record2(Node head) {
        map = new HashMap<>();
        initMap(head);
        setMap(head);
    }

    private void setMap(Node head) {
        if (head == null) {
            return;
        }
        headRecord(head.left, head);
        headRecord(head.right, head);
        subRecord(head);
        setMap(head.left);
        setMap(head.right);
    }

    private void subRecord(Node head) {
        if (head == null) {
            return;
        }
        preLeft(head.left, head.right, head);
        subRecord(head.left);
        subRecord(head.right);
    }

    private void preLeft(Node l, Node r, Node h) {
        if (l == null) {
            return;
        }
        preRight(l, r, h);
        preLeft(l.left, r, h);
        preLeft(l.right, r, h);
    }

    private void preRight(Node l, Node r, Node h) {
        if (r == null) {
            return;
        }
        map.get(l).put(r, h);
        preRight(l, r.left, h);
        preRight(l, r.right, h);
    }

    private void headRecord(Node n, Node h) {
        if (n == null) {
            return;
        }
        map.get(n).put(h, h);
        headRecord(n.left, h);
        headRecord(n.right, h);
    }

    private void initMap(Node head) {
        if (head == null) {
            return;
        }
        map.put(head, new HashMap<>());
        initMap(head.left);
        initMap(head.right);
    }

    public Node query(Node o1, Node o2) {
        if (o1 == o2) {
            return o1;
        }
        if (map.containsKey(o1)) {
            return map.get(o1).get(o2);
        }
        if (map.containsKey(o2)) {
            return map.get(o2).get(o1);
        }
        return null;
    }
}
