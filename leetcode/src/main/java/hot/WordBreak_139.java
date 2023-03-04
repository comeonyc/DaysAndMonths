package hot;

import com.google.common.collect.Lists;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author: yc_comeon
 * @date: 2023/3/4
 * @description: TODO
 **/
public class WordBreak_139 {
    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", Lists.newArrayList("leet", "code")));
        System.out.println(wordBreak("applepenapple", Lists.newArrayList("apple", "pen")));
        System.out.println(wordBreak("catsandog", Lists.newArrayList("cats", "dog", "sand", "and", "cat")));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public static boolean wordBreak(String s, int index, List<String> wordDict) {
        if (index >= s.length()) {
            return true;
        }

        for (String prefix : wordDict) {
            if (s.startsWith(prefix, index) && wordBreak(s, index + prefix.length(), wordDict)) {
                return true;
            }
        }

        return false;
    }
}
