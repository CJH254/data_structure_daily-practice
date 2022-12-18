package com.cjh.回溯.排列问题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 陈哈哈
 * @date 2022年12月19日 01:02
 * @description
 * @Data
 */
public class _47_全排列II {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums != null && nums.length == 0) return result;
        // 去重的前提
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        helper(nums, visited);
        return result;
    }

    private void helper(int[] nums, boolean[] visited) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 上一次函数调用中相同且使用过的元素不要「相当于树根」，使用过的元素会置为false故!visited[i]
            if (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) continue;
            // 同一层遍历里没使用过的元素才进行排列,没有这一层判断的话就会出现重复的排列
            if (visited[i]) continue;
            visited[i] = true;
            path.add(nums[i]);
            helper(nums, visited);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
}
