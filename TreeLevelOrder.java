import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int item) {
        val = item;
        left = right = null;
    }
}

class TreeLevelOrder {
    // root of the binary tree
    TreeNode root;

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                temp.add(cur.val);
                if (cur.left != null)
                    q.add(cur.left);
                if (cur.right != null)
                    q.add(cur.right);
            }
            res.add(temp);
        }
        return res;
    }

    public static void main(String args[]) {
        TreeLevelOrder tree = new TreeLevelOrder();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        List<List<Integer>> ans = new ArrayList<>();
        ans = tree.levelOrder(tree.root);
        System.out.print(ans);
    }
}
