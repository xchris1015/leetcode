package BinaryTree.Hard;

import BinaryTree.TreeNode;

import java.util.*;

public class LC297SerializeandDeserializeBT {

    //BFS

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current == null) {
                sb.append("#,");
            } else {
                sb.append(current.val + ",");
                queue.offer(current.left);
                queue.offer(current.right);
            }
        }

        for (int i = sb.length() - 1 ; i >= 0 ; i-- ) {
            if (!Character.isDigit(sb.charAt(i))) {
                sb.setLength(sb.length() - 1);
            } else {
                break;
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data == null || data.length() == 0) {
            return null;
        }

        String[] cache = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(cache[0]));
        queue.offer(root);

        int i = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                TreeNode parent = queue.poll();

                if (i < cache.length && !cache[i].equals("#")) {
                    TreeNode left = new TreeNode(Integer.valueOf(cache[i]));
                    parent.left = left;
                    queue.offer(left);
                }
                i++;
                if (i < cache.length && !cache[i].equals("#")) {
                    TreeNode right = new TreeNode(Integer.valueOf(cache[i]));
                    parent.right = right;
                    queue.offer(right);
                }
                i++;
            }


        }
        return root;
    }

    //DFS
//    public String serialize(TreeNode root) {
//        if (root == null) {
//            return "";
//        }
//
//        StringBuilder sb = new StringBuilder();
//
//        dfs(root, sb);
//        return sb.toString();
//    }
//
//    private void dfs(TreeNode root, StringBuilder sb) {
//        if (root == null) {
//            sb.append("#").append(",");
//        } else {
//            sb.append(root.val).append(",");
//            dfs(root.left, sb);
//            dfs(root.right, sb);
//        }
//    }
//
//    public TreeNode deserialize(String data) {
//        if (data == null || data.length() == 0) {
//            return null;
//        }
//
//        String[] cache = data.split(",");
//        List<String> list = new ArrayList<>(Arrays.asList(cache));
//        return deDFS(list);
//    }
//
//    private TreeNode deDFS(List<String> list) {
//
//        if (list.get(0).equals("#")) {
//            list.remove(0);
//            return null;
//        }
//
//        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
//        list.remove(0);
//        root.left = deDFS(list);
//        root.right = deDFS(list);
//
//        return root;
//
//    }


}
