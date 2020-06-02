package _3._18;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-31 18:51
 **/
public class Record1 {
    private HashMap<Node, Node> map;

    public Record1(Node head) {
        map = new HashMap<Node, Node>();
        if (head != null) {
            map.put(head, null);
        }
        setMap(head);
    }

    private void setMap(Node head) {
        if (head == null) {
            return;
        }
        if (head.left != null) {
            map.put(head.left, head);
        }
        if (head.right != null) {
            map.put(head.right, head);
        }
        setMap(head.left);
        setMap(head.right);
    }

    public Node query(Node o1, Node o2) {
        HashSet<Node> path = new HashSet<>();
        while (map.containsKey(o1)) {
            path.add(o1);
            o1 = map.get(o1);
        }
        while (!path.contains(o2)) {
            o2 = map.get(o2);
        }
        return o2;
    }
}
