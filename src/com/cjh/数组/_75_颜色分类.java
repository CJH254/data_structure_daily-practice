package com.cjh.数组;

/**
 * @author 陈哈哈
 * @date 2022年12月18日 16:35
 * @description
 * @Data
 */
public class _75_颜色分类 {
    public void sortColors(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int privot = 0;
        int ZERO = 0;
        int TWO = nums.length - 1;
        // 核心要点在于颜色只有三种
        while (privot <= TWO) {
            if (nums[privot] == 0) {
                swap(nums, ZERO, privot);
                privot++;
                ZERO++;
            } else if (nums[privot] == 1) {
                privot++;
            } else {
                swap(nums, privot, TWO--);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
