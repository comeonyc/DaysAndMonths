package hot;

/**
 * @author: yc_comeon
 * @date: 2023/3/25
 * @description: TODO
 **/
public class MajorityElement_169 {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
    }

    /**
     * 摩尔投票法 基础版
     * 维护一个投票计数器  最后计数器不为0的定是 超过一半元素的
     *
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        int candidate = nums[0], count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    candidate = nums[i];
                    count = 1;
                }
            }
        }

        return candidate;
    }

    private static void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}
