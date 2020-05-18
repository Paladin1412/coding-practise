package _2._1;

/**
 * @Description: 打印两个有序链表的公共部分
 * @Author: wangyinghao_sx
 * @Date: 2020-05-17 20:00
 **/
public class Node {
    public int value;
    public Node next;

    public Node(int data) {
        this.value = data;
    }

    public void printCommonPart(Node head1, Node head2) {
        System.out.println("Common Part: ");
        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                head1 = head1.next;
            } else if (head1.value > head2.value) {
                head2 = head2.next;
            } else {
                System.out.println(head1.value + " ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }
}
