package hot;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yc_comeon
 * @date: 2023/4/3
 * @description: TODO
 **/
public class PathSum_437 {
    public static int pathSum(TreeNode root, int targetSum) {
        return dfs(root, new ArrayList<>(), targetSum);
    }

    private static int dfs(TreeNode root, List<Integer> paths, Integer target) {
        if (root == null) {
            return 0;
        }

        paths.add(root.val);
        int result = 0;
        long sum = 0;
        for (int j = paths.size() - 1; j >= 0; j--) {
            sum += paths.get(j);
            if (sum == target) {
                result++;
            }
        }
        result += dfs(root.left, paths, target);
        result += dfs(root.right, paths, target);
        paths.remove(paths.size() - 1);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);

        System.out.println(pathSum(root, 8));
    }

}
