package com.cjh.回溯;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class _332_重新安排行程 {

    List<String> result = new LinkedList<>();
    HashMap<String, PriorityQueue<String>> airlineInfomation = new HashMap<>();

    // 构造图，key是始发地，value是目的地，目的地用PriorityQueue存放，确保元素升序排序
    public List<String> findItinerary(List<List<String>> tickets) {
        if (tickets == null || tickets.size() == 0) {
            return result;
        }
        // 构建航班信息（构建邻接表）
        for (List<String> ticket : tickets) {
            String src = ticket.get(0), desc = ticket.get(1);
            if (!airlineInfomation.containsKey(src)) {
                // 题目要求按字典排序，所以用优先队列
                airlineInfomation.put(src, new PriorityQueue<String>());
            }
            airlineInfomation.get(src).offer(desc);
        }
        dfs("JFK");
        // 题目要求一律从JFK开始，只需反转结果即可
        Collections.reverse(result);
        return result;
    }

    /* [站点2，站点3],[站点1，站点2],[站点4，站点5],[站点3，站点4]
       构建航班信息<起始站点,List<经过的终点站点队列>>
       站点1:站点2
       站点2:站点3
       站点3:站点4
       站点4:站点5
       站点5:空，证明站点5是最后的终点站点
    */
    private void dfs(String src) {
        // 不断移除始发站点行程里的站点，当行程里的站点数量只剩下一个时，则证明该站点点可以当起始站点。
        while (airlineInfomation.containsKey(src) && airlineInfomation.get(src).size() >= 1) {
            String desc = airlineInfomation.get(src).poll();
            dfs(desc);
        }
        result.add(src);
    }

}
