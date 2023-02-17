package hot;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: yc_comeon
 * @date: 2023/2/17
 * @description: TODO
 **/
public class IsValid {
    public static void main(String[] args) {
        System.out.println(isValid("([)]"));
    }

    /**
     * 考虑下堆栈的实现
     */
    public static boolean isValid(String s) {
        List<Character> left = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if ('(' == c || '{' == c || '[' == c) {
                left.add(c);
                continue;
            }

            if (')' == c && left.size() > 0 && left.get(left.size() - 1) == '(') {
                left.remove(left.size() - 1);
            } else if (']' == c && left.size() > 0 && left.get(left.size() - 1) == '[') {
                left.remove(left.size() - 1);
            } else if ('}' == c && left.size() > 0 && left.get(left.size() - 1) == '{') {
                left.remove(left.size() - 1);
            } else {
                return false;
            }
        }
        return left.size() == 0;
    }

    /**
     * 数据结构的算法题 要有栈的意识
     */
    public static boolean isValidWithStack(String s){
        Stack<Character> left = new Stack<>();
        for (char c : s.toCharArray()) {
            if ('(' == c || '{' == c || '[' == c) {
                left.push(c);
                continue;
            }

            if (')' == c && left.size() > 0 && left.peek() == '(') {
                left.remove(left.size() - 1);
            } else if (']' == c && left.size() > 0 && left.peek() == '[') {
                left.remove(left.size() - 1);
            } else if ('}' == c && left.size() > 0 && left.peek() == '{') {
                left.remove(left.size() - 1);
            } else {
                return false;
            }
        }
        return left.isEmpty();
    }
}
