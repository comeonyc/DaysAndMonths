package hot;

/**
 * @author: yc_comeon
 * @date: 2023/2/25
 * @description: TODO
 **/
public class SortColors_75 {
    public static void main(String[] args) {
        sortColors(new int[]{2, 0, 1});

        System.out.println("a");
    }

    public static void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        for (int i = 0; i <= right; ) {
            if (nums[i] == 0) {
                nums[i] = nums[left];
                nums[left] = 0;
                left++;
                i++;
            } else if (nums[i] == 2) {
                nums[i] = nums[right];
                nums[right] = 2;
                right--;
            } else {
                i++;
            }
        }
    }
}
