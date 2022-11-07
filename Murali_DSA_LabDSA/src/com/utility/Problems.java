package com.utility;

import com.driver.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problems {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if(s.length()%2!=0)return false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='[')stack.push(s.charAt(i));
            else{
                if(stack.isEmpty())return false;
                if((stack.peek()=='('&& s.charAt(i)==')')||(stack.peek()=='{'&& s.charAt(i)=='}')||(stack.peek()=='['&& s.charAt(i)==']'))
                    stack.pop();
                else return false;
            }
        }
        if(stack.isEmpty())
            return true;
        else return false;
    }
    public static int[] findTarget(Main.TreeNode root, int k) {
        int[] ans = new int [2];
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        for(int i = 0, j = nums.size()-1; i<j;){
            if(nums.get(i) + nums.get(j) == k){
                ans[0] =  nums.get(i);
                ans[1] = nums.get(j);
                break;
            }
            if(nums.get(i) + nums.get(j) < k)i++;
            else j--;
        }
        return ans;
    }

    public static void inorder(Main.TreeNode root, List<Integer> nums){
        if(root == null)return;
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }
}
