package com.driver;

import com.utility.Problems;

public class Main {
    public static class TreeNode {
      public int val;
      public TreeNode left;
      public TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public static void main(String[] args) {

        String s = "([[{}]])";
        boolean ans = Problems.isValid(s);
        if(ans==true) System.out.println("The entered String has Balanced Brackets");
        else System.out.println("The entered Strings do not contain Balanced Brackets");
        TreeNode root = new TreeNode(40);
        root.left = new TreeNode(20);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(30);
        root.right = new TreeNode(60);
        root.right.left = new TreeNode(50);
        root.right.right = new TreeNode(70);
        int[]  answer= Problems.findTarget(root,130);
        System.out.println("["+answer[0]+","+answer[1]+"]");
    }
}