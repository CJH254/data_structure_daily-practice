package com.cjh.每日一题;

/**
 * @author 陈哈哈
 * @date 2023年01月01日 12:14
 * @description
 * @Data
 */
public class _2351_第一个出现两次的字母 {
    public static char repeatedCharacter(String s) {
        int mask = 0;
        // 每迭代到一个元素mask都会累加他们的ascii编码「因为是用或运算符」
        // 等到下一次遇到重复的字符时，mask就能匹配到重复的字符，此时该位置就为1
        for (char c : s.toCharArray()) {
            int t = 1 << (c - 'a');
            if ((mask & t) != 0) return c;
            mask |= t;
        }
        return 0;
    }

    public static void main(String[] args) {
        repeatedCharacter("abccbaacz");
    }
}
