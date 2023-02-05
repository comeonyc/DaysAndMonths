package hot;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: yc_comeon
 * @date: 2023/2/5
 * @description: TODO
 **/
public class NConvert {
    public static void main(String[] args) {
        String output = convert("AB", 1);
        if ("AB".equals(output)) {
            System.out.println("测试通过");
        } else {
            System.out.println("测试失败");
        }
    }

    /**
     * N字形转化
     *
     * 先存储下每一行要存储的内容，然后区分上游和下游即可
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        if (null == s || s.length() <= numRows || numRows==1) {
            return s;
        }
        Map<Integer, StringBuilder> cache = new HashMap<>(numRows);
        boolean down = true;
        int index = 1;
        for (char c : s.toCharArray()) {
            if (!cache.containsKey(index)) {
                cache.put(index, new StringBuilder());
            }
            cache.get(index).append(c);

            if (down && index == numRows) {
                down = false;
            } else if (!down && index == 1) {
                down = true;
            }

            index = down ? index + 1 : index - 1;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= numRows; i++) {
            result.append(cache.get(i).toString());
        }
        return result.toString();
    }
}
