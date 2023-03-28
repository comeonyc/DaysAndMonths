package hot;

/**
 * @author: yc_comeon
 * @date: 2023/3/28
 * @description: TODO
 **/
public class MergeTrees_517 {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.left.left = new TreeNode(5);
        root1.right = new TreeNode(2);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.left.right = new TreeNode(4);
        root2.right = new TreeNode(3);
        root2.right.right = new TreeNode(7);

        TreeNode treeNode = mergeTrees(root1, root2);

        System.out.println("1");

    }

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (null == root1 && null == root2) {
            return null;
        } else if (null == root1) {
            return root2;
        } else if (null == root2) {
            return root1;
        } else {
            TreeNode cur = new TreeNode(root1.val + root2.val);
            cur.left = mergeTrees(root1.left, root2.left);
            cur.right = mergeTrees(root1.right, root2.right);
            return cur;
        }
    }
}
