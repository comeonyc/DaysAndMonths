package hot;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author: yc_comeon
 * @date: 2023/3/3
 * @description: TODO
 **/
public class LevelOrder_102 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(levelOrder(root));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (null == root) {
            return new ArrayList<>();
        }
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        List<List<Integer>> result = new ArrayList<>();
        while (!nodes.isEmpty()) {
            int index = nodes.size();
            List<Integer> cur = new ArrayList<>();
            while (index > 0) {
                index--;
                TreeNode a = nodes.remove(0);
                if (null == a) {
                    continue;
                }
                cur.add(a.val);
                nodes.add(a.left);
                nodes.add(a.right);
            }
            if (!cur.isEmpty()) {
                result.add(cur);
            }
        }
        return result;
    }

    public static void levelOrder(TreeNode root, int index, List<List<Integer>> result) {
        if (null == root) {
            return;
        }
        if (index == result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(index).add(root.val);
        levelOrder(root.left, index + 1, result);
        levelOrder(root.right, index + 1, result);
    }
}
