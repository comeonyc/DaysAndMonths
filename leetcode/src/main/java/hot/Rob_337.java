package hot;

/**
 * @author: yc_comeon
 * @date: 2023/4/5
 * @description: TODO
 **/
public class Rob_337 {
    static int max = 0;
    static int tmp = 0;

    public static int rob(TreeNode root) {
        int[] res = get(root);
        return Math.max(res[0], res[1]);
    }

    public static int[] get(TreeNode root) {
        if (root == null) return new int[2];

        int[] res = new int[2];

        int[] left = get(root.left);
        int[] right = get(root.right);

        //不偷
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        //偷
        res[1] = root.val + left[0] + right[0];

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);

        root.right = new TreeNode(3);
        root.right.right = new TreeNode(1);

        System.out.println(rob(root));
    }
}
