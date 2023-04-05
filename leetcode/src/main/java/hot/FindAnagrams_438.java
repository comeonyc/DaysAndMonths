package hot;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yc_comeon
 * @date: 2023/4/3
 * @description: TODO
 **/
public class FindAnagrams_438 {
    /**
     * 滑动窗口
     *
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams(String s, String p) {
        int[] need = new int[26];
        for (char c : p.toCharArray()) {
            need[c - 'a']++;
        }

        int[] cur = new int[26];
        int left = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            cur[s.charAt(i) - 'a']++;
            if ((i - left + 1) == p.length()) {
                if (check(need, cur)) {
                    result.add(left);
                }
                cur[s.charAt(left++) - 'a']--;
            }
        }
        return result;

    }

    public static boolean check(int[] need, int[] cur) {
        for (int i = 0; i < 26; i++) {
            if (cur[i] < need[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }
}
