package com.cjh.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 陈哈哈
 * @date 2022年12月19日 23:06
 * @description
 * @Data
 */
public class _51_N皇后 {
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        if (n == 0) return result;
        char[][] chessboard = new char[n][n];
        // 给二维数组填符号，因为.号占大多数，碰到皇后只需要设置当前的下标为Q即可
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }
        helper(n, 0, chessboard);
        return result;
    }

    private void helper(int n, int row, char[][] chessboard) {
        if (row == n) {
            result.add(array2List(chessboard));
            return;
        }
        // 每一次递归调用都会尝试在当行标识一个Q
        for (int col = 0; col < n; col++) {
            if (isValid(row, col, n, chessboard)) {
                // 回溯的行为主要在标识皇后的位置上
                chessboard[row][col] = 'Q';
                helper(n, row + 1, chessboard);
                chessboard[row][col] = '.';
            }
        }
    }

    private boolean isValid(int row, int col, int n, char[][] chessboard) {
        // 校验列
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }
        // 校验45度
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        // 校验135度
        for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private List<String> array2List(char[][] chessboard) {
        List<String> list = new ArrayList<>();
        for (char[] chars : chessboard) {
            list.add(String.copyValueOf(chars));
        }
        return list;
    }
}
