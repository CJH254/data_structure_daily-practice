package com.cjh.回溯.子集问题;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 陈哈哈
 * @date 2022年12月18日 19:37
 * @description
 * @Data
 */
public class _491_递增子序列 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums == null && nums.length == 0) return result;
        // 这题因为不能排序，所以不能用数组简单的判断前一个元素是否相同
        // boolean[] visited = new boolean[nums.length];
        helper(nums, 0);
        return result;
    }

    private void helper(int[] nums, int startIndex) {
        if (path.size() >= 2) {
            result.add(new ArrayList<>(path));
        }
        // 相等的情况用set来排查掉了，因为不能排序，很难保证后续可能会有位置不对，但组合起来元素相等的情况发生，所以选择用set去重
        // set也不需要再回溯，只需要保持已添加的结果集即可
        Set<Integer> set = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            int currentVal = nums[i];
            // 将递增的条件用来过滤，不符合条件的不添加到结果集里
            if (!path.isEmpty() && currentVal < path.get(path.size() - 1) || set.contains(currentVal)) continue;
            set.add(currentVal);
            path.add(currentVal);
            helper(nums, i + 1);
            path.remove(path.size() - 1);
        }

    }
}
