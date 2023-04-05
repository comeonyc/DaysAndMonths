package hot;

/**
 * @author: yc_comeon
 * @date: 2023/4/1
 * @description: TODO
 **/
public class ProductExceptSelf_238 {
    public static void main(String[] args) {

    }

    /**
     * 左边的*右边的
     *
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        result[0] = 1;
        for (int i = 1; i < len; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = len - 1; i >= 0; i--) {
            result[i] = right * result[i];
            right *= nums[i];
        }
        return result;
    }


}
