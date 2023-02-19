package hot;

import java.util.Arrays;

/**
 * @author: yc_comeon
 * @date: 2023/2/19
 * @description: TODO
 **/
public class SearchRange_34 {
    public static void main(String[] args) {
        Arrays.stream(searchRange(new int[]{1}, 1)).forEach(System.out::println);
    }

    public static int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                index = mid;
                break;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (index < 0) {
            return new int[]{-1, -1};
        } else {
            left = index - 1;
            while (left >= 0 && nums[left] == nums[index]) {
                left--;
            }
            right = index + 1;
            while (right < nums.length && nums[right] == nums[index]) {
                right++;
            }
            return new int[]{left + 1, right - 1};
        }
    }
}
