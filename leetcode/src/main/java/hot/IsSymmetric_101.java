package hot;

import java.util.Stack;

/**
 * @author: yc_comeon
 * @date: 2023/3/2
 * @description: TODO
 **/
public class IsSymmetric_101 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(isSymmetric(root));

    }

    public static boolean isSymmetric(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        stack.push(root);

        while (!stack.isEmpty()) {
            if (stack.size() % 2 != 0) {
                return false;
            }
            TreeNode left = stack.pop();
            TreeNode right = stack.pop();
            boolean cur = check(left, right);
            if (!cur) {
                return false;
            }

            if (null != left && null != right) {
                stack.push(left.left);
                stack.push(right.right);
                stack.push(left.right);
                stack.push(right.left);
            }
        }
        return true;

    }

    public static boolean check(TreeNode left, TreeNode right) {
        if (null == left && null == right) {
            return true;
        } else if (null == left) {
            return false;
        } else if (null == right) {
            return false;
        } else {
            return left.val == right.val;
        }
    }

    public static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (null == left && null == right) {
            return true;
        } else if (null == left) {
            return false;
        } else if (null == right) {
            return false;
        } else if (left.val == right.val) {
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        } else {
            return false;
        }
    }


}
