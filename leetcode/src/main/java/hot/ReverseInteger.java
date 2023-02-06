package hot;

/**
 * @author: yc_comeon
 * @date: 2023/2/7
 * @description: TODO
 **/
public class ReverseInteger {
    public static void main(String[] args) {

    }

    /**
     * 关键点在于知道整数的范围 -2^15 ~ 2^15-1
     * @param x
     * @return
     */
    public static int reverse(int x) {
        if (x == 0 || x == Integer.MIN_VALUE) {
            return 0;
        }
        boolean flag = x < 0;
        int a = Math.abs(x);
        int result = 0;
        while (a > 0) {
            int cur = a % 10;
            if (result > Integer.MAX_VALUE / 10) {
                return 0;
            } else if (result == Integer.MAX_VALUE / 10) {
                if (flag && cur > 8) {
                    return 0;
                } else if (!flag && cur > 7) {
                    return 0;
                }
            }
            result = result * 10 + cur;
            a /= 10;
        }
        return flag ? (-1) * result : result;

    }
}
