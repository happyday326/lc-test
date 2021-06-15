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
class Test {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> pathSum = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int sum = 0;
        getPathSum(root, pathSum, path, targetSum, sum);
        return pathSum;
    }

    private void getPathSum(TreeNode root, List<List<Integer>> pathSum, List<Integer> path, int targetSum, int sum) {
        if (root != null) {
            path.add(root.val);
            sum += root.val;
            if (root.left==null && root.right==null) {
                if (sum==targetSum) pathSum.add(path);
            } else if (root.left==null) {
                getPathSum(root.right, pathSum, path, targetSum, sum);
            } else if (root.right==null) {
                getPathSum(root.left, pathSum, path, targetSum, sum);
            } else {
                getPathSum(root.left, pathSum, path, targetSum, sum);
                getPathSum(root.right, pathSum, path, targetSum, sum);
            }
        }
    }
}