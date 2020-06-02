package com.wang.forkJoin;

import java.util.concurrent.RecursiveTask;

/**
 * @Description: 求和计算
 * ForkJoin
 * stream并行计算
 * ForkJoin如何使用
 * 1、forkjoinPool 通过它来执行
 * 2、计算任务 forkjoinPool.execute(ForkJoinTask task)
 * 3、计算类继承ForkJoinTask
 * @Author: wangyinghao_sx
 * @Date: 2020-05-25 15:04
 **/
public class Demo extends RecursiveTask<Long> {
    public Long start;
    public Long end;
    public Long temp = 10000L;

    public Demo(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (start - end < temp) {
            Long sum = 0L;
            for (Long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            //forkjoin
            long mid = (start + end) / 2;
            Demo task1 = new Demo(start, mid);
            task1.fork(); //拆分任务 把任务压入线程队列
            Demo task2 = new Demo(mid, end);
            task2.fork();
            return task1.join() + task2.join();
        }
    }
}
