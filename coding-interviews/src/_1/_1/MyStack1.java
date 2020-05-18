package _1._1;

import java.util.Stack;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-09 17:26
 **/
public class MyStack1 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack1() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(int newNum) {
        if (stackMin.empty()) {
            stackMin.push(newNum);
        } else if (newNum <= getMin()) {
            stackMin.push(newNum);
        }
        stackData.push(newNum);
    }

    public int pop() {
        stackMin.isEmpty();
        if (stackData.empty()) {
            throw new RuntimeException("empty");
        }
        int value = stackData.pop();
        if (value == getMin()) {
            stackMin.pop();
        }
        return value;
    }

    public int getMin() {
        if (stackMin.empty()) {
            throw new RuntimeException("empty");
        }
        return stackMin.peek();
    }
}
