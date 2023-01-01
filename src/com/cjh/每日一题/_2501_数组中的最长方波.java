package com.cjh.每日一题;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 陈哈哈
 * @date 2022年12月31日 11:45
 * @description
 * @Data
 */
public class _2501_数组中的最长方波 {
    public static int longestSquareStreak(int[] nums) {
        if (nums != null && nums.length < 2) return -1;
        Arrays.sort(nums);
        Map<Integer, Integer> dp = new HashMap<>();
        for (int num : nums)
            dp.put(num, 1);

        // 题目说除第一个元素外，每个元素是前一个元素的平方，所以可以先把第一个元素加进结果集里
        int ans = 1;
        for (int i = 1; i < nums.length; i++) {
            double sqrt = Math.sqrt(nums[i]);
            // 避免开方后出现小数的情况，这个小数是不存在结果集里的
            if ((int) sqrt == sqrt) {
                dp.put(nums[i], dp.getOrDefault((int) sqrt, 0) + 1);
                ans = Math.max(ans, dp.get(nums[i]));
            }
        }
        return ans >= 2 ? ans : -1;
    }

    public static void main(String[] args) {
        longestSquareStreak(new int[]{4, 3, 6, 16, 8, 2});
    }
}
