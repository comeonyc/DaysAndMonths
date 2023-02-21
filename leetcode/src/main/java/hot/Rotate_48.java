package hot;

/**
 * @author: yc_comeon
 * @date: 2023/2/21
 * @description: TODO
 **/
public class Rotate_48 {
    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(a);
        System.out.println(a);
    }

    public static void rotate(int[][] matrix) {
//        if(matrix.length == 0 || matrix.length != matrix[0].length) {
//            return;
//        }
//        int nums = matrix.length;
//        int times = 0;
//        while(times <= (nums >> 1)){
//            int len = nums - (times << 1);
//            for(int i = 0; i < len - 1; ++i){
//                int temp = matrix[times][times + i];
//                matrix[times][times + i] = matrix[times + len - i - 1][times];
//                matrix[times + len - i - 1][times] = matrix[times + len - 1][times + len - i - 1];
//                matrix[times + len - 1][times + len - i - 1] = matrix[times + i][times + len - 1];
//                matrix[times + i][times + len - 1] = temp;
//            }
//            ++times;
//        }
        int n = matrix.length;
        int times = 0;
        while (times < n / 2) {
            int left = times;
            int right = n - 1 - times;
            int len = right - left - 1;
            for (int i = 0; i < len; i++) {
                int tmp = matrix[left][i];
                matrix[left][i] = matrix[i][right - i];
                matrix[i][right - i] = matrix[right - i][right - i];
                matrix[right - i][right - i] = matrix[i][right - i];
                matrix[i][right - i] = tmp;
            }
            times++;
        }
    }

}
