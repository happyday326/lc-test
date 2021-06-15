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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        List<Integer> sums = new ArrayList<>();
        int sum = 0;
        getSums(root, sums, sum);
        for (int s: sums) {
            if (s == targetSum) return true;
        }
        return false;
    }

    private void getSums(TreeNode root, List<Integer> sums, int sum) {
        if (root != null) {
            sum += root.val;
            if (root.left==null && root.right==null) {
                sums.add(sum);
            } else if (root.left == null) {
                getSums(root.right, sums, sum);
            } else if (root.right == null) {
                getSums(root.left, sums, sum);
            } else {
                getSums(root.left, sums, sum);
                getSums(root.right, sums, sum);
            }
        }
    }


}