package hot;

/**
 * @author: yc_comeon
 * @date: 2023/3/20
 * @description: TODO
 **/
public class MaxProduct_152 {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{-4, -3, -2}));
    }

    public static int maxProduct(int[] nums) {
        int min = nums[0], max = nums[0], result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int max1 = max, min1 = min;
            max = Math.max(max1 * nums[i], Math.max(nums[i], min1 * nums[i]));
            min = Math.min(min1 * nums[i], Math.min(nums[i], max1 * nums[i]));
            result = Math.max(max, result);
        }
        return result;
    }
}
