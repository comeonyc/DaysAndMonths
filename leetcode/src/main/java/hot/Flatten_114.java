package hot;

/**
 * @author: yc_comeon
 * @date: 2023/3/4
 * @description: TODO
 **/
public class Flatten_114 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        flatten(root);
        System.out.println(root);
    }

    public static void flatten(TreeNode root) {
        if (null == root) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        if (root.left == null) {
            return;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        TreeNode tmp = left;
        while (null != tmp.right) {
            tmp = tmp.right;
        }
        root.right = left;
        tmp.right = right;
    }
}
