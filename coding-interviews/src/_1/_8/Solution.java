package _1._8;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description: 单调栈结构
 * @Author: wangyinghao_sx
 * @Date: 2020-05-13 19:44
 **/
public class Solution {
    public int[][] rightWay(int[] arr) {
        int[][] res = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            int leftLessIndex = -1;
            int rightLessIndex = -1;
            int cur = i - 1;
            while (cur >= 0) {
                if (arr[cur] < arr[i]) {
                    leftLessIndex = cur;
                    break;
                }
                cur--;
            }
            cur = i + 1;
            while (cur < arr.length) {
                if (arr[cur] < arr[i]) {
                    rightLessIndex = cur;
                    break;
                }
                cur++;
            }
            res[i][0] = leftLessIndex;
            res[i][1] = rightLessIndex;
        }
        return res;
    }

    public int[][] getNearLessNoRepeat(int[] arr) {
        int[][] res = new int[arr.length][2];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                int popIndex = stack.pop();
                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
                int rightLessIndex = i;
                res[popIndex][0] = leftLessIndex;
                res[popIndex][1] = rightLessIndex;
            }
            stack.push(i);
        }
        while (!stack.empty()) {
            int popIndex = stack.pop();
            int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
            int rightLessIndex = -1;
            res[popIndex][0] = leftLessIndex;
            res[popIndex][1] = rightLessIndex;
        }
        return res;
    }

    public int[][] getNearLess(int[] arr) {
        int[][] res = new int[arr.length][2];
        Stack<List<Integer>> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek().get(0)] > arr[i]) {
                List<Integer> popIs = stack.pop();
                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
                int rightLessIndex = i;
                for (Integer popI : popIs) {
                    res[popI][0] = leftLessIndex;
                    res[popI][1] = rightLessIndex;
                }
            }
            if (!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]) {
                stack.peek().add(Integer.valueOf(i));
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }
        }
        while (!stack.isEmpty()) {
            List<Integer> popIs = stack.pop();
            int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
            int rightLessIndex = -1;
            for (Integer popI : popIs) {
                res[popI][0] = leftLessIndex;
                res[popI][1] = rightLessIndex;
            }
        }
        return res;
    }
}












