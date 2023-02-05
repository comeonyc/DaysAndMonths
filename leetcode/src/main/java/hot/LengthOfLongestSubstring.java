package hot;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: yc_comeon
 * @date: 2023/2/4
 * @description: TODO
 **/
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        int i = lengthOfLongestSubstringWithHashSet("abba");
        System.out.println(i);
    }

    /**
     * 主要思路：用hashmap存储子串中已有的字符，left为左标记，标记最长子串的最左位置
     * 优点：时间快。相比于用set维护子串来说，不用重复的remove操作
     * 缺点：相对来说空间复杂度可能会更高一点
     * <p>
     * 1、如果map中存在当前字符，判断这个字符最早出现的位置与当前left的大小
     * *如果比left小则说明目前的子串中没有该字符
     * *如果比left大则说明目前的子串中已经包含了该字符，要讲left的位置替换为这个字符的下一个
     * 2、当前下标减去left在加1就是这个子串的长度
     * 3、一直维护长度的最大值即可
     */
    public static int lengthOfLongestSubstring(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> flag = new HashMap<>(s.length());
        int left = 0, result = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (flag.containsKey(chars[i])) {
                //此时代表有重复数字
                left = Math.max(left, flag.get(chars[i]) + 1);
            }
            result = Math.max(result, i - left + 1);
            flag.put(chars[i], i);
        }
        return result;
    }

    /**
     * 用Hashset存储子串，遇到重复字符串开始remove，直至子串内部元素的唯一性
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstringWithHashSet(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }

        int left = 0, right = 0, result = 0;
        Set<Character> substring = new HashSet<>();
        while (right < s.length()) {
            char cur = s.charAt(right);
            while (left < right && substring.contains(cur)) {
                substring.remove(s.charAt(left));
                left++;
            }
            substring.add(cur);
            result = Math.max(substring.size(), result);
            right++;
        }
        return result;
    }
}
