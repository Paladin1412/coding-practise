package _1._1;

import java.util.Stack;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-09 17:38
 **/
public class MyStack2 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack2() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(int newNum) {
        if (stackMin.isEmpty()) {
            stackMin.push(newNum);
        } else if (newNum <= getMin()) {
            stackMin.push(newNum);
        } else {
            stackMin.push(stackMin.peek());
//            stackMin.push(getMin()); 当stackMin为空时getMin抛异常
        }
        stackData.push(newNum);
    }

    public int pop() {
        if (stackData.isEmpty()) {
            throw new RuntimeException("empty");
        }
        stackMin.pop();
        return stackData.pop();
    }


    public int getMin() {
        if (stackMin.isEmpty()) {
            throw new RuntimeException("empty");
        }
        return stackMin.peek();
    }
}
