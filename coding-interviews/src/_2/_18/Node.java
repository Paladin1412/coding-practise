package _2._18;

/**
 * @Description: 一种怪异的节点删除方式
 * @Author: wangyinghao_sx
 * @Date: 2020-05-23 21:36
 **/
public class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
    }

    public void removeNodeWired(Node node) {
        if (node == null) {
            return;
        }
        Node next = node.next;
        if (next == null) {
            throw new RuntimeException("can not remove last node.");
        }
        node.value = next.value;
        node.next = next.next;
    }
}
