package hot;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: yc_comeon
 * @date: 2023/2/7
 * @description: TODO
 **/
public class IntToRoma {
    public static void main(String[] args) {
        System.out.println(intToRomaWithEnum(1994));
    }

    /**
     * 1<= num <= 3999
     * <p>
     * 枚举填充法
     */
    public static String intToRomaWithEnum(int num) {
        String[] one = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] two = new String[]{"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] three = new String[]{"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};

        int flag = 1;
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.insert(0, getString(flag, num % 10, one, two, three));
            num /= 10;
            flag++;
        }
        return sb.toString();
    }

    /**
     * 贪心  按照标致符号从大到小排序 遍历 每次减最大的值即可 g
     */
    public static String intToRomaWithGreed(int num) {
        Map<Integer, String> maps = initMap();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, String> entry : maps.entrySet()) {
            while (num >= entry.getKey()) {
                sb.append(entry.getValue());
                num -= entry.getKey();
            }
        }
        return sb.toString();
    }

    private static Map<Integer, String> initMap() {
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
        return map;
    }

    private static String getString(int flag, int cur, String[] one, String[] two, String[] three) {
        if (cur == 0) {
            return "";
        }
        if (flag == 1) {
            return one[cur - 1];
        } else if (flag == 2) {
            return two[cur - 1];
        } else if (flag == 3) {
            return three[cur - 1];
        } else if (flag == 4) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cur; i++) {
                sb.append("M");
            }
            return sb.toString();
        } else {
            return "";
        }
    }
}
