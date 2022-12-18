package com.cjh.回溯.子集问题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 陈哈哈
 * @date 2022年12月18日 18:43
 * @description
 * @Data
 */
public class _90_子集II {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null && nums.length == 0) return result;
        // 子集和子集II的区别在于前者的nums是不重复的，后者是重复的，所以后者才需要额外的数组进行判断重复的元素是否已经访问过了
        boolean[] visited = new boolean[nums.length];
        // 为了避免重复的子集，可以先对数组预先排序，当遇到相同的元素直接跳过即可
        Arrays.sort(nums);
        helper(visited, nums, 0);
        return result;
    }

    private void helper(boolean[] visited, int[] nums, int startIndex) {
        result.add(new ArrayList<>(path));
        if (startIndex == nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            // 避免重复子集，需要判断是否前面的元素相同
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            path.add(nums[i]);
            visited[i] = true;
            helper(visited, nums, i + 1);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
}
