package hot;

/**
 * @author: yc_comeon
 * @date: 2023/3/3
 * @description: TODO
 **/
public class BuildTree_105 {
    public static void main(String[] args) {
        TreeNode treeNode = buildTree(new int[]{1,2}, new int[]{2,1});
        System.out.println(treeNode);

    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preRight - preLeft == 0) {
            return new TreeNode(preorder[preLeft]);
        } else if (preRight < preLeft) {
            return null;
        }

        int root = preorder[preLeft];
        int mid = 0;
        for (int i = inLeft; i <= inRight; i++) {
            if (root == inorder[i]) {
                mid = i;
                break;
            }
        }
        TreeNode treeNode = new TreeNode(root);
        treeNode.left = buildTree(preorder, inorder, preLeft + 1, preLeft + mid - inLeft, inLeft, mid - 1);
        treeNode.right = buildTree(preorder, inorder, preLeft + mid - inLeft + 1, preRight, mid + 1, inRight);
        return treeNode;
    }
}
