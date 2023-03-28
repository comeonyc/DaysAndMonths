package hot;

/**
 * @author: yc_comeon
 * @date: 2023/3/27
 * @description: TODO
 **/
public class NumIslands_200 {
    public static void main(String[] args) {

    }

    public static int numIslands(char[][] grid) {
        int a = grid.length;
        int b = grid[0].length;

        int num = 0;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (grid[i][j] == '1') {
                    doVisited(grid, i, j, a, b);
                    num++;
                }
            }
        }

        return num;

    }

    private static void doVisited(char[][] grid, int i, int j, int a, int b) {
        if (i < 0 || j < 0 || i >= a || j >= b) {
            return;
        }

        if (grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';

        doVisited(grid, i + 1, j, a, b);
        doVisited(grid, i - 1, j, a, b);
        doVisited(grid, i, j + 1, a, b);
        doVisited(grid, i, j - 1, a, b);
    }
}
