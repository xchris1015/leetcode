package BinaryTree;

public class ExtendTreeNode extends TreeNode {

    private int leftNodeSum;

    private int rightNodeSum;

    public ExtendTreeNode(int val) {
        super(val);
        leftNodeSum = 0;
        rightNodeSum = 0;
    }
}
