package hot;

/**
 * @author: yc_comeon
 * @date: 2023/3/2
 * @description: TODO
 **/
public class IsValidBST_98 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MAX_VALUE);
    }

    public static boolean dfs(TreeNode root, long pre) {
        if (null == root) {
            return true;
        }

        if (!dfs(root.left, pre)) {
            return false;
        }

        if (pre == Long.MAX_VALUE) {
            pre = root.val;
        } else if (root.val <= pre) {
            return false;
        }

        return dfs(root.right, pre);
    }

}
