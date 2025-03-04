// https://leetcode.com/problems/deepest-leaves-sum/

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
    public int deepestLeavesSum(TreeNode root) {
        int depth = getDepth(root);
        return deepestLeavesSum(root, 1, depth);
    }

    private int deepestLeavesSum(TreeNode root, int currLevel, int desiredLevel) {
        if (root == null)
            return 0;
        
        if (root.left == null && root.right == null) {
            if (currLevel == desiredLevel)
                return root.val;
            else
                return 0;
        }
        
        return deepestLeavesSum(root.left, currLevel + 1, desiredLevel) + deepestLeavesSum(root.right, currLevel + 1, desiredLevel);
    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = 1 + getDepth(root.left);
        int right = 1 + getDepth(root.right);

        return Math.max(left, right);
    }
}
