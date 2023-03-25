package hot;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yc_comeon
 * @date: 2023/3/25
 * @description: TODO
 **/
public class MinStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(Integer.MAX_VALUE - 1);
        minStack.push(Integer.MAX_VALUE - 1);
        minStack.push(Integer.MAX_VALUE);
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.push(Integer.MAX_VALUE);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.push(Integer.MIN_VALUE);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }

    List<Integer> elements;
    int min;

    public MinStack() {
        elements = new ArrayList<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        elements.add(val);
        min = Math.min(val, min);
    }

    public void pop() {
        int top = elements.remove(elements.size() - 1);
        if (top == min) {
            min = elements.stream().min(Integer::compare).orElse(Integer.MAX_VALUE);
        }
    }

    public int top() {
        return elements.get(elements.size() - 1);
    }

    public int getMin() {
        return min;
    }
}
