package com.cjh.回溯.组合问题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 陈哈哈
 * @date 2022年12月18日 18:17
 * @description
 * @Data
 */
public class _40_组合总和II {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates != null && candidates.length == 0) return res;
        // 剪枝的前提
        Arrays.sort(candidates);
        // 数据源带有重复的元素
        boolean[] visited = new boolean[candidates.length];
        helper(visited, candidates, target, 0);
        return res;
    }

    private void helper(boolean[] visited, int[] candidates, int target, int startIndex) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 如果传startIndex开始的话，那就没办法组合到前面的元素了
        for (int i = startIndex; i < candidates.length; i++) {
            if (candidates[i] > target) break;
            if (i > 0 && candidates[i] == candidates[i - 1] &&  !visited[i - 1]) continue;
            visited[i] = true;
            path.add(candidates[i]);
            helper(visited, candidates, target - candidates[i], i + 1);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
}
