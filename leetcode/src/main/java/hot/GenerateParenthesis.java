package hot;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yc_comeon
 * @date: 2023/2/18
 * @description: TODO
 **/
public class GenerateParenthesis {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        get(result, new StringBuilder(), n, n);
        return result;
    }

    public static void get(List<String> result, StringBuilder sb, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(sb.toString());
            return;
        }

        if (left > right) {
            return;
        }

        if (left > 0) {
            sb.append("(");
            get(result, sb, left - 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (right > 0) {
            sb.append(")");
            get(result, sb, left, right - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
