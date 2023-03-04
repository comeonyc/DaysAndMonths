package hot;

/**
 * @author: yc_comeon
 * @date: 2023/3/4
 * @description: TODO
 **/
public class MaxPathSum_124 {
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        int i = maxPathSum(root);
        System.out.println(i);
    }

    public static int maxPathSum(TreeNode root) {
        getMax(root);
        return max;
    }

    public static int getMax(TreeNode root) {
        if (null == root) {
            return 0;
        }

        int val = root.val;
        int left = getMax(root.left);
        int right = getMax(root.right);

        int middleResult = val, returnResult = 0;
        middleResult = Math.max(middleResult, val + left);
        middleResult = Math.max(middleResult, val + right);
        returnResult = middleResult;
        middleResult = Math.max(middleResult, val + left + right);
        middleResult = Math.max(middleResult, left);
        middleResult = Math.max(middleResult, right);
        max = Math.max(max, middleResult);
        return returnResult;
    }
}
