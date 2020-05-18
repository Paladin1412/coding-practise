package _1._2;

import java.util.Stack;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-11 19:10
 **/
public class TwoStacksQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public TwoStacksQueue() {
        this.stackPush = new Stack<>();
        this.stackPop = new Stack<>();
    }

    private void pushToPop() {
        if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.add(stackPush.pop());
            }
        }
    }

    public void add(int pushInt) {
        stackPush.add(pushInt);
        pushToPop();
    }

    public int poll() {
        if (stackPop.isEmpty() && stackPush.isEmpty()) {
            throw new RuntimeException("empty");
        }
        pushToPop();
        return stackPop.pop();
    }

    public int peek() {
        if (stackPop.isEmpty() && stackPush.isEmpty()) {
            throw new RuntimeException("empty");
        }
        pushToPop();
        return stackPop.peek();
    }
}
