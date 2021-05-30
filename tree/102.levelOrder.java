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
//这道题利用了recursive和dfs
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrderDfs(root, res, 0);
        return res;
    }

    private void levelOrderDfs(TreeNode root, List<List<Integer>> list, Integer level) {
        if (root != null) {
            if (list.size() < level+1) list.add(new ArrayList<>());
            list.get(level).add(root.val);
            levelOrderDfs(root.left, list, level+1);
            levelOrderDfs(root.right, list, level+1);
        }
    }
}