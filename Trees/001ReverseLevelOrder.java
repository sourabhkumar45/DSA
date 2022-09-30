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
   public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> smallAns = new ArrayList<>();
        reverseLevel(root, ans, smallAns, 0);
        Collections.reverse(ans);
        return ans;
    }
    public void reverseLevel(TreeNode root, List<List<Integer>> ans, List<Integer> smallAns, int lvl) {
        if(root==null) return;
        
        if(lvl == ans.size()) {
            ans.add(new ArrayList<>());
        }
      
        reverseLevel(root.left, ans, smallAns, lvl+1);
        reverseLevel(root.right, ans, smallAns, lvl+1);
        ans.get(lvl).add(root.val);
    }
}

// we can also solve using combination of stack for storing the answer of level and queue for level order traversal.