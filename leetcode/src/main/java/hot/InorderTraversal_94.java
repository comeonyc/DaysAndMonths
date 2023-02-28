package hot;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: yc_comeon
 * @date: 2023/3/1
 * @description: TODO
 **/
public class InorderTraversal_94 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        recursion(root, result);
        return result;
    }

    public static void recursion(TreeNode root, List<Integer> result) {
        if (null == root) {
            return;
        }
        recursion(root.left, result);
        result.add(root.val);
        recursion(root.right, result);
    }

    public static List<Integer> iteration(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || null != root) {
            while (null != root) {
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            result.add(pop.val);
            root = pop.right;
        }
        return result;
    }
}
