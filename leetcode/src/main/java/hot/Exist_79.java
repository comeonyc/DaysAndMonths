package hot;

/**
 * @author: yc_comeon
 * @date: 2023/2/26
 * @description: TODO
 **/
public class Exist_79 {
    public static void main(String[] args) {
        System.out.println(
                exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCESEEEFS"));

//        System.out.println(
//                exist(new char[][]{{'a'}}, "a"));
    }

    /**
     * dfs+回溯思路
     */
    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (find(board, word, 0, i, m, j, n, null)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean find(char[][] board, String word, int index, int a, int m, int b, int n, boolean[][] search) {
        if (word.charAt(index) != board[a][b]) {
            return false;
        }

        if (index + 1 == word.length()) {
            return true;
        }

        if (index == 0) {
            search = new boolean[m][n];
        }
        search[a][b] = true;
        boolean left = b - 1 >= 0 && !search[a][b - 1] && find(board, word, index + 1, a, m, b - 1, n, search);
        boolean right = b + 1 < n && !search[a][b + 1] && find(board, word, index + 1, a, m, b + 1, n, search);
        boolean up = a - 1 >= 0 && !search[a - 1][b] && find(board, word, index + 1, a - 1, m, b, n, search);
        boolean down = a + 1 < m && !search[a + 1][b] && find(board, word, index + 1, a + 1, m, b, n, search);
        search[a][b] = false;
        return left || right || up || down;
    }
}
