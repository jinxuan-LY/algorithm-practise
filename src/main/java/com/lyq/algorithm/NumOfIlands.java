package com.lyq.algorithm;

/**
 * @author yuanqiang.liao
 * @description 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * [["1","1","1"],
 * ["0","1","0"],
 * ["1","1","1"]]
 * @createTime 2023-03-07 15:34:00
 */
public class NumOfIlands {

    private static void dfs(char[][] chars, int r, int c) {
        if (r < 0 || r >= chars.length || c < 0 || c >= chars[0].length || chars[r][c] == '0') {
            return;
        }
        chars[r][c] = '0';
        dfs(chars, r - 1, c);  // 可能有拐弯的情况
        dfs(chars, r + 1, c);
        dfs(chars, r, c - 1);
        dfs(chars, r, c + 1);
    }

    public static int numOfIlands(char[][] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }

        int num = 0;
        for (int r = 0; r < chars.length; r++) {
            for (int c = 0; c < chars[0].length; c++) {
                if (chars[r][c] == '1') {
                    dfs(chars, r, c);
                    num++;
                }
            }
        }
        return num;
    }
}
