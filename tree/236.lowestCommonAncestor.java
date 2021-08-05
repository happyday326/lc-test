/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.ans = null;
        this.recurseTree(root, p, q);
        return ans;
    }

    private boolean recurseTree(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        int left = this.recurseTree(root.left, p, q)? 1:0;
        int right = this.recurseTree(root.right, p, q)? 1:0;
        int mid = (root==p || root==q) ? 1:0;
        if (left+mid+right >= 2) {
            this.ans = root;
        }
        return (mid+left+right>0);
    }


}