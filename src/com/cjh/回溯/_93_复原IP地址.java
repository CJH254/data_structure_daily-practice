package com.cjh.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 陈哈哈
 * @date 2022年12月18日 16:35
 * @description
 * @Data
 */
public class _93_复原IP地址 {
    List<String> result = new ArrayList<>();
    public static final int LEAGL_DOT_NUMBER = 3;

    // 遍历字符 -> 判断合法性 -> 拼接字符串 -> 添加结果集
    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) return result;
        helper(s, 0, 0);
        return result;
    }

    private void helper(String ip, int startIndex, int dotNumber) {
        // 完整的Ip地址是有3个.分割的，以此作为一个完整Ip的标识
        if (dotNumber == LEAGL_DOT_NUMBER) {
            // 最后一个部分需额外判断
            if (isIpAddress(ip, startIndex, ip.length() - 1)) {
                result.add(ip);
            }
            return;
        }
        for (int i = startIndex; i < ip.length(); i++) {
            if (isIpAddress(ip, startIndex, i)) {
                // 截取起始下标从0开始是为了直接获取'.'前面所有的地址
                ip = ip.substring(0, i + 1) + "." + ip.substring(i + 1);
                dotNumber++;
                // 不能直接dotNum++，因为回溯之后，剩下的for循环还需要用到dotNum
                helper(ip, i + 2, dotNumber);
                dotNumber--;
                ip = ip.substring(0, i + 1) + ip.substring(i + 2);
            } else {
                // 不合法的Ip地址没办法组成功一个完整的Ip,直接退出循环
                break;
            }
        }

    }

    private boolean isIpAddress(String s, int start, int end) {
        // 因为加了.之后可能会超过原来字符串的长度可能出现越界的情况
        if (start > end) return false;
        // start和end定位到字符串的只有一个字符并且为0的话就是非法情况
        if (s.charAt(start) == '0' && start != end) {
            return false;
        }
        // 用于累计ip，判断该数是否超过255
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) {
                return false;
            }
        }
        return true;
    }
}
