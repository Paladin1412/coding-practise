package _1._5;

import java.util.Stack;

/**
 * @Description: 用一个栈实现另一个栈的排序
 * @Author: wangyinghao_sx
 * @Date: 2020-05-12 20:09
 **/
public class MyStack {
    public static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            while (!help.isEmpty() && help.peek() < cur) {
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }
}
