package _3._21;

import java.util.List;

/**
 * @Description: 派对的最大快乐值
 * @Author: wangyinghao_sx
 * @Date: 2020-06-01 19:33
 **/
public class Employee {
    public int happy;
    List<Employee> subordinates;

    public Employee(int happy, List<Employee> subordinates) {
        this.happy = happy;
        this.subordinates = subordinates;
    }

    public static ReturnData process(Employee x) {
        int yesX = x.happy;
        int noX = 0;
        if (x.subordinates.isEmpty()) {
            return new ReturnData(yesX, noX);
        } else {
            for (Employee next : x.subordinates) {
                ReturnData subTreeInfo = process(next);
                yesX += subTreeInfo.noHeadMax;
                noX += Math.max(subTreeInfo.yesHeadMax, subTreeInfo.noHeadMax);
            }
            return new ReturnData(yesX, noX);
        }
    }
}

class ReturnData {
    public int yesHeadMax;
    public int noHeadMax;

    public ReturnData(int yesHeadMax, int noHeadMax) {
        this.yesHeadMax = yesHeadMax;
        this.noHeadMax = noHeadMax;
    }
}
