package _1._11;

import java.util.Stack;

/**
 * @Description: 可见的山峰对数量
 * @Author: wangyinghao_sx
 * @Date: 2020-05-16 20:17
 **/
public class Solution {
    public int getVisibleNum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int size = arr.length;
        int maxIndex = 0;
        for (int i = 0; i < size; i++) {
            maxIndex = arr[maxIndex] < arr[i] ? i : maxIndex;
        }
        Stack<Record> stack = new Stack<>();
        stack.push(new Record(maxIndex));
        int index = nextIndex(maxIndex, size);
        int res = 0;
        while (index != maxIndex) {
            while (stack.peek().value < arr[index]) {
                int k = stack.pop().times;
                res += getInternalSum(k) + 2 * k;
            }
            if (stack.peek().value == arr[index]) {
                stack.peek().times++;
            } else {
                stack.push(new Record(arr[index]));
            }
            index = nextIndex(index, size);
        }
        while (stack.size() > 2) {
            int times = stack.pop().times;
            res += getInternalSum(times) + 2 * times;
        }
        if (stack.size() == 2) {
            int times = stack.pop().times;
            res += getInternalSum(times) + (stack.peek().times == 1 ? times : 2 * times);
        }
        res += getInternalSum(stack.pop().times);
        return res;
    }

    public int getInternalSum(int k) {
        return k == 1 ? 0 : (k * (k - 1)) / 2;
    }

    public int nextIndex(int i, int size) {
        return i < (size - 1) ? (i + 1) : 0;
    }
}

class Record {
    public int value;
    public int times;

    public Record(int value) {
        this.value = value;
        this.times = 1;
    }
}
