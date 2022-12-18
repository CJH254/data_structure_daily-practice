package com.cjh.回溯.组合问题;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 陈哈哈
 * @date 2022年12月18日 16:36
 * @description
 * @Data
 */
public class _17_电话号码的组合 {

    // 获取digits的位数 -> 获取位数的元素进行组合
    StringBuilder builder = new StringBuilder();
    List<String> res = new ArrayList<>();
    private static final String[] letters =
            {"","", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return res;
        helper(0, digits, digits.length());
        return res;
    }

    // startIndex是为了定位source字符串中的元素
    // startIndex在一次函数调用时传进来就是那个数，所以在同一个函数内的for循环startIndex是一直不会变的
    private void helper(int startIndex, String source, int len) {
        if (builder.length() == len) {
            res.add(builder.toString());
            return;
        }
        int position = source.charAt(startIndex) - '0';
        char[] letter = letters[position].toCharArray();
        // 剪枝的考虑点是：是否要将所有的元素都进行一次组合，如果不需要，当达到组合的下限条件时就可以退出了。
        for (int i = 0; i < letter.length; i++) {
            builder.append(letter[i]);
            helper(startIndex + 1, source, len);
            // 该次循环组合过之后就把这个元素删除掉，避免重复组合的出现
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
