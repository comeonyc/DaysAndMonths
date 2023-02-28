package hot;

import java.util.Stack;

/**
 * @author: yc_comeon
 * @date: 2023/3/1
 * @description: TODO
 **/
public class MaximalRectangle_85 {
    public static void main(String[] args) {
        System.out.println(maximalRectangle(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}));
    }

    public static int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] height = new int[n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            gene(matrix, i, height);
            max = Math.max(max, getMax(height));
        }
        return max;
    }

    private static void gene(char[][] matrix, int level, int[] last) {
        char[] chars = matrix[level];

        for (int i = 0; i < chars.length; i++) {
            if (matrix[level][i] == '0') {
                last[i] = 0;
            } else {
                last[i] += 1;
            }
        }
    }

    public static int getMax(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = height.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? height.length : stack.peek();
            stack.push(i);
        }
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            max = Math.max(max, height[i] * (right[i] - left[i] - 1));
        }
        return max;
    }
}
