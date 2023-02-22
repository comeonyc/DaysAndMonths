package hot;

/**
 * @author: yc_comeon
 * @date: 2023/2/23
 * @description: TODO
 **/
public class MaxSubArray_53 {
    public static void main(String[] args) {
        System.out.println(maxSubArrayWithDp(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    /**
     * 分治法 还需要看看
     */
    public static int maxSubArrayWithDp(int[] nums) {
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] < nums[i]) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }

            max = Math.max(sum, max);
        }
        return max;
    }
}
