package hot;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: yc_comeon
 * @date: 2023/4/5
 * @description: TODO
 **/
public class DecodeString_394 {
    public static String decodeString(String s) {
        return recurrence(s, new AtomicInteger(0));
    }

    public static String recurrence(String s, AtomicInteger index) {
        if (index.get() >= s.length() || ']' == s.charAt(index.get())) {
            return "";
        }

        char c = s.charAt(index.get());
        if (Character.isDigit(c)) {
            int num = 0;
            while (index.get() < s.length() && Character.isDigit(s.charAt(index.get()))) {
                num = num * 10 + Integer.parseInt(String.valueOf(s.charAt(index.get())));
                index.incrementAndGet();
            }

            //此时index是'['
            index.incrementAndGet();
            String repeat = recurrence(s, index);
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= num; i++) {
                sb.append(repeat);
            }
            index.incrementAndGet();
            return sb.toString() + recurrence(s, index);

        } else {
            index.incrementAndGet();
            return String.valueOf(c) + recurrence(s, index);
        }
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
    }
}
