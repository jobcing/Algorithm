package datastructure;

import java.util.Scanner;

/**
 * Created by ByeongChan on 2018. 4. 2..
 *
 * 백준 알고리즘 5639번 풀이 (https://www.acmicpc.net/problem/5639)
 */

public class BOJ_5639 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();

        while(scan.hasNext()){
            try{
                int inputValue = scan.nextInt();
                bst.insertKey(inputValue);
            } catch(Exception e){
                break;
            }
        }

        bst.postOrder(bst.root);
    }

    private static class BinarySearchTree{

        private class Node{
            private int data;
            private Node left;
            private Node right;

            public Node(int data, Node left, Node right){
                this.data = data;
                this.left = left;
                this.right = right;
            }
        }

        private Node root;

        public BinarySearchTree(){
            this.root = null;
        }

        public void insertKey(int data){
            Node newNode = new Node(data, null, null);

            if(root == null){
                root = newNode;
                return;
            }

            Node curNode = root;
            Node parent = null;

            while(true){
                parent = curNode;

                if(curNode.data > newNode.data){
                    curNode = curNode.left;

                    if(curNode == null){
                        parent.left = newNode;
                        return;
                    }
                } else if(curNode.data < newNode.data){
                    curNode = curNode.right;

                    if(curNode == null){
                        parent.right = newNode;
                        return;
                    }
                } else{
                    return;
                }
            }
        }

        public void postOrder(Node root){
            if(root != null) {
                postOrder(root.left);
                postOrder(root.right);
                System.out.println(root.data);
            }
        }
    }
}
