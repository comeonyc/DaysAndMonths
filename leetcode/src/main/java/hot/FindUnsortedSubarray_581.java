package hot;

/**
 * @author: yc_comeon
 * @date: 2023/3/28
 * @description: TODO
 **/
public class FindUnsortedSubarray_581 {
    public static void main(String[] args) {
        System.out.println(findUnsortedSubarray(new int[]{2, 1}));
    }

    public static int findUnsortedSubarray(int[] nums) {
        //初始化
        int len = nums.length;
        int min = nums[len - 1];
        int max = nums[0];
        int begin = 0, end = -1;
        //遍历
        for (int i = 0; i < len; i++) {
            //从左到右维持最大值，寻找右边界end
            if (nums[i] < max) {
                end = i;
            } else {
                max = nums[i];
            }

            //从右到左维持最小值，寻找左边界begin
            if (nums[len - i - 1] > min) {
                begin = len - i - 1;
            } else {
                min = nums[len - i - 1];
            }
        }
        return end - begin + 1;
    }
}
