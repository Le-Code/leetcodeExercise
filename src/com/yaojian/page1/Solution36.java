package com.yaojian.page1;

import com.yaojian.Solution;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 *
 * 上图是一个部分填充的有效的数独。
 *
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 */
public class Solution36 implements Solution {
    @Override
    public void solution() {
        char[][] board = new char[][] {
          {'8','3','.','.','7','.','.','.','.'},
          {'6','.','.','1','9','5','.','.','.'},
          {'.','9','8','.','.','.','.','6','.'},
          {'8','.','.','.','6','.','.','.','3'},
          {'4','.','.','8','.','3','.','.','1'},
          {'7','.','.','.','2','.','.','.','6'},
          {'.','6','.','.','.','.','2','8','.'},
          {'.','.','.','4','1','9','.','.','5'},
          {'.','.','.','.','8','.','.','7','9'}
        };
                
        System.out.println(isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {
        int[]arr = new int[10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (arr[board[i][j] - '0'] != 0) {
                    return false;
                }
                arr[board[i][j] - '0'] = 1;
            }
            for (int k = 0; k < 10; k++) {
                arr[k] = 0;
            }
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                if (arr[board[j][i] - '0'] != 0) {
                    return false;
                }
                arr[board[j][i] - '0'] = 1;
            }
            for (int k = 0; k < 10; k++) {
                arr[k] = 0;
            }
        }
        for (int slice = 0; slice < 3; slice++) {
            for (int slice2 = 0; slice2 < 3; slice2++) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (board[slice * 3 + i][slice2 * 3 + j] == '.') {
                            continue;
                        }
                        if (arr[board[slice * 3 + i][slice2 * 3 + j] - '0'] != 0) {
                            return false;
                        }
                        arr[board[slice * 3 + i][slice2 * 3 + j] - '0'] = 1;
                    }
                }
                for (int i = 0; i < 10; i++) {
                    arr[i] = 0;
                }
            }

        }
        return true;
    }
}
