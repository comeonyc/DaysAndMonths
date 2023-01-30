package hot;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yc_comeon
 * @date 2023/1/30
 * @description hot 1.两数之和
 **/
public class TwoNumberSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(sum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(sum(new int[]{3, 3}, 6)));
    }

    /**
     * 时间换空间是必要的
     * @param nums 数组
     * @param target 目标值
     * @return 返回对应的下标
     */
    public static int[] sum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (map.containsKey(need)) {
                return new int[]{i, map.get(need)};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
