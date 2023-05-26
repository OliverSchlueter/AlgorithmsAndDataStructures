package de.oliver.problems.leetcode;

import java.util.*;

public class SameTree {

    /*
        https://leetcode.com/problems/same-tree/
     */

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        else if(p == null || q == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();

        // p
        queue.offer(p);
        List<TreeNode> nodesP = new ArrayList<>();

        while(!queue.isEmpty()){
            TreeNode current = queue.poll();

            nodesP.add(current);

            if(current.left != null)
                queue.offer(current.left);
            else if(current.val != -1)
                queue.offer(new TreeNode(-1));

            if(current.right != null)
                queue.offer(current.right);
            else if(current.val != -1)
                queue.offer(new TreeNode(-1));
        }

        // q
        queue.offer(q);
        List<TreeNode> nodesQ = new ArrayList<>();

        while(!queue.isEmpty()){
            TreeNode current = queue.poll();

            nodesQ.add(current);

            if(current.left != null)
                queue.offer(current.left);
            else if(current.val != -1)
                queue.offer(new TreeNode(-1));

            if(current.right != null)
                queue.offer(current.right);
            else if(current.val != -1)
                queue.offer(new TreeNode(-1));

        }

        if(nodesP.size() != nodesQ.size())
            return false;

        for (int i = 0; i < nodesP.size(); i++) {
            if(nodesP.get(i).val != nodesQ.get(i).val)
                return false;
        }


        return true;
    }
}
