package hot;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: yc_comeon
 * @date: 2023/4/5
 * @description: TODO
 **/
public class RemoveInvalidParentheses_301 {
    public static List<String> removeInvalidParentheses(String s) {
        int leftRemove = 0, rightRemove = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('(' == c) {
                leftRemove++;
            } else if (')' == c) {
                if (leftRemove == 0) {
                    rightRemove++;
                } else {
                    leftRemove--;
                }
            }

        }

        Set<String> result = new HashSet<>();
        dfs(s, 0, leftRemove, rightRemove, new StringBuffer(), result);
        return new ArrayList<>(result);
    }

    private static void dfs(String s, int index, int leftRemove, int rightRemove, StringBuffer sb, Set<String> result) {
        if (index == s.length()) {
            if (isValid(sb.toString())) {
                result.add(sb.toString());
            }
            return;
        }

        char c = s.charAt(index);
        if ('(' == c) {
            sb.append(c);
            dfs(s, index + 1, leftRemove, rightRemove, sb, result);
            sb.deleteCharAt(sb.length() - 1);

            if (leftRemove > 0) {
                dfs(s, index + 1, leftRemove - 1, rightRemove, sb, result);
            }
        } else if (')' == c) {
            sb.append(c);
            dfs(s, index + 1, leftRemove, rightRemove, sb, result);
            sb.deleteCharAt(sb.length() - 1);

            if (rightRemove > 0) {
                dfs(s, index + 1, leftRemove, rightRemove - 1, sb, result);
            }
        } else {
            sb.append(c);
            dfs(s, index + 1, leftRemove, rightRemove, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }


    }

    private static boolean isValid(String s) {
        int left = 0;
        for (char c : s.toCharArray()) {
            if ('(' == c) {
                left++;
            } else if (')' == c) {
                if (left > 0) {
                    left--;
                } else {
                    return false;
                }
            }
        }
        return left == 0;
    }

    public static void main(String[] args) {
        System.out.println(removeInvalidParentheses("()())()"));
    }
}
