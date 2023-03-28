package hot;

/**
 * @author: yc_comeon
 * @date: 2023/3/28
 * @description: TODO
 **/
public class FindUnsortedSubarray_581 {
    public static void main(String[] args) {
        System.out.println(findUnsortedSubarray(new int[]{2, 1}));
    }

    public static int findUnsortedSubarray(int[] nums) {
        int left = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                left = i-1;
                break;
            }
        }

        if (left == -1) {
            return 0;
        }

        int right = nums.length - 1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] < nums[i - 1]) {
                right = i;
                break;
            }
        }

        return right - left + 1;
    }
}
