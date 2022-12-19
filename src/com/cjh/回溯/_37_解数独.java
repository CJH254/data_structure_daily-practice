package com.cjh.回溯;

/**
 * @author 陈哈哈
 * @date 2022年12月20日 00:16
 * @description
 * @Data
 */
public class _37_解数独 {
    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board);
    }

    private boolean solveSudokuHelper(char[][] board) {
        // 遍历row行col列数字的合法性
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                // 跳过原始数字
                if (board[row][col] != '.') {
                    continue;
                }
                for (char val = '1'; val <= '9'; val++) {
                    if (isValid(row, col, val, board)) {
                        // 填充一位合法的数字，看后续递归校验能否符合校验
                        board[row][col] = val;
                        // board[row][col]这一行选取了一个字符后就进行下一层填充，如果下一层无法填充返回false，并回溯该单元格值的选取
                        if (solveSudokuHelper(board)) {
                            return true;
                        }
                        board[row][col] = '.';
                    }
                }
                // 全部选完说明填充过的单元格经过校验后恢复到了原来的字符.
                return false;
            }
        }
        return true;
    }

    private boolean isValid(int row, int col, int val, char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == val) {
                return false;
            }
        }
        for (int j = 0; j < 9; j++) {
            if (board[j][col] == val) {
                return false;
            }
        }
        // 确定九宫格范围
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }
}
