package week03;

import java.util.List;

public class LeetCode51 {

    public List<List<String>> solveNQueens(int n) {
        if (n == 1) {
            //return 1;
        }
        return null;

    }
    // .与Q的组合
    // new String[16]{".", ...}
    // [4][4]
    // Q=[1][1],
    // [1][...]
    // [...][1]
    // [0][0],[1][1],[2][2],[3][3]
    // [1][2]
    // [0][0],[0][2],[2][0]


    public static void main(String[] args) {
        int[][] s = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                s[i][j] = i * j;
                System.out.print("[" + i + "][" + j + "]" + "\t");
            }
            System.out.println();
            System.out.println();
        }

/*
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //[i - 1][j + 1]
                //[i + 1][j - 1]
                //[i - 1][j - 1]
                //[i + 1][j + 1]
                //[i - 1][j    ]
                //[i + 1][j    ]
                //[i    ][j - 1]
                //[i    ][j + 1]
            }
        }
*/

    }
}
