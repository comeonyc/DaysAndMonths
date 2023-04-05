package hot;

/**
 * @author: yc_comeon
 * @date: 2023/3/31
 * @description: TODO
 **/
public class InvertTree_226 {
    public static void main(String[] args) {

    }

    public static TreeNode invertTree(TreeNode root) {
        if (null == root) {
            return root;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;

    }
}
