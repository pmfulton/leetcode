/* Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees. */

class validateBST {
    public boolean isValidBST(TreeNode root) {
        return test(root, null, null);
    }
    
    
    
    public boolean test(TreeNode node, Integer left, Integer right) {
        if (node == null) return true;
        
        int curNodeVal = node.val;
        
        System.out.println(left);
        System.out.println(right);
        
        if (left != null && left >= curNodeVal) return false;
        if (right != null && right <= curNodeVal) return false;
        
        if (!test(node.right, curNodeVal, right)) return false;
        if (!test(node.left, left, curNodeVal)) return false;
        
        
        
        return true;
    }
}


// public class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode() {}
//     TreeNode(int val) { this.val = val; }
//     TreeNode(int val, TreeNode left, TreeNode right) {
//           this.val = val;
//           this.left = left;
//           this.right = right;
//     }
//  }