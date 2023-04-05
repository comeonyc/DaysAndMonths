package hot;

import java.util.*;

/**
 * @author: yc_comeon
 * @date: 2023/4/5
 * @description: TODO
 **/
public class TopKFrequent_347 {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer> a = new ArrayList<>(map.keySet());
        quickSort(a, 0, a.size() - 1, map);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = a.get(i);
        }
        return result;

    }

    public static void quickSort(List<Integer> nums, int left, int right, Map<Integer, Integer> map) {
        if (left >= right) {
            return;
        }

        int n = map.get(nums.get(left));
        int l = left, r = right;
        while (l < r) {
            while (l < r && map.get(nums.get(r)) <= n) {
                r--;
            }
            while (l < r && map.get(nums.get(l)) >= n) {
                l++;
            }

            Collections.swap(nums, l, r);
        }
        Collections.swap(nums, l, left);
        quickSort(nums, left, l - 1, map);
        quickSort(nums, l + 1, right, map);
    }

    public static void main(String[] args) {
        System.out.println(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
    }
}
