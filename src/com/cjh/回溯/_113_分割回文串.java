package com.cjh.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 陈哈哈
 * @date 2022年12月18日 16:39
 * @description
 * @Data
 */
public class _113_分割回文串 {
    List<String> path = new ArrayList<>();
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if (s == null && s.length() == 0) {
            return res;
        }
        helper(s, 0);
        return res;
    }

    private void helper(String s, int startIndex) {
        // 说明所有字符串都遍历完了
        if (startIndex == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            // 是回文串的话直接加进去，不需要弄字符串拼接，直接截取即可
            if (isPalindrome(s, startIndex, i)) {
                path.add(s.substring(startIndex, i + 1));
                helper(s, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    // 字符串start到end区间是否为回文串
    private boolean isPalindrome(String s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
