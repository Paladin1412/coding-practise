package _1._6;

import java.util.Stack;

/**
 * @Description: 用栈来求解汉诺塔问题
 * @Author: wangyinghao_sx
 * @Date: 2020-05-12 20:15
 **/
public class MyHanoi {
    public int hanoiProblem1(int num, String left, String mid, String right) {
        if (num < 1) {
            return 0;
        }
        return process(num, left, mid, right, left, right);
    }

    public int process(int num, String left, String mid, String right, String from, String to) {
        if (num == 1) {
            if (from.equals(mid) || to.equals(mid)) {
                System.out.println("Move 1 from " + from + " to " + to);
                return 1;
            } else {
                System.out.println("Move 1 from " + from + " to " + mid);
                System.out.println("Move 1 from " + mid + " to " + to);
                return 2;
            }
        }
        if (from.equals(mid) || to.equals(mid)) {
            String another = (from.equals(left) || to.equals(left) ? right : left);
            int part1 = process(num - 1, left, mid, right, from, another);
            int part2 = 1;
            int part3 = process(num - 1, left, mid, right, another, to);
            return part1 + part2 + part3;
        } else {
            int part1 = process(num - 1, left, mid, to, from, to);
            int part2 = 1;
            System.out.println("Move 1 from " + from + " to " + mid);
            int part3 = process(num - 1, left, mid, to, to, from);
            int part4 = 1;
            System.out.println("Move 1 from " + mid + " to " + to);
            int part5 = process(num - 1, left, mid, to, from, to);
            return part1 + part2 + part3 + part4 + part5;
        }
    }

    public enum Action {
        No, LToM, MToL, MToR, RToM
    }

    public int hanoiProblem2(int num, String left, String mid, String right) {
        Stack<Integer> lS = new Stack<>();
        Stack<Integer> mS = new Stack<>();
        Stack<Integer> rS = new Stack<>();
        // push(Integer.MAX_VALUE)保证三个栈底都是最大值 满足小压大判断
        lS.push(Integer.MAX_VALUE);
        mS.push(Integer.MAX_VALUE);
        rS.push(Integer.MAX_VALUE);
        for (int i = num; i > 0; i--) {
            lS.push(i);
        }
        Action[] record = {Action.No};
        int step = 0;
        while (rS.size() != num + 1) {
            step += fStackTotStack(record, Action.MToL, Action.LToM, lS, mS, left, mid);
            step += fStackTotStack(record, Action.LToM, Action.MToL, mS, lS, mid, left);
            step += fStackTotStack(record, Action.RToM, Action.MToR, mS, rS, mid, right);
            step += fStackTotStack(record, Action.MToR, Action.RToM, rS, mS, right, mid);
        }
        return step;
    }

    public static int fStackTotStack(Action[] record,
                                     Action preNoAct, Action nowAct,
                                     Stack<Integer> fStack, Stack<Integer> tStack,
                                     String from, String to) {
        if (record[0] != preNoAct && fStack.peek() < tStack.peek()) {
            tStack.push(fStack.pop());
            System.out.println("Move " + tStack.peek() + " from " + from + " to " + to);
            record[0] = nowAct;
            return 1;
        }
        return 0;
    }
}













