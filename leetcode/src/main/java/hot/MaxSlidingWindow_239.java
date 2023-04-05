package hot;

import java.util.LinkedList;

/**
 * @author: yc_comeon
 * @date: 2023/4/1
 * @description: TODO
 **/
public class MaxSlidingWindow_239 {
    public static void main(String[] args) {

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        //单调递增减队列，队首最大 队尾最小
        LinkedList<Integer> queue = new LinkedList<>();

        int left = 0;
        int[] result = new int[nums.length - k + 1];
        int index = 0;


        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.removeLast();
            }

            queue.addLast(i);

            if (i - left + 1 == k) {
                while (!queue.isEmpty() && queue.peekFirst() < left) {
                    queue.removeFirst();
                }

                result[index++] = nums[queue.peekFirst()];
                left++;
            }

        }

        return result;
    }
}
