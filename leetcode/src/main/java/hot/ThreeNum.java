package hot;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yc_comeon
 * @date: 2023/2/15
 * @description: TODO
 **/
public class ThreeNum {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, -4, 1, 2, -1, 0}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        quickSort(nums, 0, nums.length - 1);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            int twoSumTarget = -nums[i];
            while (left < right) {
                int twoSum = nums[left] + nums[right];
                if (twoSum > twoSumTarget) {
                    right--;
                } else if (twoSum < twoSumTarget) {
                    left++;
                } else {
                    List<Integer> lists = new ArrayList<>(3);
                    lists.add(nums[i]);
                    lists.add(nums[left]);
                    lists.add(nums[right]);
                    result.add(lists);

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }
        return result;
    }

    /**
     * 快速排序，需要注意的是先从右找，还是先从左找
     */
    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int l = left, r = right;
        int index = nums[left];
        while (l < r) {
            while (l < r && nums[r] >= index) {
                r--;
            }
            while (l < r && nums[l] <= index) {
                l++;
            }
            if (l < r) {
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
            }
        }
        //此时l==r
        nums[left] = nums[l];
        nums[l] = index;
        quickSort(nums, left, l - 1);
        quickSort(nums, l + 1, right);
    }
}
