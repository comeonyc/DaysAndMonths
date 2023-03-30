package hot;

/**
 * @author: yc_comeon
 * @date: 2023/3/29
 * @description: TODO
 **/
public class DiameterOfBinaryTree_543 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);

        System.out.println(diameterOfBinaryTree(treeNode));

    }

    static int max = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max - 1;
    }

    public static int dfs(TreeNode root) {
        if (null == root) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        max = Math.max(max, left + right + 1);

        return Math.max(left, right) + 1;
    }
}
