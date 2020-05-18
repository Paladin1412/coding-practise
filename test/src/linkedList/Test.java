package linkedList;

import java.util.LinkedList;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-16 20:05
 **/
public class Test {
    @org.junit.Test
    public void testPeekFirstAndGetFirst() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        Integer i1 = list.peekFirst();
        Integer i2 = list.getFirst();
        System.out.println("peek:" + i1);
        System.out.println("get:" + i2);
    }
}
