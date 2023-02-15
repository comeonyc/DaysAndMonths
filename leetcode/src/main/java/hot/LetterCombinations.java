package hot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: yc_comeon
 * @date: 2023/2/16
 * @description: TODO
 **/
public class LetterCombinations {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {
        if (null == digits || digits.length() == 0) {
            return new ArrayList<>(0);
        }

        List<String> result = new ArrayList<>();
        letterCombinations(digits, 0, initMap(), new StringBuilder(), result);
        return result;

    }

    /**
     * 要想到空间复杂度的问题
     */
    public static void letterCombinations(String digits, int index, Map<Character, String[]> map, StringBuilder sb, List<String> result) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }

        for (String s : map.get(digits.charAt(index))) {
            sb.append(s);
            letterCombinations(digits, index+1, map, sb, result);
            sb.deleteCharAt(index);
        }
    }

    public static List<String> letterCombinations(String digits, int index, Map<Character, String[]> map) {
        if (index >= digits.length()) {
            return new ArrayList<>(0);
        }

        List<String> result = new ArrayList<>();
        for (String s : map.get(digits.charAt(index))) {
            List<String> strings = letterCombinations(digits, index + 1, map);
            if (strings.size() == 0) {
                result.add(s);
            } else {
                strings.stream().map(x -> s + x).forEach(result::add);
            }
        }
        return result;

    }

    public static Map<Character, String[]> initMap() {
        Map<Character, String[]> map = new HashMap<>(8);
        map.put('2', new String[]{"a", "b", "c"});
        map.put('3', new String[]{"d", "e", "f"});
        map.put('4', new String[]{"h", "i", "g"});
        map.put('5', new String[]{"j", "k", "l"});
        map.put('6', new String[]{"n", "m", "o"});
        map.put('7', new String[]{"p", "q", "r", "s"});
        map.put('8', new String[]{"t", "u", "v"});
        map.put('9', new String[]{"w", "x", "y", "z"});
        return map;
    }
}
