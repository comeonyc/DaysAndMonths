package hot;

/**
 * @author: yc_comeon
 * @date: 2023/4/1
 * @description: TODO
 **/
public class FindDuplicate_287 {
    public static void main(String[] args) {

    }

    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        int a = 0;
        while (a != slow) {
            a = nums[a];
            slow = nums[slow];
        }
        return a;
    }
}
