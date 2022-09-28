package jeet.code.hash;

import java.util.ArrayList;
import java.util.List;

public class DoubleTree {

    public class TreeNode { 
       int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    public class Node {
        int val;
        boolean isLeave = false;
        boolean hasleft = false;
        boolean hasRight = false;

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public boolean isLeave() {
            return isLeave;
        }

        public void setLeave(boolean leave) {
            isLeave = leave;
        }

        public boolean isHasleft() {
            return hasleft;
        }

        public void setHasleft(boolean hasleft) {
            this.hasleft = hasleft;
        }

        public boolean isHasRight() {
            return hasRight;
        }

        public void setHasRight(boolean hasRight) {
            this.hasRight = hasRight;
        }

        public Node(int val, boolean leave) {
            this.val = val;
            this.isLeave = leave;
        }

        public boolean equals(Node a) {
            if (a == null) {return false;}
            return (val == a.val && hasleft == a.hasleft && hasRight == a.hasRight);
        }

    }

    public void deep(TreeNode root, List<Node> result) {
        if (root != null) {
            if (root.left != null || root.right != null) {
                Node rootNode = new Node(root.val, false);
                result.add(rootNode);
                if (root.left != null) {
                    rootNode.setHasleft(true);
                    deep(root.left, result);
                }
                if (root.right != null) {
                    rootNode.setHasRight(true);
                    deep(root.right, result);
                }
            } else {
                result.add(new Node(root.val, true));
            }
        }
    }

    public boolean check(List<Node> root, List<Node> sub, int start) {
        for(int i=start,j=0;j<sub.size();i++,j++) {
            if (!root.get(i).equals(sub.get(j))) {return false;}
        }
        return true;
    }

    public boolean check(List<Node> root, Node sub) {
        for(Node r: root) {
            if (r.equals(sub)) {
                return true;
            }
        }
        return false;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        List<Node> subResult = new ArrayList<>();
        deep(subRoot, subResult);
        List<Node> rootResult = new ArrayList<>();
        deep(root, rootResult);
        if (subResult.size() == 1) {
            return check(rootResult, subResult.get(0));
        }

        for(int i=0;i<rootResult.size()-subResult.size();i++) {
            boolean checked = check(rootResult, subResult, i);
            if (checked) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DoubleTree.TreeNode left2 = new DoubleTree().new TreeNode(1);
        DoubleTree.TreeNode last = new DoubleTree().new TreeNode(0);
        DoubleTree.TreeNode right2 = new DoubleTree().new TreeNode(2, null, last);
        DoubleTree.TreeNode left1 = new DoubleTree().new TreeNode(4, left2, right2);
        DoubleTree.TreeNode right1 = new DoubleTree().new TreeNode(5);
        DoubleTree.TreeNode root = new DoubleTree().new TreeNode(3, left1, right1);

        DoubleTree.TreeNode sub2 = new DoubleTree().new TreeNode(2);
        DoubleTree.TreeNode subTree = new DoubleTree().new TreeNode(4, left2, sub2);

        DoubleTree.TreeNode subTree2 = new DoubleTree().new TreeNode(4, left2, null);
        /*List<Node> result = new ArrayList<>();
        new DoubleTree().deep(subTree, result);
        result.forEach(n -> System.out.println(n.getVal() + " | " + n.isLeave()));*/

        boolean checked = new DoubleTree().isSubtree(subTree, subTree2);
        System.out.println("ccc : " + checked);
    }
}
