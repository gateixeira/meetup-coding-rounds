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
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Queue<TreeNode> originalQueue = new ArrayDeque<TreeNode>();
        Queue<TreeNode> cloneQueue = new ArrayDeque<TreeNode>();

        originalQueue.add(original);
        cloneQueue.add(cloned);
        
        
        while (!originalQueue.isEmpty()) {
            TreeNode currentOriginal = originalQueue.poll();
            TreeNode currentClone = cloneQueue.poll();
            
            if (currentOriginal == target)
                return currentClone;
            
            if (currentOriginal.left != null) {
                originalQueue.add(currentOriginal.left);
                cloneQueue.add(currentClone.left);
            }

            if (currentOriginal.right != null) {
                originalQueue.add(currentOriginal.right);
                cloneQueue.add(currentClone.right);
            }
        }
        
        return null;
    }
}