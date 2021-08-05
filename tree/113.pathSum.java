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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> pathList = new ArrayList<List<Integer>>();
        List<Integer> pathNodes = new ArrayList<Integer>();
        this.dfs(root, pathList, pathNodes, targetSum);
        return pathList;
    }

    private void dfs(TreeNode root, List<List<Integer>> pathList, List<Integer> pathNodes, int remain) {
        if (root == null) {
            return;
        }
        pathNodes.add(root.val);
        if (remain==root.val && root.left==null && root.right==null) {
            pathList.add(new ArrayList<>(pathNodes));
        } else {
            this.dfs(root.left, pathList, pathNodes, remain-root.val);
            this.dfs(root.right, pathList, pathNodes, remain-root.val);
        }
        pathNodes.remove(pathNodes.size()-1);
    }
}