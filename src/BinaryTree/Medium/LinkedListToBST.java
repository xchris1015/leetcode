package BinaryTree.Medium;

import BinaryTree.ListNode;
import BinaryTree.TreeNode;

public class LinkedListToBST {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        int length = getLength(head);
        return helper(head, 0, length - 1);
    }

    private int getLength(ListNode head) {
        if (head == null) {
            return 0;
        }

        return getLength(head.next) + 1;
    }

    private TreeNode helper(ListNode head, int left, int right) {

        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        ListNode midNode = head;
        for (int i = 0 ; i < mid ; i++ ) {
            midNode = midNode.next;
        }

        TreeNode node = new TreeNode(midNode.val);
        node.left = helper(head, left, mid - 1);
        node.right = helper(head, mid + 1, right);

        return node;

    }
}
