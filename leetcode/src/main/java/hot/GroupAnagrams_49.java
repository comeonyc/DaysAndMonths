package hot;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: yc_comeon
 * @date: 2023/2/22
 * @description: TODO
 **/
public class GroupAnagrams_49 {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> maps = new HashMap<>();
        for (String str : strs) {
            int[] a = new int[26];
            for (char c : str.toCharArray()) {
                a[c - 97]++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < a[i]; j++) {
                    sb.append(((char) i + 97));
                }
            }
            if (!maps.containsKey(sb.toString())) {
                maps.put(sb.toString(), new ArrayList<>());
            }
            maps.get(sb.toString()).add(str);
        }

        return new ArrayList<>(maps.values());
    }

}
