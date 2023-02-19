package hot;

/**
 * @author: yc_comeon
 * @date: 2023/2/19
 * @description: TODO
 **/
public class Search_33 {
    public static void main(String[] args) {
        System.out.println(search(new int[]{3,1}, 1));

    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = calMid(left, right);
            if (target == nums[mid]) {
                return mid;
            }

            //此时代表左边是升序的
            //有的时候mid和left会重合
            if (nums[left] <= nums[mid]) {
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target<= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    public static int calMid(int left, int right) {
        return (left + right) / 2;
    }
}
