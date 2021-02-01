package BinaryTree.Medium;

public class LC426 {
    private Node prev = null;
    private Node head = null;
    //    private Node tail = null;// tail is the prev
    public Node treeToDoublyList(Node root) {
        inorder(root);

        if (head != null && prev != null) {
            prev.right = head;
            head.left = prev;
        }

        return head;
    }

    private void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        if (prev == null) {
            head = root;
        } else {
            prev.right = root;
        }
        root.left = prev;
        prev = root;
//        tail = root; // tail is the last element of traversal

        inorder(root.right);
    }
}
