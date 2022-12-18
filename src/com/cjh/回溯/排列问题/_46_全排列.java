package com.cjh.回溯.排列问题;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 陈哈哈
 * @date 2022年12月19日 01:01
 * @description
 * @Data
 */
public class _46_全排列 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    // 46和47的全排列区别也是在于对重复数据源的判断，前者为不重复，可直接判断是否使用过
    // 后者为重复，需要分两部判断 -> 1.上一层是否使用过 2.当前层是否使用过 | 满足这两点的元素才可以组合成全排列
    public List<List<Integer>> permute(int[] nums) {
        if (nums != null && nums.length == 0) return result;
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
            if (visited[i]) continue;
            visited[i] = true;
            path.add(nums[i]);
            helper(nums, visited);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
}
