package hot;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author: yc_comeon
 * @date: 2023/3/28
 * @description: TODO
 **/
public class DailyTemperatures_739 {
    public static void main(String[] args) {
        Arrays.stream(dailyTemperatures(new int[]{89,62,70,58,47,47,46,76,100,70})).forEach(System.out::println);
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] result = new int[len];
        Stack<Integer> min = new Stack<>();
        int i = len - 1;
        while (i >= 0) {
            while (!min.isEmpty() && temperatures[i] > temperatures[min.peek()]) {
                min.pop();
            }

            result[i] = min.isEmpty() ? 0 : min.peek() - i;
            min.add(i);
            i--;
        }
        return result;
    }
}
