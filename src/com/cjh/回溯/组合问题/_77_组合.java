package com.cjh.回溯.组合问题;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 陈哈哈
 * @date 2022年12月18日 18:22
 * @description
 * @Data
 */
public class _77_组合 {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n < 1 || k < 1) {
            return res;
        }
        dfs(1, n, k);
        return res;
    }

    private void dfs(int startIndex, int n, int k) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        // DFS如果结果是不重复的就需要传入一个startIndex保存当前下标
        // n - (k - path.size()) + 1为剪枝操作，当该元素后的元素没办法组成一个符合条件的结果集就直接退出
        // 例：n = 9，k = 3，在1~9范围内组成3个元素的结果集：若已选择2个，那么9 - （3 - 2）+ 1 = 7，证明7以后的元素是没办法组合成结果集的
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            dfs(i + 1, n, k);
            path.remove(path.size() - 1);
        }
    }
}
