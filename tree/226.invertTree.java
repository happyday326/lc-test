/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        TreeNode res = reverseTree(root);
        return res;
    }

    private TreeNode reverseTree(TreeNode source) {
        if (source==null) return source;
        TreeNode res = new TreeNode();
        if (source != null) {
            res.val = source.val;
            if (source.right != null) res.left = reverseTree(source.right);
            if (source.left != null) res.right = reverseTree(source.left);
        }
        return res;
    }
}