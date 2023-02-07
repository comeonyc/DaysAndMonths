package hot;

/**
 * @author: yc_comeon
 * @date: 2023/2/7
 * @description: TODO
 **/
public class MyAtoi {
    public static void main(String[] args) {
        System.out.println(myAtoi("-91283472332"));
    }

    public static int myAtoi(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }

        int index = 0;
        int result = 0;
        boolean under = false;

        while (index < s.length() && (' ' == s.charAt(index))) {
            index++;
        }

        if (index < s.length() && isFlag(s, index)) {
            under = '-' == s.charAt(index);
            index++;
        }

        while (index < s.length() && isNumber(s, index)) {

            int cur = (int) s.charAt(index) - (int) '0';
            if (result == Integer.MAX_VALUE / 10) {
                if (under && cur >= 8) {
                    return Integer.MIN_VALUE;
                } else if (!under && cur >= 7) {
                    return Integer.MAX_VALUE;
                }
            } else if (result > Integer.MAX_VALUE / 10) {
                return under ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result = result * 10 + cur;
            index++;
        }

        return under ? (-1) * result : result;

    }

    private static boolean isNumber(String s, int index) {
        return s.charAt(index) >= '0' && s.charAt(index) <= '9';
    }

    public static boolean isFlag(String s, int index) {
        return s.charAt(index) == '+' || s.charAt(index) == '-';
    }
}
