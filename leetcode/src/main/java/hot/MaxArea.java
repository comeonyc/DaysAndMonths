package hot;

/**
 * @author: yc_comeon
 * @date: 2023/2/7
 * @description: TODO
 **/
public class MaxArea {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    /**
     * 双指针 核心解题思路是类似于贪心的算法
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int width = right - left;
            int high = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, width * high);
            //最高的挡板能放最多的水
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }
}
