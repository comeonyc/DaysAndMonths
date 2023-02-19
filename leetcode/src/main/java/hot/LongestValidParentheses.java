package hot;

import java.util.Stack;

/**
 * @author: yc_comeon
 * @date: 2023/2/19
 * @description: TODO
 **/
public class LongestValidParentheses {
    public static void main(String[] args) {
        System.out.println(longestValidParenthesesWithDp("()"));
    }

    //栈的思路 用栈容量代替（个数，存下标取最值  要有个初始容量标识
    public static int longestValidParentheses(String s) {
        if (null == s || s.length() <= 1) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < chars.length; i++) {
            if ('(' == chars[i]) {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    /**
     * 写dp方程要着重考虑上一层的条件
     */
    public static int longestValidParenthesesWithDp(String s) {
        if (null == s || s.length() <= 1) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int[] dp = new int[s.length()];
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == '(') {
                dp[i] = 0;
            } else {
                if (i - 1 >= 0 && chars[i - 1] == '(') {
                    dp[i] = i - 2 > 0 ? dp[i - 2] + 2 : 2;
                } else if (i - 1 >= 0 && chars[i - 1] == ')') {
                    /**
                     *     i-dp[i-1]-1   i-dp[i-1]     i-1  i
                     *         (            (           )   )
                     */
                    int last = i - dp[i - 1] - 1;
                    if (last >= 0 && chars[last] == '(') {
                        dp[i] = last - 1 > 0 ? dp[last - 1] : 0;
                        dp[i] += i - (i - dp[i - 1] - 1) + 1;
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
