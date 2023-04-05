package hot;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: yc_comeon
 * @date: 2023/4/1
 * @description: TODO
 **/
public class Codec_297 {
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        return deserialize(data.split(","), new AtomicInteger(0));
    }

    private static TreeNode deserialize(String[] data, AtomicInteger index) {
        if (index.get() > data.length) {
            return null;
        }

        String cur = data[index.getAndIncrement()];
        if ("#".equals(cur)) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(cur));
        root.left = deserialize(data, index);
        root.right = deserialize(data, index);
        return root;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String serialize = serialize(root);
        System.out.println(serialize);
        TreeNode deserialize = deserialize(serialize);
        System.out.println(deserialize);
    }
}
