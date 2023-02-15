package hot;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: yc_comeon
 * @date: 2023/2/15
 * @description: TODO
 **/
public class RomaToInt {
    public static void main(String[] args) {
        System.out.println(romaToIn("MCMXCIV"));
    }

    private static int romaToIn(String s) {
        Map<String, Integer> maps = initMap();

        int result = 0;
        int index = 0;
        for (Map.Entry<String, Integer> entry : maps.entrySet()) {
            String key = entry.getKey();
            int length = key.length();
            while (index < s.length() && s.startsWith(key, index)) {
                result += entry.getValue();
                index += length;

            }
        }
        return result;
    }

    private static int romaToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if ('I' == cur) {
                if (i + 1 < s.length() && 'V' == s.charAt(i + 1)) {
                    result += 4;
                    i++;
                } else if (i + 1 < s.length() && 'X' == s.charAt(i + 1)) {
                    result += 9;
                    i++;
                } else {
                    result += 1;
                }
            } else if ('V' == cur) {
                result += 5;
            } else if ('X' == cur) {
                if (i + 1 < s.length() && 'L' == s.charAt(i + 1)) {
                    result += 40;
                    i++;
                } else if (i + 1 < s.length() && 'C' == s.charAt(i + 1)) {
                    result += 90;
                    i++;
                } else {
                    result += 10;
                }
            } else if ('L' == cur) {
                result += 50;
            } else if ('C' == cur) {
                if (i + 1 < s.length() && 'D' == s.charAt(i + 1)) {
                    result += 400;
                    i++;
                } else if (i + 1 < s.length() && 'M' == s.charAt(i + 1)) {
                    result += 900;
                    i++;
                } else {
                    result += 100;
                }
            } else if ('D' == cur) {
                result += 500;
            } else if ('M' == cur) {
                result += 1000;
            } else {
                result += 0;
            }
        }
        return result;
    }

    private static Map<String, Integer> initMap() {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);
        return map;
    }
}
