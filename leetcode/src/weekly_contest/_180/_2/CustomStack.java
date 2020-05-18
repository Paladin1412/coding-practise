package weekly_contest._180._2;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-03-15 10:52
 **/
public class CustomStack {
    private int[] stack;
    private int size;

    public CustomStack(int maxSize) {
        this.stack = new int[maxSize];
        this.size = 0;
    }

    public void push(int x) {
        if (this.size < this.stack.length) {
            this.stack[size++] = x;
        }
    }

    public int pop() {
        if (this.size > 0) {
            return this.stack[--this.size];
        }
        return -1;
    }

    public void increment(int k, int val) {
        for (int i = 0; i < this.size; i++) {
            if (i < k) {
                this.stack[i] = this.stack[i] + val;
            }
        }
    }

    public static void main(String[] args) {
        CustomStack customStack = new CustomStack(3);
        customStack.push(1);                          // 栈变为 [1]
        customStack.push(2);                          // 栈变为 [1, 2]
        customStack.pop();                            // 返回 2 --> 返回栈顶值 2，栈变为 [1]
        customStack.push(2);                          // 栈变为 [1, 2]
        customStack.push(3);                          // 栈变为 [1, 2, 3]
        customStack.push(4);                          // 栈仍然是 [1, 2, 3]，不能添加其他元素使栈大小变为 4
        customStack.increment(5, 100);                // 栈变为 [101, 102, 103]
        customStack.increment(2, 100);                // 栈变为 [201, 202, 103]
        customStack.pop();                            // 返回 103 --> 返回栈顶值 103，栈变为 [201, 202]
        customStack.pop();                            // 返回 202 --> 返回栈顶值 202，栈变为 [201]
        customStack.pop();                            // 返回 201 --> 返回栈顶值 201，栈变为 []
        customStack.pop();                            // 返回 -1 --> 栈为空，返回 -1
    }
}
