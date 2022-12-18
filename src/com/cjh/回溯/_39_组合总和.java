package com.cjh.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 陈哈哈
 * @date 2022年12月18日 18:16
 * @description
 * @Data
 */
public class _39_组合总和 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return res;
        // 排序是剪枝的前提
        Arrays.sort(candidates);
        helper(candidates, target, 0);
        return res;
    }

    private void helper(int[] candidates, int target, int startIndex) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            // 剪枝操作，发现有大于target的元素直接不执行后面的循环
            if (candidates[i] > target) break;
            path.add(candidates[i]);
            helper(candidates, target - candidates[i], i);
            path.remove(path.size() - 1);
        }
    }
}
