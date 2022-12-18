package com.cjh.回溯.子集问题;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 陈哈哈
 * @date 2022年12月18日 18:43
 * @description
 * @Data
 */
public class _78_子集 {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null && nums.length == 0) {
            return result;
        }
        helper(nums, 0);
        return result;
    }

    private void helper(int[] nums, int startIndex) {
        result.add(new ArrayList<>(path));
        // 结束条件
        if (startIndex == nums.length - 1) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            helper(nums, i++);
            path.remove(path.size() - 1);
        }
    }
}
