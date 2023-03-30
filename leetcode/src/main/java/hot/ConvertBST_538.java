package hot;

/**
 * @author: yc_comeon
 * @date: 2023/3/29
 * @description: TODO
 **/
public class ConvertBST_538 {
    public static void main(String[] args) {
        TreeNode root =new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(1);

        TreeNode treeNode = convertBST(root);
    }

    static int pre = 0;

    public static TreeNode convertBST(TreeNode root) {
        if (null == root) {
            return null;
        }

        convertBST(root.right);
        root.val += pre;

        convertBST(root.left);

        return root;
    }
}
