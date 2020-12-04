package BDFS.medium;

import BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BSTLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root!=null){
            queue.offer(root);
        }

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> currentLevel = new LinkedList<>();
            for(int i=0;i< size;i++){
                TreeNode current = queue.poll();
                currentLevel.add(current.val);
                if(current.left!=null){
                    queue.add(current.left);
                }
                if(current.right!=null){
                    queue.add(current.right);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }
}
