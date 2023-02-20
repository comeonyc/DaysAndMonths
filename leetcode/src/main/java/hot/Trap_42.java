package hot;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author: yc_comeon
 * @date: 2023/2/19
 * @description: TODO
 **/
public class Trap_42 {
    public static void main(String[] args) {
        System.out.println(trapWithStack(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public static int trapWithHeight(int[] height) {
        int max = Arrays.stream(height).max().orElse(0);
        int result = 0;
        for (int i = 1; i <= max; i++) {
            boolean start = false;
            int tmp = 0;
            for (int j = 0; j < height.length; j++) {
                if (start && height[j] < i) {
                    tmp++;
                }

                if (height[j] >= i) {
                    start = true;
                    result += tmp;
                    tmp = 0;
                }
            }
        }
        return result;
    }

    public static int trapWithDp(int[] height) {
        int len = height.length;
        int[] maxLeft = new int[len];
        maxLeft[0] = height[0];
        for (int i = 1; i < len; i++) {
            maxLeft[i] = Math.max(height[i], maxLeft[i - 1]);
        }
        int[] maxRight = new int[len];
        maxRight[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            maxRight[i] = Math.max(height[i], maxRight[i + 1]);
        }

        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += (Math.min(maxLeft[i], maxRight[i]) - height[i]);
        }
        return sum;
    }

    public static int trapWithStack(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int result = 0, current = 0;
        while (current < height.length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int h = height[stack.pop()];
                if (!stack.isEmpty()) {
                    int min = Math.min(height[stack.peek()], height[current]);
                    result += (min - h) * (current - stack.peek() - 1);
                }
            }
            stack.push(current);
            current++;
        }
        return result;
    }
}
