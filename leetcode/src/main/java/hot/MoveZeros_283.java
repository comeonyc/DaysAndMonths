package hot;

/**
 * @author: yc_comeon
 * @date: 2023/4/1
 * @description: TODO
 **/
public class MoveZeros_283 {
    public static void main(String[] args) {
        moveZeroes(new int[]{1,1,0,3,12});
    }

    /**
     * 双指针，右指针遍历，左指针是下一个不为0的交换位置
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
