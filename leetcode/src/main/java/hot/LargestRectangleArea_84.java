package hot;

import java.util.Stack;

/**
 * @author: yc_comeon
 * @date: 2023/2/26
 * @description: TODO
 **/
public class LargestRectangleArea_84 {
    public static void main(String[] args) {
        System.out.println(largestRectangleAreaWithStack(new int[]{2, 4}));
    }

    public static int largestRectangleAreaWithStack(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int length = heights.length;
        int[] left = new int[length];
        int[] right = new int[length];
        for (int i = 0; i < length; i++) {
            int cur = heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] >= cur) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = length - 1; i >= 0; i--) {
            int cur = heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] >= cur) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? length  : stack.peek() ;
            stack.push(i);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            max = Math.max(max, heights[i] * (right[i] - left[i] - 1));
        }
        return max;
    }

    public static int largestRectangleArea(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int left = i;
            int min = Integer.MAX_VALUE;
            while (left >= 0 && heights[left] > 0) {
                min = Math.min(heights[left], min);
                max = Math.max(min * (i - left + 1), max);
                left--;
            }
        }
        return max;
    }
}
