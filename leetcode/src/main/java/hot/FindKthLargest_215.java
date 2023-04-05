package hot;

import java.util.Random;

/**
 * @author: yc_comeon
 * @date: 2023/3/31
 * @description: TODO
 **/
public class FindKthLargest_215 {
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{2, 1}, 2));
    }

    static Random random = new Random();

    public static int findKthLargest(int[] nums, int k) {
        int i = quickSortToIndex(nums, 0, nums.length - 1);
        while (i != k - 1) {
            if (i > k - 1) {
                i = quickSortToIndex(nums, 0, i - 1);
            } else {
                i = quickSortToIndex(nums, i + 1, nums.length-1);
            }
        }
        return nums[i];
    }

    public static int quickSortToIndex(int[] nums, int left, int right) {
        int o = random.nextInt(right - left + 1) + left;
        swap(nums, o, left);
        int a = left, b = right;
        int p = nums[left];
        while (a < b) {
            while (a < b && nums[b] <= p) {
                b--;
            }
            while (a < b && nums[a] >= p) {
                a++;
            }
            swap(nums, a, b);
        }
        swap(nums, left, a);
        return a;
    }

    public static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }


}
