/**
 * Definition of TreeNode:
 * public class TreeNode {
 * public int val;
 * public TreeNode left, right;
 * public TreeNode(int val) {
 * this.val = val;
 * this.left = this.right = null;
 * }
 * }
 */

//Recursion
public class Solution {
    /**
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    //in the parameter java use reference, so that every time of recursion root will be copied and change the value of this address
    //for result, every time will copy its address so the final result will be changed for many times
    public void preorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        //List.add()to add a value to ArrayList
        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }
}

//non-recursion
public class Solution {
    /**
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack<TreeNode>();

        //when root is null
        if (root == null) {
            return result;
        }
        st.push(root);
        //!st.isEmpty() == !st.empty()
        while (!st.isEmpty()) {
            TreeNode node = st.pop();
            result.add(node.val);
            if (node.right != null) {
                st.push(node.right);
            }
            if (node.left != null) {
                st.push(node.left);
            }
        }

        return result;
    }
}