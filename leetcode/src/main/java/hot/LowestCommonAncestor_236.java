package hot;

/**
 * @author: yc_comeon
 * @date: 2023/4/1
 * @description: TODO
 **/
public class LowestCommonAncestor_236 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(2);

        TreeNode treeNode = lowestCommonAncestor(root, root.left, root.left.left);
        System.out.println(treeNode);
    }

    static TreeNode treeNode = null;

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        contains(root, p, q);
        return treeNode;
    }

    public static boolean contains(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }

        boolean cur = root == p || root == q;
        boolean left = contains(root.left, p, q);
        boolean right = contains(root.right, p, q);

        if ((cur && left) || (cur && right) || (left && right)) {
            if (null == treeNode) {
                treeNode = root;
            }
        }
        return cur || left || right;
    }
}
