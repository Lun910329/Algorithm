

import java.util.ArrayList;
import java.util.List;

class TreeNode {
     public int val;
     public TreeNode left, right;
     public TreeNode(int val) {
    	 this.val = val;
    	 this.left = this.right = null;
     }
}

public class BSTmanipulation {
	// BST insert
	public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (root == null) {
            return node;
        }
        if (root.val > node.val) {
            root.left = insertNode(root.left, node);
        } else {
            root.right = insertNode(root.right, node);
        }
        return root;
    }
	
	
	
	// BST isPresent
	public TreeNode helper(TreeNode root, int key)
	{
	    if (root==null || root.val==key)
	        return root;
	 
	    if (root.val > key) {
	 	   return helper(root.left, key);
	    } else {
		   return helper(root.right, key);
	    }
	
	}
	
	public boolean isPresent(TreeNode root, int key) {
		TreeNode node = helper(root, key);
		return (node != null);
	}
	
	
	
	// BST inorder
	public List<Integer> inorder(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		traverse(root, list);
		return list;
	}
	
	public void traverse(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		
		traverse(root.left, list);
		list.add(root.val);
		traverse(root.right, list);
	}

	public static void main(String[] args) {

		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		node3.left = node1;
		node3.right = node4;
		
		TreeNode root = new BSTmanipulation().insertNode(node3, node2);
		System.out.println(root.left.right.val + "\n");
		boolean result = new BSTmanipulation().isPresent(root, 5);
		System.out.println(result + "\n");
		System.out.println(new BSTmanipulation().inorder(root));
	}

}
