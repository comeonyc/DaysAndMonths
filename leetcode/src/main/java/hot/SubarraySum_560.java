package hot;

import java.util.HashMap;

/**
 * @author: yc_comeon
 * @date: 2023/3/29
 * @description: TODO
 **/
public class SubarraySum_560 {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{3, 4, 2, 3, 4}, 7));
    }

    /**
     * 前缀和的思路
     *
     * 当前所有的数加在一起，如果减去k值得到的数有对应的前缀，则相加即可
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
