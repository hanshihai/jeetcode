package jeet.code;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class CompareTree {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  public boolean isSameTree(TreeNode p, TreeNode q) {
        if((p == null && q == null)) {
            return true;
        } else if((q != null && p == null) || (q == null && p != null) || (p != null && q != null && (p.val != q.val))) {
            return false;
        } else {
            ArrayDeque<List<TreeNode>> buffer = new ArrayDeque<>();
            List<TreeNode> collectionTree = new ArrayList<>();
            collectionTree.add(p);
            collectionTree.add(q);
            buffer.push(collectionTree);
            while(!buffer.isEmpty()) {
                List<TreeNode> col = buffer.pop();
                TreeNode t1 = col.get(0);
                TreeNode t2 = col.get(1);
                if((t1.left == null && t2.left != null) || (t1.left != null && t2.left == null)) {
                    return false;
                }
                if(t1.left != null && t2.left != null && t1.left.val == t2.left.val) {
                    List<TreeNode> treeLeft = new ArrayList<>();
                    treeLeft.add(t1.left);
                    treeLeft.add(t2.left);
                    buffer.push(treeLeft);
                }else if(!(t1.left == null && t2.left == null)){
                    return false;
                }
                if((t1.right == null && t2.right != null) || (t1.right != null && t2.right == null)) {
                    return false;
                }
                if(t1.right != null && t2.right != null && t1.right.val == t2.right.val) {
                    List<TreeNode> treeRight = new ArrayList<>();
                    treeRight.add(t1.right);
                    treeRight.add(t2.right);
                    buffer.push(treeRight);
                }else if(!(t1.right == null && t2.right == null)){
                    return false;
                }
            }
            return true;
        }
  }

  public TreeNode initTree(int[] numbers) {
        TreeNode root = new TreeNode(numbers[0]);
        TreeNode left = new TreeNode(numbers[1]);
        TreeNode right = new TreeNode(numbers[2]);
        root.left = left;
        root.right = right;
        return root;
  }
  public static void main(String[] args) {
        int[] ps = new int[]{1,2,3};
        int[] qs = new int[]{1,2,3};
        CompareTree compare = new CompareTree();
        TreeNode p = compare.initTree(ps);
        TreeNode q = compare.initTree(qs);
        System.out.println(compare.isSameTree(p,q));
  }
}
