package com.cjh.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 陈哈哈
 * @date 2022年12月18日 18:20
 * @description
 * @Data
 */
public class _216_组合总和III {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k < 1) return res;
        dfs(1, k, n);
        return res;
    }

    private void dfs(int startIndex, int k, int n) {
        if (n < 0) return;
        if (path.size() == k) {
            if (n == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            // startIndex+1的话会导致当前轮dfs不满足结果时，下一轮的startIndex会出现重复的情况
            dfs(i + 1, k, n - i);
            path.remove(path.size() - 1);
        }
    }
}
