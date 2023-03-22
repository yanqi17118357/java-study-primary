package com.test;

import com.test.collection.LinkedQueue;

public class Main {
    public static void main(String[] args) {
        TreeNode<Character> a = new TreeNode<>('A');
        TreeNode<Character> b = new TreeNode<>('B');
        TreeNode<Character> c = new TreeNode<>('C');
        TreeNode<Character> d = new TreeNode<>('D');
        TreeNode<Character> e = new TreeNode<>('E');
        TreeNode<Character> f = new TreeNode<>('F');

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        levelOrder(a);

    }

    // 前序遍历
    public static <T> void preOrder(TreeNode<T> root) {
        if (root == null) return;
        System.out.print(root.element + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // 层序遍历
    private static <T> void levelOrder(TreeNode<T> root){
        LinkedQueue<TreeNode<T>> queue = new LinkedQueue<>();  //创建一个队列
        queue.offer(root);    //将根结点丢进队列
        while (!queue.isEmpty()) {   //如果队列不为空，就一直不断地取出来
            TreeNode<T> node = queue.poll();   //取一个出来
            System.out.print(node.element);  //打印
            if(node.left != null) queue.offer(node.left);   //如果左右孩子不为空，直接将左右孩子丢进队列
            if(node.right != null) queue.offer(node.right);
        }
    }

    public static class TreeNode<E> {
        public E element;
        public TreeNode<E> left, right;

        public TreeNode(E element) {
            this.element = element;
        }
    }

}

