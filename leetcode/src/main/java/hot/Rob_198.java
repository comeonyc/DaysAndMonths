package hot;

/**
 * @author: yc_comeon
 * @date: 2023/3/27
 * @description: TODO
 **/
public class Rob_198 {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,7,9,3,1}));
    }

    public static int rob(int[] nums) {
        int len = nums.length;
        int[] steal = new int[len];
        int[] notSteal = new int[len];
        steal[0] = nums[0];
        notSteal[0] = 0;

        for (int i = 1; i < len; i++) {
            steal[i] = nums[i] + notSteal[i - 1];
            notSteal[i] = Math.max(steal[i - 1], notSteal[i - 1]);
        }

        return Math.max(steal[len-1], notSteal[len-1]);
    }

}
