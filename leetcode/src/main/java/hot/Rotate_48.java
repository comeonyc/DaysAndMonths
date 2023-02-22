package hot;

/**
 * @author: yc_comeon
 * @date: 2023/2/21
 * @description: TODO
 **/
public class Rotate_48 {
    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] b = new int[][]{{5,1,9,1},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate(b);
        System.out.println(b);
    }

    /**
     * 核心思路是看好边界值，进而能做到有效的计算
     *
     * 别干想 用笔画一画
     */
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int times = 0;
        while (times < n / 2) {
            int left = times;
            int right = n - 1 - times;
            int len = n - 1 - times - times;
            for (int i = 0; i < len; i++) {
                int tmp = matrix[left][left + i];
                matrix[left][left+i] = matrix[right-i][left];
                matrix[right-i][left] = matrix[right][right - i];
                matrix[right][right - i] = matrix[left+i][right];
                matrix[left+i][right] = tmp;
            }
            times++;
        }
    }

}
