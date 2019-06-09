## Tree

#### 基础知识

##### 1.二叉树的结构

```
class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int val) {
		this.val = val;
	}
}

//建立新的二叉树
TreeNode node1 = new TreeNode(8);
TreeNode node2 = new TreeNode(3);
TreeNode node3 - new TreeNode(1);
node1.left = node2;
node1.right = node3;

//树的遍历（递归操作）
public static void traverseTree(TreeNode root) {
	//递归要素一：终止条件end case
	if (root == null) {
		return;
	}
	
	//递归要素二：最基本情况，base case
	System.out.println(root.val);
	traverseTree(root.left);
	traverseTree(root.right);
}
```

#### 例题
* [66. Binary Tree Preorder Traversal
](https://www.lintcode.com/problem/binary-tree-preorder-traversal/description) 

[Solution]



