package hot;

/**
 * @author: yc_comeon
 * @date: 2023/3/4
 * @description: TODO
 **/
public class SingleNumber_136 {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{4,1,2,1,2}));
    }

    public static int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int cur = nums[0] ^ nums[1];
        for (int i = 2; i < nums.length; i++) {
            cur ^= nums[i];
        }
        return cur;
    }
}
