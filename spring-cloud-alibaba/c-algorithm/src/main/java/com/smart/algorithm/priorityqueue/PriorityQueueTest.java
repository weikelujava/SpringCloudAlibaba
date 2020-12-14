package com.smart.algorithm.priorityqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @version V1.0
 * @title: PriorityQueueTest
 * @description: 优先级队列
 * @author: lukewei
 * @date: 2020-12-07 13:47
 * @remark: 修改内容
 */
public class PriorityQueueTest {


    static class PriorityTop extends PriorityQueue<PriorityTop.Top> {

        static class Top implements Comparable<Top> {
            String searchName;
            Integer searchCount;

            public Top() {
            }

            public Top(String searchName, Integer searchCount) {
                this.searchName = searchName;
                this.searchCount = searchCount;
            }

            public int compareTo(Top top) {
                if (searchCount < top.searchCount) {
                    return 1;
                } else if (searchCount > top.searchCount) {
                    return -1;
                } else {
                    return 0;
                }
            }

            @Override
            public String toString() {
                return "Top{" +
                        "searchName='" + searchName + '\'' +
                        ", searchCount=" + searchCount +
                        '}';
            }
        }

        public void add(String str, int priority) {
            super.add(new Top(str, priority));
        }
    }

    public static void main(String[] args) {

        PriorityTop priorityTop = new PriorityTop();
        priorityTop.add("冬奥会", 50);
        priorityTop.remove("冬奥会");
        priorityTop.remove();
        priorityTop.add("冬奥会", 60);
        priorityTop.add("冬奥会2", 70);
        priorityTop.add("冬奥会3", 40);
        priorityTop.add("冬奥会4", 10);
        priorityTop.add("冬奥会5", 20);
        priorityTop.add("滑雪", 20);
//        while (!priorityTop.isEmpty()) {
//            System.out.println(priorityTop.poll() + " ");
//        }
        List<PriorityTop.Top> list = new ArrayList<>();
        if(!priorityTop.isEmpty()){
            for (int i = 0; i < 3; i++) {
                PriorityTop.Top result = priorityTop.poll();
                System.out.println(result);
                list.add(result);

            }
            for (PriorityTop.Top top : list) {
                priorityTop.add(top.searchName,top.searchCount);
            }
        }

        System.out.println(priorityTop);


    }
}
