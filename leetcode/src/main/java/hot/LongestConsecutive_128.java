package hot;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author: yc_comeon
 * @date: 2023/3/4
 * @description: TODO
 **/
public class LongestConsecutive_128 {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> sets = new HashSet<>(nums.length);
        for (int num : nums) {
            sets.add(num);
        }

        int max = 0;
        for (int num : nums) {
            if (sets.contains(num - 1)) {
                continue;
            }

            int total = 1;
            int cur = num;
            while (sets.contains(cur + 1)) {
                total++;
                cur += 1;
            }
            max = Math.max(total, max);
        }
        return max;
    }
}
