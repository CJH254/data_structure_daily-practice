package com.cjh.并查集;

import java.util.Arrays;

/**
 * @author 陈哈哈
 * @date 2022年12月31日 00:03
 * @description
 * @Data
 */
public class _1697_检查边长长度限制的路径是否存在 {
    // 并查集
    private static int[] p;

    public static boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        // 初始化并查集
        p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);

        // queries并查集
        Integer[] qid = new Integer[queries.length];
        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            qid[i] = i;
        }
        // 这一步是为了让qid按照queries的顺序显示答案
        Arrays.sort(qid, (i, j) -> queries[i][2] - queries[j][2]);
        int edgeIndex = 0;
        for (int i : qid) {
            int a = queries[i][0], b = queries[i][1], limit = queries[i][2];
            // 拿queries[i]到edgeList去匹配满足条件的元素
            while (edgeIndex < edgeList.length && limit > edgeList[edgeIndex][2]) {
                int u = edgeList[edgeIndex][0], v = edgeList[edgeIndex][1];
                p[find(u)] = find(v);
                edgeIndex++;
            }
            // while循环后就是不满足条件的，然后通过并查集判断两个端点是否连通即可
            ans[i] = find(a) == find(b);
        }
        return ans;
    }

    private static int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        // 找到根节点
        return p[x];
    }

    public static void main(String[] args) {
        distanceLimitedPathsExist(3, new int[][]{{0, 1, 2}, {1, 2, 4}, {2, 0, 8}, {1, 0, 16}}, new int[][]{{0, 1, 2}, {0, 2, 5}});
    }
}
