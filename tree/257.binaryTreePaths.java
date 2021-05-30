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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        String path = "";
        dfs(res, root, path);
        return res;
    }

    private void dfs(List<String> res, TreeNode root, String path) {
        if (!path.isBlank()) path += "->";
        path += String.valueOf(root.val);
        if (root.left==null && root.right==null) {
            res.add(path);
        } else if (root.right==null) {
            dfs(res, root.left, path);
        } else if(root.left==null) {
            dfs(res, root.right, path);
        } else {
            dfs(res, root.right, path);
            dfs(res, root.left, path);
        }
    }


}