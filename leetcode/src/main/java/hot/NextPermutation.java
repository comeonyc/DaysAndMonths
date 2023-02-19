package hot;

/**
 * @author: yc_comeon
 * @date: 2023/2/19
 * @description: TODO
 **/
public class NextPermutation {
    public static void main(String[] args) {
        nextPermutation(new int[]{2, 3, 1});
    }

    public static void nextPermutation(int[] nums) {
        if (null == nums || nums.length < 2) {
            return;
        }

        int right = nums.length - 1;
        //降序的是小  升序的才是有可能变化的
        while (right > 0 && nums[right] <= nums[right - 1]) {
            right--;
        }

        int swapIndex = right - 1;
        if (swapIndex >= 0) {
            right = nums.length - 1;
            while (right > swapIndex && nums[right] <= nums[swapIndex]) {
                right--;
            }
            swap(nums, swapIndex, right);
        }

        reverse(nums, swapIndex + 1);
    }

    public static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    private static void reverse(int[] nums, int index) {
        int left = index, right = nums.length - 1;
        while (left < right && nums[left] > nums[right]) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
