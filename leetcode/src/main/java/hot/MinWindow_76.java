package hot;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: yc_comeon
 * @date: 2023/2/25
 * @description: TODO
 **/
public class MinWindow_76 {
    public static void main(String[] args) {
        System.out.println(minWindow("bba", "ab"));
    }

    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> maps = new HashMap<>();
        for (char c : t.toCharArray()) {
            maps.compute(c, (k, v) -> null == v ? 1 : v + 1);
        }

        Map<Character, Integer> tmp = new HashMap<>();
        int index = 0;
        //跳过前缀
        while (index < s.length() && !maps.containsKey(s.charAt(index))) {
            index++;
        }

        int left = index, start = 0, min = -1;
        while (index < s.length()) {
            if (maps.containsKey(s.charAt(index))) {
                tmp.compute(s.charAt(index), (k, v) -> null == v || 0 == v ? 1 : v + 1);
            }
            while (contain(maps, tmp)) {
                if (-1 == min || index - left + 1 < min) {
                    start = left;
                    min = index - left + 1;
                }

                tmp.computeIfPresent(s.charAt(left), (k, v) -> v - 1);
                left += 1;
                while (left < index && !maps.containsKey(s.charAt(left))) {
                    left++;
                }
            }
            index++;

        }

        return -1 != min ? s.substring(start, start + min) : "";
    }

    private static boolean contain(Map<Character, Integer> maps, Map<Character, Integer> tmp) {
        if (maps.size() != tmp.size()) {
            return false;
        }

        return maps.entrySet().stream().allMatch(entry -> tmp.containsKey(entry.getKey()) && tmp.get(entry.getKey()) >= entry.getValue());
    }
}
